package com.example.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private Long timestamp;
    private Integer status;
    private String error;
    private String description;

}
