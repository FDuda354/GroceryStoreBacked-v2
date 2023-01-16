--liquibase formatted sql
--changeset FDuda:5

CREATE TABLE user_transactions (
    id BIGSERIAL PRIMARY KEY,
    amount NUMERIC(10,2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    wallet_id BIGSERIAL REFERENCES wallets(id),
    direction VARCHAR(255) NOT NULL
);