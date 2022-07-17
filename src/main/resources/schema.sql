DROP TABLE IF EXISTS LINEA_COMPROBANTE;
DROP TABLE IF EXISTS COMPROBANTE;
DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE IF NOT EXISTS CLIENTE
(
    nombre   VARCHAR(50),
    apellido VARCHAR(50),
    dni      INT NOT NULL,
    FECHA_DE_NACIMIENTO  DATE,
    primary key (dni)

);

CREATE TABLE IF NOT EXISTS PRODUCTO
(
    id   INT NOT NULL,
    descripcion VARCHAR(50),
    precio      DECIMAL (20),
    activo BOOLEAN,
    fecha_creacion DATE,
    fecha_actualizacion DATE,
    stock INT,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS COMPROBANTE
(
    id   INT NOT NULL,
    dni_cliente INT,
    fecha_creacion DATE,
    cuit_empresa      VARCHAR(50),
    primary key (id),
    foreign key (dni_cliente) references CLIENTE (dni)
);

CREATE TABLE IF NOT EXISTS LINEA_COMPROBANTE
(
    id   INT NOT NULL,
    id_producto INT,
    id_comprobante INT,
    detalle VARCHAR(50),
    precio      DECIMAL (20),
    cantidad INT,
    primary key (id),
    foreign key (id_producto) references PRODUCTO (id),
    foreign key (id_comprobante) references COMPROBANTE (id)
);