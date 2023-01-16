--liquibase formatted sql
--changeset FDuda:3

create TABLE orders (
    id BIGINT PRIMARY KEY,
    quantity BIGINT,
    basket_id BIGINT REFERENCES baskets(id),
    product_id BIGINT REFERENCES products_db(id)
);