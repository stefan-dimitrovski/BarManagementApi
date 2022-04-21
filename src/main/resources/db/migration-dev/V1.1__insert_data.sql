INSERT INTO public.locales (address, lat, lng, name)
VALUES ('Boulevard Phillip the Second of Macedon 14, Skopje 1000', '41.9972546654559', '21.418529735959524',
        'Old City House');
INSERT INTO public.locales (address, lat, lng, name)
VALUES ('1-vi Maj Boulevard b.b, Bitola 7000', '41.030889', '21.333390', 'Bakery Boulevard');


INSERT INTO public.users (email, name, password, phone_number, role)
VALUES ('andrej@gmail.com', 'Andrej', '$2a$10$LTObmzdJW46etz1MwbEGS.hOFztzwrf1o09EWu3z4UxgfSWF0Bayy', 'test', 'WAITER'),
       ('manager@test.com', 'Manager', '$2a$10$LTObmzdJW46etz1MwbEGS.hOFztzwrf1o09EWu3z4UxgfSWF0Bayy', 'manager',
        'MANAGER');


INSERT INTO public.tables (id, waiter_id)
VALUES (1, 1);
INSERT INTO public.tables (id, waiter_id)
VALUES (2, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (3, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (4, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (5, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (6, 1);
INSERT INTO public.tables (id, waiter_id)
VALUES (7, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (8, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (9, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (10, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (11, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (12, null);
INSERT INTO public.tables (id, waiter_id)
VALUES (13, null);
