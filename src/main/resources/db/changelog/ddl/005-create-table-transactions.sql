--liquibase formatted sql
--changeset FDuda:5

CREATE TABLE user_transactions (
    id BIGINT PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    wallet_id BIGINT REFERENCES wallets(id),
    direction VARCHAR(255) NOT NULL
);
