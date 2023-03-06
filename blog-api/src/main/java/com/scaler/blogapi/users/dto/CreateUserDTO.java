package com.scaler.blogapi.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateUserDTO {

    private String email;
    private String username;
    private String password;

}
