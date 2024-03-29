---------tabla alquiler vehiculos

CREATE TABLE public.alquiler_vehiculos
(
    placa_vehiculo integer NOT NULL,
    id_usuario integer NOT NULL,
    nombre_usuario character varying(20) COLLATE pg_catalog."default" NOT NULL,
    oficina_retiro integer NOT NULL,
    oficina_devolucion integer NOT NULL,
    fecha_retiro date NOT NULL,
    hora_retiro integer NOT NULL,
    fecha_devolucion date NOT NULL,
    hora_devolucion integer NOT NULL,
    precio_alquiler double precision NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.alquiler_vehiculos
    OWNER to postgres;

-------------------tabla estilo


CREATE TABLE public.estilo
(
    id_estilo integer NOT NULL,
    nombre_estilo character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT estilo_pkey PRIMARY KEY (id_estilo)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.estilo
    OWNER to postgres;

-------------------tabla marca


CREATE TABLE public.marca
(
    id_marca integer NOT NULL,
    nombre_marca character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT marca_pkey PRIMARY KEY (id_marca)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.marca
    OWNER to postgres;

-------------------tabla modelo
CREATE TABLE public.modelo
(
    id_modelo integer NOT NULL,
    nombre_modelo character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT modelo_pkey PRIMARY KEY (id_modelo)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.modelo
    OWNER to postgres;

-------------------tabla oficinas

CREATE TABLE public.oficinas
(
    id_oficina integer NOT NULL,
    nombre_oficina character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT oficina_pkey PRIMARY KEY (id_oficina)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.oficinas
    OWNER to postgres;
-------------------tabla usuarios

CREATE TABLE public.usuarios
(
    id_usuario integer NOT NULL,
    nombre character varying(20) COLLATE pg_catalog."default" NOT NULL,
    telefono integer NOT NULL,
    direccion character varying(20) COLLATE pg_catalog."default" NOT NULL,
    foto bytea NOT NULL,
    "contraseña" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    tipo_usuario character varying(20) COLLATE  pg_catalog."default" NOT NULL,
    CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuarios
    OWNER to postgres;

-------------------tabla vehiculo


CREATE TABLE public.vehiculo
(
    placa integer NOT NULL,
    marca integer NOT NULL,
    modelo integer NOT NULL,
    estilo integer NOT NULL,
    transmision character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "año" integer NOT NULL,
    precio double precision NOT NULL,
    estado boolean NOT NULL,
    foto bytea NOT NULL,
    CONSTRAINT vehiculo_pkey PRIMARY KEY (placa),
    CONSTRAINT fk_vehiculo_estilo FOREIGN KEY (estilo)
        REFERENCES public.estilo (id_estilo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_vehiculo_marca FOREIGN KEY (marca)
        REFERENCES public.marca (id_marca) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_vehiculo_modelo FOREIGN KEY (modelo)
        REFERENCES public.modelo (id_modelo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.vehiculo
    OWNER to postgres;