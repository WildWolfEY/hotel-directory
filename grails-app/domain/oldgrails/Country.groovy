package oldgrails

class Country {
    String name
    String capital
    static hasMany=[hotels:Hotel]
    static mapping = {
        hotels cascade: 'all-delete-orphan'
    }
    static constraints = {
        name size: 1..255, unique: true
        capital size: 1..128
    }
}
