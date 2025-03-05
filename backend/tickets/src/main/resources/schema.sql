-- Table: event
CREATE TABLE event (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    eve_uuid VARCHAR(36) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    venue VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL,
    UNIQUE (eve_uuid) -- Added unique constraint
);

-- Table: seat
CREATE TABLE seat (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sea_uuid VARCHAR(36) NOT NULL,
    eve_uuid VARCHAR(36) NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    row_number VARCHAR(10) NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'AVAILABLE',  -- Changed ENUM to VARCHAR
    reserved_by BIGINT NULL,            -- User ID who reserved the seat, if applicable
    reserved_until TIMESTAMP NULL,         -- Optional expiration time for the reservation
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL,
    UNIQUE (sea_uuid), -- Added unique constraint
    FOREIGN KEY (eve_uuid) REFERENCES event(eve_uuid)
);

-- Table: ticket
CREATE TABLE ticket (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tic_uuid VARCHAR(36) NOT NULL,
    eve_uuid VARCHAR(36) NOT NULL,
    sea_uuid VARCHAR(36) NOT NULL,
    cus_uuid VARCHAR(36) NOT NULL, -- Customer UUID from the customers table
    purchase_date TIMESTAMP NOT NULL,
    payment_status VARCHAR(10) DEFAULT 'PENDING',  -- Changed ENUM to VARCHAR
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT NULL,
    UNIQUE (tic_uuid), -- Added unique constraint
    FOREIGN KEY (eve_uuid) REFERENCES event(eve_uuid),
    FOREIGN KEY (sea_uuid) REFERENCES seat(sea_uuid)
);