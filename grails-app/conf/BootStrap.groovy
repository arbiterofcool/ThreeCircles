import threecircles.User
import threecircles.Place
import threecircles.Comment
import threecircles.Checkin
import com.sun.xml.internal.rngom.ast.util.CheckingSchemaBuilder

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
        // For Minneapolis
        // latitude: 44.96930003941189,
        // longitude: -93.27280524253842
        //
        // Do not forget to add a checkin for this conference
        //-----------------------------------------------------------------------------

    }
    def destroy = {
    }
}
