-- Insert dummy data into customers table
INSERT INTO customers (uuid, email, password, full_name, created_at, created_by, updated_at, updated_by) VALUES
('f7298917-282a-4a47-b938-dde055f8564e', 'john.doe@example.com', 'password123', 'John Doe', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), 'jane.smith@example.com', 'password123', 'Jane Smith', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), 'alice.jones@example.com', 'password123', 'Alice Jones', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), 'bob.brown@example.com', 'password123', 'Bob Brown', CURRENT_TIMESTAMP(), 'admin', null, null);