package com.jc.tickets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.tickets.entity.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    Optional<Tickets> findByTicUuid(String uuid);
    Optional<Tickets> findByCusUuid(String cusUuid);
}
