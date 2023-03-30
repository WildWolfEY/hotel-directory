package oldgrails

class HotelController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    HotelService hotelService
    def index(Long selectedCountry) {
        Country country
        if (selectedCountry != null) {
            country = Country.findById(selectedCountry)
        } else {
            country = Country.first();
        }
        respond([countries: Country.all, country: country])
    }

    def updateHotel(Long id, String name, Integer stars, Long selectedCountryId, String webSite) {
        Country country = Country.findById(selectedCountryId)
        Hotel hotel = Hotel.findById(id);
        hotel.name = name;
        hotel.stars = stars;
        hotel.country = country;
        hotel.webSite = webSite == null || webSite.isBlank() ? null : webSite;
        hotelService.save(hotel);
        redirect(controller: "hotel", params: [selectedCountry: country.id])
    }

    def addHotel(Long countryId, String name, Integer stars, String webSite) {
        Country country = Country.findById(countryId);
        Hotel hotel = new Hotel(name: name,
                stars: stars,
                webSite: (webSite == null || webSite.isBlank()) ? null : webSite,
                country: country
        )
        hotelService.save(hotel);

        redirect(controller: "hotel", params: [selectedCountry: country.id])
    }

    def deleteHotel(int id) {
        Hotel hotel = Hotel.findById(id)
        Country country = hotel.country
        hotelService.delete(hotel)

        redirect(controller: "hotel", params: [selectedCountry: country.id])
    }
}
