package com.atomtech.usermanagement.dto;
//import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

//  @NotBlank(message = "First name is required")
    private String firstName;
    private String lastName;
}

