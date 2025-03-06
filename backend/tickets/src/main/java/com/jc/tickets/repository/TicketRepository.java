package com.jc.tickets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicUuid(String uuid);
    Optional<List<Ticket>> findByCusUuid(String cusUuid);
}
