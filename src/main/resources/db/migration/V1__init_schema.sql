create table locales
(
    id      bigserial primary key,
    address varchar(255)     not null,
    lat     double precision not null,
    lng     double precision not null,
    name    varchar(255)     not null
);

create table drinks
(
    id         bigserial primary key,
    brand_name varchar(255)     not null,
    category   varchar(255)     not null,
    price      double precision not null
);

create table users
(
    id                 bigserial primary key,
    email              varchar(255) unique not null,
    name               varchar(255)        not null,
    password           varchar(255)        not null,
    phone_number       varchar(255)        not null,
    role               varchar(255)        not null,
    works_in_locale_id bigint,
    date_employed      timestamp           not null,

    constraint fk_locale foreign key (works_in_locale_id) references locales (id)

);

create table tables
(
    id        bigserial primary key,
    waiter_id bigint,
    constraint fk_waiter foreign key (waiter_id) references users (id)
);

create table orders
(
    id        bigserial not null primary key,
    opened_at timestamp not null,
    closed_at timestamp,
    table_id  bigint    not null,
    waiter_id bigint    not null,
    constraint fk_table foreign key (table_id) references tables (id),
    constraint fk_waiter foreign key (waiter_id) references users (id)

);

create table drinks_in_order
(
    id       bigserial primary key,
    drink_id bigint  not null,
    order_id bigint  not null,
    quantity integer not null,
    constraint fk_drink foreign key (drink_id) references drinks (id),
    constraint fk_order foreign key (order_id) references orders (id)
);

create table storage
(
    id        bigserial primary key,
    quantity  integer not null,
    drink_id  bigint  not null,
    locale_id bigint  not null,

    constraint fk_drink foreign key (drink_id) references drinks (id),
    constraint fk_locale foreign key (locale_id) references locales (id)
);
