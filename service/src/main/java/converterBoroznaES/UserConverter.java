package converterBoroznaES;

import dtoBoroznaES.UserDTO;
import modelBoroznaES.User;

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