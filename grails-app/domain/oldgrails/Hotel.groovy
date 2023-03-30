package oldgrails

class Hotel {
    String name;
    Integer stars
    String webSite
    static belongsTo = [country: Country]
    static constraints = {
        name size: 1..255;
        stars inList: [1,2,3,4,5]
        webSite nullable: true, url: true
    }

}
