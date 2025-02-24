CREATE TABLE notifications (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    user_id BIGINT NOT NULL,
    notification_type VARCHAR(10) NOT NULL,  -- Changed ENUM to VARCHAR
    message TEXT NOT NULL,
    status VARCHAR(10) DEFAULT 'PENDING',  -- Changed ENUM to VARCHAR
    sent_at TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);