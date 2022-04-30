INSERT INTO locales (address, lat, lng, name)
VALUES ('Boulevard Phillip the Second of Macedon 14, Skopje 1000', '41.9972546654559', '21.418529735959524',
        'Old City House'),
       ('1-vi Maj Boulevard b.b, Bitola 7000', '41.030889', '21.333390', 'Bakery Boulevard');


INSERT INTO users (email, name, password, phone_number, role, date_employed)
VALUES ('manager@test.com', 'Manager', '$2a$10$y35X.5dJGcFz.00jc2QtTujW7BkofmwvJccQrmewJYH8gTc.aQkZC', 'manager',
        'MANAGER', now()),
       ('waiter1@test.com', 'Waiter', '$2a$10$sCRTfjiB5JzuPPftNrHEseKAWHQevGTYvxiRdNtz9lkwZOjOn8t0S', 'waiter',
        'WAITER', now()),
       ('waiter2@test.com', 'Waiter', '$2a$10$43sjRwzwAVBxiCBmEpWT2eY1ck81n2RIvtRn0ZYyjR6.3OuSjHmo6', 'waiter',
        'WAITER', now());


INSERT INTO drinks (brand_name, category, price)
VALUES ('Jameson', 'WHISKEY', 200),
       ('Absolut', 'VODKA', 180),
       ('Skopsko', 'BEER', 100);


INSERT INTO tables (id, waiter_id)
VALUES (1, null),
       (2, null),
       (3, null),
       (4, null),
       (5, null),
       (6, null),
       (7, null),
       (8, null),
       (9, null),
       (10, null),
       (11, null),
       (12, null),
       (13, null);
