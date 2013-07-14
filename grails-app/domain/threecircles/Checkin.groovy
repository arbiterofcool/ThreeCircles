package threecircles

class Checkin {
    String description
    Long when
    Place place
    User owner
    //-----------------------------------------------------------------------------
    //  TODO 1: picture
    //-----------------------------------------------------------------------------
    byte[] photo

    static hasMany = [friends:User, comments:Comment]

    //-----------------------------------------------------------------------------
    //  TODO 2: picture
    //-----------------------------------------------------------------------------
    static constraints = {
        photo maxSize: 20*1024*1024, nullable: true
    }
}
