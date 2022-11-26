package com.infy.bookmyshowcrud.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.infy.bookmyshowcrud.app.exception.ApiError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	private Integer code;
	private String message;
	private Date timesDate;
	private String path;
	private HttpStatus error;
	private String trace;

}