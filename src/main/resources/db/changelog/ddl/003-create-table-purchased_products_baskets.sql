--liquibase formatted sql
--changeset FDuda:3

CREATE TABLE purchased_products_baskets (
    basket_id BIGINT REFERENCES baskets(id),
    product_id BIGINT REFERENCES products_db(id)
);