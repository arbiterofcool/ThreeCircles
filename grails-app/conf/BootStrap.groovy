import threecircles.User
import threecircles.Place
import threecircles.Comment
import threecircles.Checkin

class BootStrap {

    def init = { servletContext ->

        //-----------------------------------------------------------------------------
        // TODO create several users
        // To create a user, used named parameter
        // and saved it as below:
        // def myUser = new User(firstname: "Corinne", lastname: "Krych", username: 'me', enabled: true, password: 'password')
        // myUser.save()
        //
        // TODO the same for Place, Comment, Checkin
        // For Minneapolis latitude:48.83, longitude: 93.47
        //
        // Do not forget to add a checkin for this conference
        //-----------------------------------------------------------------------------
    }
    def destroy = {
    }
}
