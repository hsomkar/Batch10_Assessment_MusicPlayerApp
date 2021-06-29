package com.te.mp.controller;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.mp.dto.ResponseDTO;

@RestControllerAdvice
public class ItemRestControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseDTO handleSearch(NoSuchElementException exception) {
		ResponseDTO response = new ResponseDTO();
		response.setStatusCode(500);
		response.setMessage(exception.getMessage());
		return response;
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseDTO handleDelete(EmptyResultDataAccessException exception) {
		ResponseDTO response = new ResponseDTO();
		response.setStatusCode(500);
		response.setMessage(exception.getMessage());
		return response;
	}
}