DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (
    id              SERIAL PRIMARY KEY,
    nombre          VARCHAR(100) NOT NULL,
    precio           NUMERIC(15, 6) NOT NULL

);

INSERT INTO PRODUCTS(nombre , precio) values ('PORTATIL HP PAVILLION', 3000000);
INSERT INTO PRODUCTS(nombre , precio) values ('DESKTOP HP PAVILLION', 2000000);