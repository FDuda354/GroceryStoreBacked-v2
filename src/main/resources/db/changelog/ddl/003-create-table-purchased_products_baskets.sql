--liquibase formatted sql
--changeset FDuda:3

CREATE TABLE purchased_products_baskets (
basket_id BIGSERIAL NOT NULL,
product_id BIGSERIAL NOT NULL,
FOREIGN KEY (basket_id) REFERENCES baskets(id),
FOREIGN KEY (product_id) REFERENCES products_db(id)
);
