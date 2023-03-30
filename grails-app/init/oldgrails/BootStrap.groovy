package oldgrails

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {
    HotelService hotelService
    def init = { servletContext ->
        Country russia = new Country(name: 'Россия', capital: 'Москва')
        Country sriLanka = new Country(name: 'Шри-Ланка', capital: 'Коломбо')
        Country ukraine = new Country(name: 'Украина', capital: 'Киев')
        russia.save();
        sriLanka.save();
        ukraine.save();

        hotelService.save(new Hotel(name: 'Олимпос', country: russia, stars: 3, webSite: 'https://olimpos.ru'))
        hotelService.save(new Hotel(name: 'Черчель', country: russia, stars: 2, webSite: 'https://44.ru'))
        hotelService.save(new Hotel(name: 'Моя душа', country: sriLanka, stars: 4))
        hotelService.save(new Hotel(name: 'Шаман', country: russia, stars: 3, webSite: 'https://shaman.ru'))
        hotelService.save(new Hotel(name: 'Вилла', country: sriLanka, stars: 5, webSite: 'https://village.ru'))
        hotelService.save(new Hotel(name: 'Гости', country: russia, stars: 1))
        hotelService.save(new Hotel(name: 'Шаль', country: ukraine, stars: 3))
        hotelService.save(new Hotel(name: 'Тотошка', country: russia, stars: 2, webSite: 'https://toto.ru'))
        hotelService.save(new Hotel(name: 'Машина', country: russia, stars: 5, webSite: 'https://car.ru'))
        hotelService.save(new Hotel(name: 'Звезда', country: ukraine, stars: 5))
        hotelService.save(new Hotel(name: 'Омикрон', country: ukraine, stars: 4, webSite: 'https://omikron.ru'))

    }
    def destroy = {
    }
}
