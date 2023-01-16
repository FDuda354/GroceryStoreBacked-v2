--liquibase formatted sql
--changeset FDuda:1

CREATE TABLE products_db (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);