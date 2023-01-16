--liquibase formatted sql
--changeset FDuda:14

INSERT INTO users(id, username,password,email,is_enable,basket_id,wallet_id,role)
values
(1, 'filip', '$2a$10$gergShdwEZfe31ZbrUdOLOH9x4E3N2lzV/iQPLbyIJIre0Kr.FSXy', 'duda.filip99@gmail.com', true, 1, 1, 'ROLE_ADMIN'),
(2, 'kamil', '$2a$10$6T0JodJcjEMnCfgJPFJwhu6.H81ptV.aarBlNoU6uZnFfoxQF22LC', 'kamil@gmail.com', true, 2, 2, 'ROLE_USER'),
(3, 'ania', '$2a$10$rrJLAdYcufHmbgRhzlGoE.VMXpfNDI49Vz3QKzc89aOyEncchZtlq', 'ania@gmail.com', true, 3, 3, 'ROLE_USER'),
(4, 'tomasz', '$2a$10$cu8/7g729eAXKlPD4Mor4uNcm.MMaxhsCPiS/xIkBwNOMuK4pNOUu', 'tomasz@gmail.com', true, 4, 4, 'ROLE_USER'),
(5, 'agnieszka', '$2a$10$TfT8VGr7tlt44jmpx2G1GOC3FnvdUE.MVc.iOU.Rl2f3.3.V1.n2G', 'agnieszka@gmail.com', true, 5, 5, 'ROLE_USER'),
(6, 'piotr', '$2a$10$Xa2ONLudnmlhee4liEze1e89y3Vo68Uq.jHGCiZfMxsgl0YVc57yq', 'piotr@gmail.com', true, 6, 6, 'ROLE_USER'),
(7, 'jan', '$2a$10$4mg5i19JKmJmI/OJ1u6pFu/mS5ubNsgjGsnf78qd4vuBYHcwU.5Ga', 'jan@gmail.com', true, 7, 7, 'ROLE_USER'),
(8, 'magda', '$2a$10$2ZSh2KDfoJ/Z6naXZvKG0.69x1C9QWy1C84EZLsI9lbrtiPQsGFmi', 'magda@gmail.com', true, 8, 8, 'ROLE_USER'),
(9, 'krzysztof', '$2a$10$zz/qBzPgnH.nF4fMYepW0.jyzqvC2YmUXVQc/AI7fpc5GaosQo.Pa', 'krzysztof@gmail.com', true, 9, 9, 'ROLE_USER'),
(10, 'marcin', '$2a$10$BmwQkhcnqAPmpd3iozLoUe4MXQPStu44/L6hkBfovxOmXeUvkiKki', 'marcin@gmail.com', true, 10, 10, 'ROLE_USER'),
(11, 'ewa', '$2a$10$2ICJzgcF13qHapDlCKln/ue8zDWejCpUudqJrbzXQH/9CC5n1r4XS', 'ewa@gmail.com', true, 11, 11, 'ROLE_USER'),
(12, 'adam', '$2a$10$QgTgAXGd20figeJcDurxjORQfuOJRo/jkefkbmISuJNQ0ZlPwr6bu', 'adam@gmail.com', true, 12, 12, 'ROLE_USER'),
(13, 'pawel', '$2a$10$cG2PsUu/h5GBJdTEhCf3qeEqM24ZMyMdZPgocZbFCFH1M1UJSn.cu', 'pawel@gmail.com', true, 13, 13, 'ROLE_ADMIN');