create table account (
    id bigint not null,
    city varchar(255),
    street varchar(255),
    zip_code varchar(255),
    created_at timestamp,
    email varchar(255),
    modified_at timestamp,
    nickname varchar(255),
    password varchar(255),
    phone varchar(255),
    status varchar(255),
    primary key (account_id));

create table account_account_role (
    account_id bigint not null,
     account_role varchar(255));

    create table category (
       category_id bigint not null,
        name varchar(255),
        primary key (category_id));

    create table item (
       item_id bigint not null,
        name varchar(255),
        price integer not null,
        stock_quantity integer not null,
        primary key (item_id));

    create table item_category (
       item_category_id bigint not null,
        category_id bigint,
        item_id bigint,
        primary key (item_category_id));

    create table orders (
       order_id bigint not null,
        order_at datetime,
        status varchar(255),
        account_id bigint,
        delivery_id bigint,
        primary key (order_id));

    create table order_item (
       order_item_id bigint not null,
        count integer not null,
        order_price integer not null,
        item_id bigint,
        order_id bigint,
        primary key (order_item_id));

    create table delivery (
       delivery_id bigint not null,
        city varchar(255),
        street varchar(255),
        zip_code varchar(255),
        status varchar(255),
        primary key (delivery_id));