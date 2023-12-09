package com.asit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asit.domain.Ticket;

public interface TicketRepo  extends JpaRepository<Ticket, Integer>{

}
