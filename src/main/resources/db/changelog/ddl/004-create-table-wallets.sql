--liquibase formatted sql
--changeset FDuda:4

CREATE TABLE wallets (
    id BIGINT PRIMARY KEY,
    balance DECIMAL(10,2) NOT NULL,
    owner VARCHAR(255) NOT NULL
);