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
@Table(name = "ticket")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tic_uuid", unique = true, nullable = false)
    private String ticUuid;

    private String eveUuid;
    private String seaUuid;
    private String cusUuid;
    private LocalDateTime purchaseDate;
    private String paymentStatus;

    @PrePersist
    protected void onCreate() {
        if (ticUuid == null) {
            ticUuid = UUID.randomUUID().toString();
        }
    }
}
