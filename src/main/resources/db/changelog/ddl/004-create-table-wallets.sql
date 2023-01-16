--liquibase formatted sql
--changeset FDuda:4

CREATE TABLE wallets (
    id BIGSERIAL PRIMARY KEY,
    balance NUMERIC(10,2) NOT NULL,
    owner VARCHAR(255) NOT NULL
);