DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE IF NOT EXISTS CLIENTE
(
    nombre   VARCHAR(50),
    apellido VARCHAR(50),
    dni      INT,
    FECHA_DE_NACIMIENTO  DATE,
    primary key (dni)

);