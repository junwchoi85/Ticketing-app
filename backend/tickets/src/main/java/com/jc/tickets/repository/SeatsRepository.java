package com.jc.tickets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.tickets.entity.Seats;

public interface SeatsRepository extends JpaRepository<Seats, Long> {
    Optional<Seats> findBySeaUuid(String uuid);
    List<Seats> findByEveUuid(String eveUuid);
    Optional<Seats> findBySeatNumberAndEveUuid(String seatNumber, String eveUuid);
}
