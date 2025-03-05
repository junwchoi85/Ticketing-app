-- Insert dummy data into event table
INSERT INTO event (eve_uuid, title, description, venue, created_at, created_by, updated_at, updated_by) VALUES
(RANDOM_UUID(), 'Concert A', 'Description for Concert A', 'Venue A', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), 'Concert B', 'Description for Concert B', 'Venue B', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), 'Concert C', 'Description for Concert C', 'Venue C', CURRENT_TIMESTAMP(), 'admin', null, null);

-- Insert dummy data into seat table
INSERT INTO seat (sea_uuid, eve_uuid, seat_number, row_number, status, reserved_by, reserved_until, created_at, created_by, updated_at, updated_by) VALUES
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert A'), 'A1', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert A'), 'A2', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert B'), 'B1', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert B'), 'B2', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert C'), 'C1', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert C'), 'C2', '1', 'AVAILABLE', null, null, CURRENT_TIMESTAMP(), 'admin', null, null);

-- Insert dummy data into ticket table
INSERT INTO ticket (tic_uuid, eve_uuid, sea_uuid, cus_uuid, purchase_date, payment_status, created_at, created_by, updated_at, updated_by) VALUES
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert A'), (SELECT sea_uuid FROM seat WHERE seat_number = 'A1' AND row_number = '1'), 'f7298917-282a-4a47-b938-dde055f8564e', CURRENT_TIMESTAMP(), 'PENDING', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert A'), (SELECT sea_uuid FROM seat WHERE seat_number = 'A2' AND row_number = '1'), 'f7298917-282a-4a47-b938-dde055f8564e', CURRENT_TIMESTAMP(), 'PENDING', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert B'), (SELECT sea_uuid FROM seat WHERE seat_number = 'B1' AND row_number = '1'), 'f7298917-282a-4a47-b938-dde055f8564e', CURRENT_TIMESTAMP(), 'PENDING', CURRENT_TIMESTAMP(), 'admin', null, null),
(RANDOM_UUID(), (SELECT eve_uuid FROM event WHERE title = 'Concert B'), (SELECT sea_uuid FROM seat WHERE seat_number = 'B2' AND row_number = '1'), 'f7298917-282a-4a47-b938-dde055f8564e', CURRENT_TIMESTAMP(), 'PENDING', CURRENT_TIMESTAMP(), 'admin', null, null);