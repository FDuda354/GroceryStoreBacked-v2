--liquibase formatted sql
--changeset FDuda:8

create sequence hibernate_sequence;
alter sequence hibernate_sequence RESTART WITH 501;
alter sequence hibernate_sequence owner to filip;

