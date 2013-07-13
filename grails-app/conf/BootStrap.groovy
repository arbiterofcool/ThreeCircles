import threecircles.User
import threecircles.Place
import threecircles.Comment
import threecircles.Checkin

class BootStrap {

    def init = { servletContext ->

        def testUser = new User(firstname: "Corinne", lastname: "Krych", username: 'me', enabled: true, password: 'password')
        testUser.save()

        User fabrice = new User(firstname: "Fabrice", lastname: "Matrat", username: "fabricematrat", password: "password", enabled: true);
        fabrice.save()

        User sebastien = new User(firstname: "Sebastien", lastname: "Blanc", username: "sebastienblanc", password: "password", enabled: true);
        sebastien.save()

        User mathieu = new User(firstname: "Mathieu", lastname: "Bruyen", username: "mathieubruyen", password: "password", enabled: true);
        mathieu.save()

        Place nice = new Place(name: "Nice", latitude:43.7, longitude: 7.2, address: "town center" )
        nice.save()

        Place madrid = new Place(name: "Nice", latitude:40.41973002585687, longitude: -3.7075513757179124, address: "Calle Preciados 37" )
        madrid.save()

        Place paris = new Place(name: "Paris", latitude:48.8, longitude: 2.3, address:  "13 rue richard lenoir" )
        paris.save()

        Place minneapolis = new Place(name: "Minneapolis", latitude:48.83, longitude: 93.47, address:  "Gr8Conf US " )
        minneapolis.save()


        testUser.addToFriends(fabrice)
        testUser.addToFriends(sebastien)
        testUser.save()

        Comment comment = new Comment(text: """brrrrrr""", user: testUser)
        comment.save()
        Comment comment2 = new Comment(text: """great conference.
            Cool to meet female speaker""", user: testUser)
        comment2.save()

        Checkin gr8conf = new Checkin(description: "Gr8Conf", when: new Date().time, place: minneapolis, owner: testUser, photo: "")
        gr8conf.save()
        gr8conf.addToFriends(fabrice)
        gr8conf.save()


        Checkin devfestw = new Checkin(description: "devfestw", when: (new Date() - 25).time, place: paris, owner: testUser, photo:  "")
        devfestw.save()
        devfestw.addToFriends(fabrice)
        devfestw.addToComments(comment)
        devfestw.addToComments(comment2)

        devfestw.save()

        Checkin greach = new Checkin(description: "greach", when: (new Date() - 69).time, place: madrid, owner: testUser, photo:  "")
        greach.save()
        greach.addToFriends(fabrice)
        greach.addToComments(comment)
        greach.addToComments(comment2)

        greach.save()

    }
    def destroy = {
    }
}
