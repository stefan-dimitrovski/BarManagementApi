INSERT INTO public.locales (address, lat, lng, name)
VALUES ('Boulevard Phillip the Second of Macedon 14, Skopje 1000', '41.9972546654559', '21.418529735959524',
        'Old City House'),
       ('1-vi Maj Boulevard b.b, Bitola 7000', '41.030889', '21.333390', 'Bakery Boulevard');


INSERT INTO public.users (email, name, password, phone_number, role)
VALUES ('manager@test.com', 'Manager', '$2a$10$y35X.5dJGcFz.00jc2QtTujW7BkofmwvJccQrmewJYH8gTc.aQkZC', 'manager',
        'MANAGER'),
       ('waiter@test.com', 'Waiter', '$2a$10$sCRTfjiB5JzuPPftNrHEseKAWHQevGTYvxiRdNtz9lkwZOjOn8t0S', 'waiter',
        'WAITER');

INSERT INTO public.tables (id, waiter_id)
VALUES (1, 1),
       (2, null),
       (3, null),
       (4, null),
       (5, null),
       (6, 1),
       (7, null),
       (9, null),
       (10, null),
       (11, null),
       (12, null),
       (13, null);
