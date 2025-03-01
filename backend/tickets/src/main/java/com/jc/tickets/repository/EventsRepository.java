package com.jc.tickets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.tickets.entity.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {
    Optional<Events> findByTitle(String title);
}
