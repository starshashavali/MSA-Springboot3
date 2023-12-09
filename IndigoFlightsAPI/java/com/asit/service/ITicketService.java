package com.asit.service;

import java.util.List;

import com.asit.dto.PassengersRequest;
import com.asit.dto.TicketResponse;

public interface ITicketService {

	public TicketResponse bookTicket(PassengersRequest request);

	public TicketResponse getTcketResponse(Integer id);

	public List<TicketResponse> getAllTickets();

}
