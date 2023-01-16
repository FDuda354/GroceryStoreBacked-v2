--liquibase formatted sql
--changeset FDuda:6

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_enable BOOLEAN NOT NULL,
    basket_id BIGINT REFERENCES baskets(id),
    wallet_id BIGINT REFERENCES wallets(id),
    role VARCHAR(255) NOT NULL
);
