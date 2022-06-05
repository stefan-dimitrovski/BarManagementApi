CREATE VIEW active_orders_per_waiter as
SELECT ord.id               as order_id,
       ord.opened_at        as opened_at,
       ord.closed_at        as closed_at,
       ord.table_id         as table_id,
       ord.waiter_id        as waiter_id,
       u.works_in_locale_id as works_at
FROM ORDERS ord
         JOIN USERS u ON ord.waiter_id = u.id;

CREATE VIEW order_view as
SELECT ord.id        as order_id,
       ord.opened_at as opened_at,
       ord.closed_at as closed_at,
       ord.table_id  as table_id,
       u.name        as waiter_name,
       d.id          as drink_id,
       d.brand_name  as drink_name,
       d.category    as drink_category,
       d.price       as drink_price,
       dio.quantity  as quantity
FROM ORDERS ord
         JOIN users as u ON ord.waiter_id = u.id
         JOIN drinks_in_order dio ON ord.id = dio.order_id
         JOIN drinks d ON dio.drink_id = d.id;

CREATE VIEW total_price_view as
SELECT ord.id                      as order_id,
       sum(d.price * dio.quantity) as total_price
FROM ORDERS ord
         JOIN users as u ON ord.waiter_id = u.id
         JOIN drinks_in_order dio ON ord.id = dio.order_id
         JOIN drinks d ON dio.drink_id = d.id
group by ord.id;