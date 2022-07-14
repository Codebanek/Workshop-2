import pl.coderslab.entity.User;

public class MainDAO {
    public static void main(String[] args) {
/*        User user1 = new User();
        user1.setEmail("seb@gmail.com");
        user1.setUserName("SEB");
        user1.setPassword("flaki123");
        UserDAO.create(user1);*/

/*        User user2 = new User();
        user2.setEmail("dupakalaaklak@gmail.com");
        user2.setUserName("Bobkeck");
        user2.setPassword("ytytytyty123");
        UserDAO.create(user2);*/

   ;
        User[] users = new User[1];
        users[0] = UserDAO.read(5);
        System.out.println(users[0].getId());
        //kurde dziala!

    }
}
