package com.asit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PassenegerDtls")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
