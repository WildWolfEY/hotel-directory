package oldgrails

class MainController {
    HotelService hotelService

    def index(Long selectedCountry, String filter) {
        Country country
        if (selectedCountry != null) {
            country = Country.findById(selectedCountry)
        } else {
            country = Country.first();
        }
        List<Hotel> hotels = country.hotels.asList().sort {}
        if (filter != null) {
            hotels = hotelService.queryHotelsWithName(filter, country)
        }
        hotels.sort(new Comparator<Hotel>() {
            @Override
            int compare(Hotel o1, Hotel o2) {
                return o2.stars.compareTo(o1.stars) == 0 ? o1.name.compareTo(o2.name) : o2.stars.compareTo(o1.stars)
            }
        })
        respond([countries: Country.all, country: country, hotels: hotels])
    }

}