import pl.coderslab.entity.User;

public class MainDAO {
    private static User[] users;

    public static void main(String[] args) {



        //ADDING USER INTO USERS TABLE.
/*        UserDAO userDAO = new UserDAO();
        User user = new User();
        user.setUserName("BOB");
        user.setEmail("PARTACZ@MGIAL.CHUJ");
        user.setPassword("jebacc");
        UserDAO.create(user);*/

//        User read = UserDAO.read(1); //reading line with id 1
//        System.out.println(read);
//        User read2 = UserDAO.read(2); //record does not exist, so returns NULL
//        System.out.println(read2); // PRINTING NULL

/*        User userToUpdate = UserDAO.read(2); //updating user ID 2 with new name
        userToUpdate.setUserName("SIEMAAAAA");
        UserDAO.update(userToUpdate);*/

       User[] all = UserDAO.findAll();  //print all record (print code located inside
        // /addToArray method in DbUtil class

       // UserDAO.delete(3);






    }
}
