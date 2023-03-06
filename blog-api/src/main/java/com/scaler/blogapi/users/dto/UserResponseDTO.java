package com.scaler.blogapi.users.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UserResponseDTO {
    Integer id;
    String username;
    String email;
    String bio;
    String image;
}
