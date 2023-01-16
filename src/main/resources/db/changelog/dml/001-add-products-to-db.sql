--liquibase formatted sql
--changeset FDuda:9

INSERT INTO products_db(id, name, type, price)
VALUES (1, 'Apple', 'FRUITS', 2),
       (2, 'Orange', 'FRUITS', 5),
       (3, 'Banana', 'FRUITS', 4.4),
       (4, 'Potato', 'VEGETABLES', 1.2),
       (5, 'Tomato', 'VEGETABLES', 7),
       (6, 'Onion', 'VEGETABLES', 1.7),
       (7, 'Milk', 'DAIRY', 2.7),
       (8, 'Cheese', 'DAIRY', 20.5),
       (9, 'Butter', 'DAIRY', 7),
       (10, 'Pork', 'MEAT', 16),
       (11, 'Steak', 'MEAT', 50),
       (12, 'Bread', 'GRAINS', 5),
       (13, 'Cereals', 'GRAINS', 8);
