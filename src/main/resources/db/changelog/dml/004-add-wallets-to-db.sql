--liquibase formatted sql
--changeset FDuda:12

INSERT INTO wallets(id, balance,owner)
VALUES
(1,10000, 'filip'),
(2,10000,'patryk'),
(3,10000,'kamil'),
(4,10000,'ania'),
(5,10000,'tomasz'),
(6,10000,'agnieszka'),
(7,10000,'piotr'),
(8,10000,'jan'),
(9,10000,'magda'),
(10,10000,'krzysztof'),
(11,10000,'marcin'),
(12,10000,'ewa'),
(13,10000,'adam'),
(14,10000,'joanna'),
(15,10000,'michal'),
(16,10000,'ola'),
(17,10000,'lukasz'),
(18,10000,'daria'),
(19,10000,'jakub'),
(20,10000,'pawel');