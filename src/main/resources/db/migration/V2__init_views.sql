CREATE VIEW active_orders_per_waiter as
SELECT ord.id               as order_id,
       ord.opened_at        as opened_at,
       ord.closed_at        as closed_at,
       ord.table_id         as table_id,
       ord.waiter_id        as waiter_id,
       u.works_in_locale_id as works_at
FROM ORDERS ord
         JOIN USERS u ON ord.waiter_id = u.id