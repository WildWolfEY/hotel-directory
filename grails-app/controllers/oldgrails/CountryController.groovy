package oldgrails

class CountryController {
    CountryService countryService;
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        respond([countries: Country.all])
    }

    def updateCountry(Integer id, String name, String capital) {
        Country country = Country.findById(id)
        country.name = name
        country.capital = capital
        countryService.save(country)
        redirect action: 'index'
    }

    def addCountry(String name, String capital) {
        Country country = new Country(name: name, capital: capital)
        countryService.save(country);
        redirect action: 'index'
    }

    def deleteCountry(int id) {
        Country country = Country.findById(id)
        countryService.delete(country);
        redirect action: 'index'
    }
}
