-- Database: Java API

DROP TABLE IF EXISTS BORDILLO;
DROP TABLE IF EXISTS CALZADA;
DROP TABLE IF EXISTS SEGMENTO;

DROP TABLE IF EXISTS BORDILLO;
DROP TABLE IF EXISTS CALZADA;
DROP TABLE IF EXISTS SEGMENTO;

CREATE TABLE SEGMENTO(
	id_segmento integer PRIMARY KEY,
	longitud integer CHECK (longitud>0),
	direccion varchar (255) NOT NULL
);
 
CREATE TABLE BORDILLO(
	id_bordillo integer PRIMARY KEY,
	longitud integer CHECK (longitud>0),
	segmento integer REFERENCES SEGMENTO(id_segmento) ON DELETE CASCADE

);

CREATE TABLE CALZADA(
	id_calzada integer PRIMARY KEY,
	longitud integer CHECK (longitud>0),
	segmento integer REFERENCES SEGMENTO(id_segmento) ON DELETE CASCADE

);


INSERT INTO SEGMENTO (id_segmento, longitud, direccion) VALUES 
(1, 500, 'Calle 1, Avenida Principal'),
(2, 1000, 'Calle 2, Carrera 10'),
(3, 750, 'Calle 3, Av. Secundaria'),
(4, 1200, 'Calle 4, Bulevar Norte'),
(5, 900, 'Calle 5, Centro Histórico');

INSERT INTO SEGMENTO (id_segmento, longitud, direccion) VALUES 
(1, 150, 'Avenida Principal'),
(2, 250, 'Calle Secundaria'),
(3, 180, 'Bulevar Central'),
(4, 300, 'Avenida Norte'),
(5, 220, 'Calle Oeste');

-- Inserción en la tabla BORDILLO
INSERT INTO BORDILLO (id_bordillo, longitud, segmento) VALUES
(1, 50, 1),
(2, 45, 1),  -- Bordillo del mismo segmento
(3, 60, 2),
(4, 55, 2),  -- Bordillo del mismo segmento
(5, 40, 3),
(6, 50, 4),
(7, 30, 5),
(8, 35, 5);  -- Bordillo del mismo segmento

-- Inserción en la tabla CALZADA
INSERT INTO CALZADA (id_calzada, longitud, segmento) VALUES
(1, 120, 1),
(2, 130, 1),  -- Calzada del mismo segmento
(3, 150, 2),
(4, 140, 2),  -- Calzada del mismo segmento
(5, 160, 3),
(6, 170, 4),
(7, 180, 5),
(8, 175, 5);  -- Calzada del mismo segmento