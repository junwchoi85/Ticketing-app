-- Table: events
CREATE TABLE events (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    venue VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL
);

-- Table: seats
CREATE TABLE seats (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    event_id BIGINT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    row_number VARCHAR(10) NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'AVAILABLE',  -- Changed ENUM to VARCHAR
    reserved_by BIGINT NULL,            -- User ID who reserved the seat, if applicable
    reserved_until TIMESTAMP NULL,         -- Optional expiration time for the reservation
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL,
    FOREIGN KEY (event_id) REFERENCES events(id)
);

-- Table: tickets
CREATE TABLE tickets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    event_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    purchase_date TIMESTAMP NOT NULL,
    payment_status VARCHAR(10) DEFAULT 'PENDING',  -- Changed ENUM to VARCHAR
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL,
    FOREIGN KEY (event_id) REFERENCES events(id),
    FOREIGN KEY (seat_id) REFERENCES seats(id)
);