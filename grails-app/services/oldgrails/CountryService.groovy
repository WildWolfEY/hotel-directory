package oldgrails

import grails.gorm.transactions.Transactional

@Transactional
class CountryService {

    def save(Country country){
        if (!country.save()) {
            country.errors.allErrors.each {
                println it
            }
        }
    }
    def delete(Country country){
        if (!country.delete()) {
            country.errors.allErrors.each {
                println it
            }
        }
    }
}
