package converter;

import dto.UserDTO;
import model.User;

public class UserConverter {
    public UserDTO converteUserToUserDTO(User user) {
        return UserDTO.newBuilder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}