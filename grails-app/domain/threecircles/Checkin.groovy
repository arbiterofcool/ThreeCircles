package threecircles

class Checkin {
    String description
    Long when
    Place place
    User owner
    //-----------------------------------------------------------------------------
    //  TODO 1: picture
    //-----------------------------------------------------------------------------


    static hasMany = [friends:User, comments:Comment]

    //-----------------------------------------------------------------------------
    //  TODO 2: picture
    //-----------------------------------------------------------------------------
    static constraints = {

    }
}
