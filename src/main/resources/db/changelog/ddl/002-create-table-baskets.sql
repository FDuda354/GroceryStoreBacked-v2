--liquibase formatted sql
--changeset FDuda:2

CREATE TABLE baskets (
    id BIGINT PRIMARY KEY,
    owner VARCHAR(255) NOT NULL
);
