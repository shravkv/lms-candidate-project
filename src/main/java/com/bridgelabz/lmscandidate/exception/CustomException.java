package com.bridgelabz.lmscandidate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Purpose : CustomException are Used to Validation exception
 * Version : 1.0
 * @author : Sravan Kumar
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException {

    private int errorCode;
    private String message;
}
