package com.asit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asit.dto.PassengersRequest;
import com.asit.dto.TicketResponse;
import com.asit.service.ITicketService;

@RestController
@RequestMapping("/flight/api")
public class TicketRestController {
	
	@Autowired
	private ITicketService ticketService;
	
	@PostMapping("/save")
	public ResponseEntity<?> bookTicket(@RequestBody PassengersRequest request){
		TicketResponse bookStatus = ticketService.bookTicket(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookStatus);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getTicket(@PathVariable Integer id){
		TicketResponse bookStatus = ticketService.getTcketResponse(id);
		return ResponseEntity.status(HttpStatus.OK).body(bookStatus);
	}
	
	@GetMapping("/allTickets")
	public ResponseEntity<?> getAlTickets(){
		 List<TicketResponse> tickets = ticketService.getAllTickets();
		return ResponseEntity.status(HttpStatus.OK).body(tickets);
	}

}
