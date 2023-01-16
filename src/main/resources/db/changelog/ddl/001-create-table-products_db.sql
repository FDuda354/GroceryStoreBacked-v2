--liquibase formatted sql
--changeset FDuda:1

CREATE TABLE products_db (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    price NUMERIC(10,2) NOT NULL
);