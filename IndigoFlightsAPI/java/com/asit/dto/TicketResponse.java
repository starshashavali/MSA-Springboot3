package com.asit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
	
	private Integer id;
	private String name;
	private String phoneNumber;
	private String email;
	private String currentLocation;
	private String destination;
	private String onBoard;
	private String flightNum;
	private Integer noOfPersons;
	private Double price;
	private String status;
	private  Double totalPrice;
	
	

}
