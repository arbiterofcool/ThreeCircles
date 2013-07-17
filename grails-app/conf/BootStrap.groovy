import threecircles.User
import threecircles.Place
import threecircles.Comment
import threecircles.Checkin
import threecircles.UserRole
import threecircles.Role

class BootStrap {

    def init = { servletContext ->
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(firstname: "Corinne", lastname: "Krych", username: 'me', enabled: true, password: 'password')
        testUser.save()
        UserRole.create testUser, userRole, true

        User fabrice = new User(firstname: "Fabrice", lastname: "Matrat", username: "fabricematrat", password: "password", enabled: true);
        fabrice.save()
        UserRole.create fabrice, userRole, true

        User sebastien = new User(firstname: "Sebastien", lastname: "Blanc", username: "sebastienblanc", password: "password", enabled: true);
        sebastien.save()
        UserRole.create sebastien, userRole, true

        User mathieu = new User(firstname: "Mathieu", lastname: "Bruyen", username: "mathieubruyen", password: "password", enabled: true);
        mathieu.save()
        UserRole.create mathieu, userRole, true

        Place nice = new Place(name: "Nice", latitude:43.7, longitude: 7.2, address: "town center" )
        nice.save()

        Place madrid = new Place(name: "Madrid", latitude:40.41973002585687, longitude: -3.7075513757179124, address: "Calle Preciados 37" )
        madrid.save()

        Place copenhagen = new Place(name: "Copenhagen", latitude:55.659163935401104, longitude: 12.591153192520096, address:  "Rued Langgaards Vej 7, DK-2300 Copenhagen S" )
        copenhagen.save()

        Place minneapolis = new Place(name: "Minneapolis Convention Center",
                latitude: 44.96930003941189,
                longitude: -93.27280524253842,
                address:  "1301 2nd avenue S, MN55403" )
        minneapolis.save()


        testUser.addToFriends(fabrice)
        testUser.addToFriends(sebastien)
        testUser.save()

        Comment  comment1 = new Comment(text: """Great organization, thanks Soren""", user: testUser)
        comment1.save()
        Comment comment2 = new Comment(text: """Great conference, thanks Shaun. Cool to learn mobile stuff.""", user: testUser)
        comment2.save()

        Checkin gr8confus = new Checkin(description: "Gr8Conf US", when: new Date().time, place: minneapolis, owner: testUser, photo: "")
        gr8confus.save()
        gr8confus.addToFriends(fabrice)
        gr8confus.addToComments(comment2)
        gr8confus.save()

        Checkin gr8confeu = new Checkin(description: "Gr8Conf EU", when: (new Date() - 25).time, place: copenhagen, owner: testUser, photo:  "")
        gr8confeu.save()
        gr8confeu.addToFriends(fabrice)
        gr8confeu.addToComments(comment1)

        gr8confeu.save()

        Checkin greach = new Checkin(description: "greach", when: (new Date() - 69).time, place: madrid, owner: testUser, photo:  "")
        greach.save()
        greach.addToFriends(fabrice)

        greach.save()

    }
    def destroy = {
    }
}