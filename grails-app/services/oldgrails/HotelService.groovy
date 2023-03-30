package oldgrails

import grails.gorm.transactions.Transactional

@Transactional
class HotelService {

    def save(Hotel hotel) {
        if (!hotel.save()) {
            hotel.errors.allErrors.each {
                println it
            }
        }
    }

    def delete(Hotel hotel) {
        if (!hotel.delete()) {
            hotel.errors.allErrors.each {
                println it
            }
        }
    }


    List<Hotel> queryHotelsWithName(String substring, Country country) {
        Hotel.findAllByCountry(country).findAll {
            x->x.name.toLowerCase().indexOf(substring.toLowerCase())>-1
        }
    }

}
