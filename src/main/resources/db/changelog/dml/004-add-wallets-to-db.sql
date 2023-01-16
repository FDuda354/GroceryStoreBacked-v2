--liquibase formatted sql
--changeset FDuda:12

INSERT INTO wallets(id, balance,owner)
VALUES
(1,1000, 'filip'),
(2,1000,'patryk'),
(3,1000,'kamil'),
(4,1000,'ania'),
(5,1000,'tomasz'),
(6,1000,'agnieszka'),
(7,1000,'piotr'),
(8,1000,'jan'),
(9,1000,'magda'),
(10,1000,'krzysztof'),
(11,1000,'marcin'),
(12,1000,'ewa'),
(13,1000,'pawel');