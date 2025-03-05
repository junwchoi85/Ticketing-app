package com.jc.tickets.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "seat")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sea_uuid", unique = true, nullable = false)
    private String seaUuid;
    private String eveUuid;
    private String seatNumber;
    private String rowNumber;
    private String status;
    private Long reservedBy;
    private LocalDateTime reservedUntil;

    @PrePersist
    protected void onCreate() {
        if (seaUuid == null) {
            seaUuid = UUID.randomUUID().toString();
        }
    }
}
