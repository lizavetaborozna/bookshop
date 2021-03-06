package serviceBoroznaES;

import modelBoroznaES.User;

import java.util.List;

public interface UserService {
    boolean isUserValid(String username, String password);
    boolean addUser(String username, String password);
    String getUserRole(String username);
    List<User> getListAllUser();
    void deleteUser(int idUser);
}
