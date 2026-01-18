package com.sm.smartEmail.entities;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailRequest {
    private String emailContent;
    private String emailTone;

}

