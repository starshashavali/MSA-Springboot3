package com.asit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asit.domain.Ticket;
import com.asit.dto.PassengersRequest;
import com.asit.dto.TicketResponse;
import com.asit.exception.IdNotFoundException;
import com.asit.repo.TicketRepo;
import com.asit.service.ITicketService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ITicketServiceImpl implements ITicketService {

	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public TicketResponse bookTicket(PassengersRequest request) {
		log.info("request to save::"+request);
		Ticket entity = new Ticket();
		BeanUtils.copyProperties(request, entity);
		entity.setStatus("Successfully ticket booked...");
		entity.setTotalPrice(request.getPrice()*request.getNoOfPersons());
		Ticket save = ticketRepo.save(entity);
		TicketResponse response = new TicketResponse();
		BeanUtils.copyProperties(save, response);
		return response;
	}

	@Override
	public TicketResponse getTcketResponse(Integer id) {
		log.info("request to getTcketResponse::"+id);
		Ticket entity = ticketRepo.findById(id).orElseThrow(() -> new IdNotFoundException("IdNotFound::" + id));
		TicketResponse ticketDto = new TicketResponse();
		BeanUtils.copyProperties(entity, ticketDto);
		return ticketDto;
	}

	@Override
	public List<TicketResponse> getAllTickets() {
		log.info("request to getAllTickets::");

		List<Ticket> list = ticketRepo.findAll();
		List<TicketResponse> dtos = new ArrayList<>();
		for (Ticket entity : list) {
			TicketResponse dto = new TicketResponse();
			BeanUtils.copyProperties(entity, dto);
			dtos.add(dto);
		}

		return dtos;
	}

}
