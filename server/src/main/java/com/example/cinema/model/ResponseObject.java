package com.example.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
