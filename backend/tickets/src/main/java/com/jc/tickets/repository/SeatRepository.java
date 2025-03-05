package com.jc.tickets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.tickets.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeaUuid(String uuid);
    List<Seat> findByEveUuid(String eveUuid);
    Optional<Seat> findBySeatNumberAndEveUuid(String seatNumber, String eveUuid);
}
