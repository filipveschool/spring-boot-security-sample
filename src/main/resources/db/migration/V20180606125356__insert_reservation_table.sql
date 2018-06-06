INSERT INTO reservation (user_id, party_size, date, restaurant_id)
VALUES (100, 2, NOW(), 800),
       (101, 3, NOW() + INTERVAL 1 DAY, 800),
       (102, 5, NOW() + INTERVAL 2 DAY, 800)