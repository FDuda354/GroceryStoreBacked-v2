--liquibase formatted sql
--changeset FDuda:7

CREATE TABLE verification_tokens (
    id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255) NOT NULL,
    user_id BIGINT REFERENCES users(id)
);