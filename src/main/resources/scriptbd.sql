--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2025-11-24 13:28:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 41658)
-- Name: aquarium; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA aquarium;


ALTER SCHEMA aquarium OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 324 (class 1259 OID 41679)
-- Name: acuario; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.acuario (
                                  id integer NOT NULL,
                                  capacidad double precision,
                                  medidas character varying(100),
                                  id_usuario integer
);


ALTER TABLE aquarium.acuario OWNER TO postgres;

--
-- TOC entry 323 (class 1259 OID 41678)
-- Name: acuario_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.acuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.acuario_id_seq OWNER TO postgres;

--
-- TOC entry 3681 (class 0 OID 0)
-- Dependencies: 323
-- Name: acuario_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.acuario_id_seq OWNED BY aquarium.acuario.id;


--
-- TOC entry 326 (class 1259 OID 41691)
-- Name: acuario_pez; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.acuario_pez (
                                      id integer NOT NULL,
                                      id_pez integer,
                                      id_acuario integer,
                                      cantidad integer DEFAULT 0,
                                      cantidad_macho integer DEFAULT 0,
                                      cantidad__hembra integer DEFAULT 0
);


ALTER TABLE aquarium.acuario_pez OWNER TO postgres;

--
-- TOC entry 325 (class 1259 OID 41690)
-- Name: acuario_pez_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.acuario_pez_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.acuario_pez_id_seq OWNER TO postgres;

--
-- TOC entry 3682 (class 0 OID 0)
-- Dependencies: 325
-- Name: acuario_pez_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.acuario_pez_id_seq OWNED BY aquarium.acuario_pez.id;


--
-- TOC entry 345 (class 1259 OID 41846)
-- Name: linea_pedido; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.linea_pedido (
                                       id integer NOT NULL,
                                       id_pedido integer NOT NULL,
                                       id_producto integer NOT NULL,
                                       cantidad integer
);


ALTER TABLE aquarium.linea_pedido OWNER TO postgres;

--
-- TOC entry 344 (class 1259 OID 41845)
-- Name: linea_pedido_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.linea_pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.linea_pedido_id_seq OWNER TO postgres;

--
-- TOC entry 3683 (class 0 OID 0)
-- Dependencies: 344
-- Name: linea_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.linea_pedido_id_seq OWNED BY aquarium.linea_pedido.id;


--
-- TOC entry 330 (class 1259 OID 41720)
-- Name: marca; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.marca (
                                id integer NOT NULL,
                                nombre character varying(100)
);


ALTER TABLE aquarium.marca OWNER TO postgres;

--
-- TOC entry 329 (class 1259 OID 41719)
-- Name: marca_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.marca_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.marca_id_seq OWNER TO postgres;

--
-- TOC entry 3684 (class 0 OID 0)
-- Dependencies: 329
-- Name: marca_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.marca_id_seq OWNED BY aquarium.marca.id;


--
-- TOC entry 343 (class 1259 OID 41820)
-- Name: pedido; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.pedido (
                                 id integer NOT NULL,
                                 fecha timestamp without time zone,
                                 codigo character varying,
                                 id_usuario integer NOT NULL
);


ALTER TABLE aquarium.pedido OWNER TO postgres;

--
-- TOC entry 342 (class 1259 OID 41819)
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.pedido_id_seq OWNER TO postgres;

--
-- TOC entry 3685 (class 0 OID 0)
-- Dependencies: 342
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.pedido_id_seq OWNED BY aquarium.pedido.id;


--
-- TOC entry 320 (class 1259 OID 41660)
-- Name: pez; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.pez (
                              id integer NOT NULL,
                              nombre_comun character varying(50),
                              descripcion character varying(100),
                              especie integer DEFAULT 0,
                              ficha text,
                              foto_url character varying(800)
);


ALTER TABLE aquarium.pez OWNER TO postgres;

--
-- TOC entry 319 (class 1259 OID 41659)
-- Name: pez_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.pez_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.pez_id_seq OWNER TO postgres;

--
-- TOC entry 3686 (class 0 OID 0)
-- Dependencies: 319
-- Name: pez_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.pez_id_seq OWNED BY aquarium.pez.id;


--
-- TOC entry 336 (class 1259 OID 41758)
-- Name: planta; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.planta (
                                 id integer NOT NULL,
                                 nombre character varying(150),
                                 tipo integer DEFAULT 0,
                                 ficha text
);


ALTER TABLE aquarium.planta OWNER TO postgres;

--
-- TOC entry 337 (class 1259 OID 41767)
-- Name: planta_acuario; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.planta_acuario (
                                         id_planta integer NOT NULL,
                                         id_acuario integer NOT NULL
);


ALTER TABLE aquarium.planta_acuario OWNER TO postgres;

--
-- TOC entry 335 (class 1259 OID 41757)
-- Name: planta_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.planta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.planta_id_seq OWNER TO postgres;

--
-- TOC entry 3687 (class 0 OID 0)
-- Dependencies: 335
-- Name: planta_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.planta_id_seq OWNED BY aquarium.planta.id;


--
-- TOC entry 332 (class 1259 OID 41727)
-- Name: producto; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.producto (
                                   id integer NOT NULL,
                                   nombre character varying(100),
                                   descripcion character varying(500),
                                   url_imagen character varying(500),
                                   id_marca integer NOT NULL
);


ALTER TABLE aquarium.producto OWNER TO postgres;

--
-- TOC entry 331 (class 1259 OID 41726)
-- Name: producto_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.producto_id_seq OWNER TO postgres;

--
-- TOC entry 3688 (class 0 OID 0)
-- Dependencies: 331
-- Name: producto_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.producto_id_seq OWNED BY aquarium.producto.id;


--
-- TOC entry 334 (class 1259 OID 41741)
-- Name: producto_tienda; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.producto_tienda (
                                          id integer NOT NULL,
                                          id_producto integer NOT NULL,
                                          id_tienda integer NOT NULL,
                                          precio double precision
);


ALTER TABLE aquarium.producto_tienda OWNER TO postgres;

--
-- TOC entry 333 (class 1259 OID 41740)
-- Name: producto_tienda_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.producto_tienda_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.producto_tienda_id_seq OWNER TO postgres;

--
-- TOC entry 3689 (class 0 OID 0)
-- Dependencies: 333
-- Name: producto_tienda_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.producto_tienda_id_seq OWNED BY aquarium.producto_tienda.id;


--
-- TOC entry 339 (class 1259 OID 41781)
-- Name: requisito; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.requisito (
                                    id integer NOT NULL,
                                    tipo_requisito integer NOT NULL,
                                    descripcion text
);


ALTER TABLE aquarium.requisito OWNER TO postgres;

--
-- TOC entry 338 (class 1259 OID 41780)
-- Name: requisito_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.requisito_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.requisito_id_seq OWNER TO postgres;

--
-- TOC entry 3690 (class 0 OID 0)
-- Dependencies: 338
-- Name: requisito_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.requisito_id_seq OWNED BY aquarium.requisito.id;


--
-- TOC entry 341 (class 1259 OID 41790)
-- Name: requisito_pez; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.requisito_pez (
                                        id integer NOT NULL,
                                        id_requisito integer NOT NULL,
                                        id_pez integer NOT NULL,
                                        importantia integer DEFAULT 0
);


ALTER TABLE aquarium.requisito_pez OWNER TO postgres;

--
-- TOC entry 340 (class 1259 OID 41789)
-- Name: requisito_pez_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.requisito_pez_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.requisito_pez_id_seq OWNER TO postgres;

--
-- TOC entry 3691 (class 0 OID 0)
-- Dependencies: 340
-- Name: requisito_pez_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.requisito_pez_id_seq OWNED BY aquarium.requisito_pez.id;


--
-- TOC entry 328 (class 1259 OID 41711)
-- Name: tienda; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.tienda (
                                 id integer NOT NULL,
                                 nombre character varying(100),
                                 url_logo character varying(500),
                                 direccion character varying(500),
                                 ciudad character varying(50),
                                 codigo_postal integer
);


ALTER TABLE aquarium.tienda OWNER TO postgres;

--
-- TOC entry 327 (class 1259 OID 41710)
-- Name: tienda_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.tienda_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.tienda_id_seq OWNER TO postgres;

--
-- TOC entry 3692 (class 0 OID 0)
-- Dependencies: 327
-- Name: tienda_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.tienda_id_seq OWNED BY aquarium.tienda.id;


--
-- TOC entry 322 (class 1259 OID 41670)
-- Name: usuario; Type: TABLE; Schema: aquarium; Owner: postgres
--

CREATE TABLE aquarium.usuario (
                                  id integer NOT NULL,
                                  mail character varying(200),
                                  password character varying(600)
);


ALTER TABLE aquarium.usuario OWNER TO postgres;

--
-- TOC entry 321 (class 1259 OID 41669)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: aquarium; Owner: postgres
--

CREATE SEQUENCE aquarium.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aquarium.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 3693 (class 0 OID 0)
-- Dependencies: 321
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: aquarium; Owner: postgres
--

ALTER SEQUENCE aquarium.usuario_id_seq OWNED BY aquarium.usuario.id;


--
-- TOC entry 3455 (class 2604 OID 41682)
-- Name: acuario id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario ALTER COLUMN id SET DEFAULT nextval('aquarium.acuario_id_seq'::regclass);


--
-- TOC entry 3456 (class 2604 OID 41694)
-- Name: acuario_pez id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario_pez ALTER COLUMN id SET DEFAULT nextval('aquarium.acuario_pez_id_seq'::regclass);


--
-- TOC entry 3470 (class 2604 OID 41849)
-- Name: linea_pedido id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.linea_pedido ALTER COLUMN id SET DEFAULT nextval('aquarium.linea_pedido_id_seq'::regclass);


--
-- TOC entry 3461 (class 2604 OID 41723)
-- Name: marca id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.marca ALTER COLUMN id SET DEFAULT nextval('aquarium.marca_id_seq'::regclass);


--
-- TOC entry 3469 (class 2604 OID 41823)
-- Name: pedido id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.pedido ALTER COLUMN id SET DEFAULT nextval('aquarium.pedido_id_seq'::regclass);


--
-- TOC entry 3453 (class 2604 OID 41663)
-- Name: pez id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.pez ALTER COLUMN id SET DEFAULT nextval('aquarium.pez_id_seq'::regclass);


--
-- TOC entry 3464 (class 2604 OID 41761)
-- Name: planta id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.planta ALTER COLUMN id SET DEFAULT nextval('aquarium.planta_id_seq'::regclass);


--
-- TOC entry 3462 (class 2604 OID 41730)
-- Name: producto id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto ALTER COLUMN id SET DEFAULT nextval('aquarium.producto_id_seq'::regclass);


--
-- TOC entry 3463 (class 2604 OID 41744)
-- Name: producto_tienda id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto_tienda ALTER COLUMN id SET DEFAULT nextval('aquarium.producto_tienda_id_seq'::regclass);


--
-- TOC entry 3466 (class 2604 OID 41784)
-- Name: requisito id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito ALTER COLUMN id SET DEFAULT nextval('aquarium.requisito_id_seq'::regclass);


--
-- TOC entry 3467 (class 2604 OID 41793)
-- Name: requisito_pez id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito_pez ALTER COLUMN id SET DEFAULT nextval('aquarium.requisito_pez_id_seq'::regclass);


--
-- TOC entry 3460 (class 2604 OID 41714)
-- Name: tienda id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.tienda ALTER COLUMN id SET DEFAULT nextval('aquarium.tienda_id_seq'::regclass);


--
-- TOC entry 3454 (class 2604 OID 41673)
-- Name: usuario id; Type: DEFAULT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.usuario ALTER COLUMN id SET DEFAULT nextval('aquarium.usuario_id_seq'::regclass);


--
-- TOC entry 3654 (class 0 OID 41679)
-- Dependencies: 324
-- Data for Name: acuario; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3656 (class 0 OID 41691)
-- Dependencies: 326
-- Data for Name: acuario_pez; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3675 (class 0 OID 41846)
-- Dependencies: 345
-- Data for Name: linea_pedido; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.linea_pedido VALUES (1, 1, 1, 5);
INSERT INTO aquarium.linea_pedido VALUES (2, 1, 2, 10);


--
-- TOC entry 3660 (class 0 OID 41720)
-- Dependencies: 330
-- Data for Name: marca; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.marca VALUES (1, 'SERA');


--
-- TOC entry 3673 (class 0 OID 41820)
-- Dependencies: 343
-- Data for Name: pedido; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.pedido VALUES (1, '2025-11-20 12:40:37.759577', 'P01', 1);
INSERT INTO aquarium.pedido VALUES (2, '2025-11-20 12:40:37.774224', 'P02', 1);


--
-- TOC entry 3650 (class 0 OID 41660)
-- Dependencies: 320
-- Data for Name: pez; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.pez VALUES (1, 'Colisa', 'Anabántido común', 0, 'Sin ficha', 'https://lh4.googleusercontent.com/proxy/wrcexgLqn36gnJG37AvGdDhB_AlgeN4Ard0LR5H42JvwBwC1tyabZlRAuIyW-n2CcF0atPG3B7m5_WlPv4xBxGHVxRZRrpU36M7evb0KyUOu8h86sR-HNLEWww');
INSERT INTO aquarium.pez VALUES (3, 'Pez Payaso', 'Pez de agua salada', 1, 'Sin ficha', 'https://cdn0.bioenciclopedia.com/es/posts/1/7/1/pez_payaso_171_600.jpg');
INSERT INTO aquarium.pez VALUES (2, 'Guppy', 'Vivíparo', 0, 'Sin ficha', 'https://cdn.britannica.com/02/117202-050-62267C8B/Guppy.jpg');


--
-- TOC entry 3666 (class 0 OID 41758)
-- Dependencies: 336
-- Data for Name: planta; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3667 (class 0 OID 41767)
-- Dependencies: 337
-- Data for Name: planta_acuario; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3662 (class 0 OID 41727)
-- Dependencies: 332
-- Data for Name: producto; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.producto VALUES (1, 'Comida Disco', 'Nutricional y saludable', '-', 1);
INSERT INTO aquarium.producto VALUES (2, 'Comida Cíclidos', 'Muy rica', '-', 1);


--
-- TOC entry 3664 (class 0 OID 41741)
-- Dependencies: 334
-- Data for Name: producto_tienda; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3669 (class 0 OID 41781)
-- Dependencies: 339
-- Data for Name: requisito; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3671 (class 0 OID 41790)
-- Dependencies: 341
-- Data for Name: requisito_pez; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3658 (class 0 OID 41711)
-- Dependencies: 328
-- Data for Name: tienda; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--



--
-- TOC entry 3652 (class 0 OID 41670)
-- Dependencies: 322
-- Data for Name: usuario; Type: TABLE DATA; Schema: aquarium; Owner: postgres
--

INSERT INTO aquarium.usuario VALUES (1, 'ljlopez@fundacionsafa.es', '1234');


--
-- TOC entry 3694 (class 0 OID 0)
-- Dependencies: 323
-- Name: acuario_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.acuario_id_seq', 1, false);


--
-- TOC entry 3695 (class 0 OID 0)
-- Dependencies: 325
-- Name: acuario_pez_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.acuario_pez_id_seq', 1, false);


--
-- TOC entry 3696 (class 0 OID 0)
-- Dependencies: 344
-- Name: linea_pedido_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.linea_pedido_id_seq', 2, true);


--
-- TOC entry 3697 (class 0 OID 0)
-- Dependencies: 329
-- Name: marca_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.marca_id_seq', 1, false);


--
-- TOC entry 3698 (class 0 OID 0)
-- Dependencies: 342
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.pedido_id_seq', 2, true);


--
-- TOC entry 3699 (class 0 OID 0)
-- Dependencies: 319
-- Name: pez_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.pez_id_seq', 3, true);


--
-- TOC entry 3700 (class 0 OID 0)
-- Dependencies: 335
-- Name: planta_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.planta_id_seq', 1, false);


--
-- TOC entry 3701 (class 0 OID 0)
-- Dependencies: 331
-- Name: producto_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.producto_id_seq', 2, true);


--
-- TOC entry 3702 (class 0 OID 0)
-- Dependencies: 333
-- Name: producto_tienda_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.producto_tienda_id_seq', 1, false);


--
-- TOC entry 3703 (class 0 OID 0)
-- Dependencies: 338
-- Name: requisito_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.requisito_id_seq', 1, false);


--
-- TOC entry 3704 (class 0 OID 0)
-- Dependencies: 340
-- Name: requisito_pez_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.requisito_pez_id_seq', 1, false);


--
-- TOC entry 3705 (class 0 OID 0)
-- Dependencies: 327
-- Name: tienda_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.tienda_id_seq', 1, false);


--
-- TOC entry 3706 (class 0 OID 0)
-- Dependencies: 321
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: aquarium; Owner: postgres
--

SELECT pg_catalog.setval('aquarium.usuario_id_seq', 1, false);


--
-- TOC entry 3478 (class 2606 OID 41699)
-- Name: acuario_pez acuario_pez_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario_pez
    ADD CONSTRAINT acuario_pez_pkey PRIMARY KEY (id);


--
-- TOC entry 3476 (class 2606 OID 41684)
-- Name: acuario acuario_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario
    ADD CONSTRAINT acuario_pkey PRIMARY KEY (id);


--
-- TOC entry 3496 (class 2606 OID 41851)
-- Name: linea_pedido linea_pedido_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.linea_pedido
    ADD CONSTRAINT linea_pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 3482 (class 2606 OID 41725)
-- Name: marca marca_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (id);


--
-- TOC entry 3494 (class 2606 OID 41827)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 3472 (class 2606 OID 41668)
-- Name: pez pez_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.pez
    ADD CONSTRAINT pez_pkey PRIMARY KEY (id);


--
-- TOC entry 3488 (class 2606 OID 41766)
-- Name: planta planta_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.planta
    ADD CONSTRAINT planta_pkey PRIMARY KEY (id);


--
-- TOC entry 3484 (class 2606 OID 41734)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);


--
-- TOC entry 3486 (class 2606 OID 41746)
-- Name: producto_tienda producto_tienda_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto_tienda
    ADD CONSTRAINT producto_tienda_pkey PRIMARY KEY (id);


--
-- TOC entry 3492 (class 2606 OID 41796)
-- Name: requisito_pez requisito_pez_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito_pez
    ADD CONSTRAINT requisito_pez_pkey PRIMARY KEY (id);


--
-- TOC entry 3490 (class 2606 OID 41788)
-- Name: requisito requisito_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito
    ADD CONSTRAINT requisito_pkey PRIMARY KEY (id);


--
-- TOC entry 3480 (class 2606 OID 41718)
-- Name: tienda tienda_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.tienda
    ADD CONSTRAINT tienda_pkey PRIMARY KEY (id);


--
-- TOC entry 3474 (class 2606 OID 41677)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 3498 (class 2606 OID 41705)
-- Name: acuario_pez fk_acuario_pez_acuario; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario_pez
    ADD CONSTRAINT fk_acuario_pez_acuario FOREIGN KEY (id_acuario) REFERENCES aquarium.acuario(id);


--
-- TOC entry 3499 (class 2606 OID 41700)
-- Name: acuario_pez fk_acuario_pez_pez; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario_pez
    ADD CONSTRAINT fk_acuario_pez_pez FOREIGN KEY (id_pez) REFERENCES aquarium.pez(id);


--
-- TOC entry 3497 (class 2606 OID 41685)
-- Name: acuario fk_acuario_usuario; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.acuario
    ADD CONSTRAINT fk_acuario_usuario FOREIGN KEY (id_usuario) REFERENCES aquarium.usuario(id);


--
-- TOC entry 3508 (class 2606 OID 41852)
-- Name: linea_pedido fk_linea_pedido; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.linea_pedido
    ADD CONSTRAINT fk_linea_pedido FOREIGN KEY (id_pedido) REFERENCES aquarium.pedido(id);


--
-- TOC entry 3509 (class 2606 OID 41857)
-- Name: linea_pedido fk_linea_producto; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.linea_pedido
    ADD CONSTRAINT fk_linea_producto FOREIGN KEY (id_producto) REFERENCES aquarium.producto(id);


--
-- TOC entry 3507 (class 2606 OID 41828)
-- Name: pedido fk_pedido_usuario; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.pedido
    ADD CONSTRAINT fk_pedido_usuario FOREIGN KEY (id_usuario) REFERENCES aquarium.usuario(id);


--
-- TOC entry 3503 (class 2606 OID 41775)
-- Name: planta_acuario fk_planta_acuario_acuario; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.planta_acuario
    ADD CONSTRAINT fk_planta_acuario_acuario FOREIGN KEY (id_acuario) REFERENCES aquarium.acuario(id);


--
-- TOC entry 3504 (class 2606 OID 41770)
-- Name: planta_acuario fk_planta_acuario_planta; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.planta_acuario
    ADD CONSTRAINT fk_planta_acuario_planta FOREIGN KEY (id_planta) REFERENCES aquarium.planta(id);


--
-- TOC entry 3500 (class 2606 OID 41735)
-- Name: producto fk_producto_marca; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto
    ADD CONSTRAINT fk_producto_marca FOREIGN KEY (id_marca) REFERENCES aquarium.marca(id);


--
-- TOC entry 3501 (class 2606 OID 41752)
-- Name: producto_tienda fk_producto_tienda_producto; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto_tienda
    ADD CONSTRAINT fk_producto_tienda_producto FOREIGN KEY (id_producto) REFERENCES aquarium.producto(id);


--
-- TOC entry 3502 (class 2606 OID 41747)
-- Name: producto_tienda fk_producto_tienda_tienda; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.producto_tienda
    ADD CONSTRAINT fk_producto_tienda_tienda FOREIGN KEY (id_tienda) REFERENCES aquarium.tienda(id);


--
-- TOC entry 3505 (class 2606 OID 41802)
-- Name: requisito_pez fk_requisito_pez_pez; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito_pez
    ADD CONSTRAINT fk_requisito_pez_pez FOREIGN KEY (id_pez) REFERENCES aquarium.pez(id);


--
-- TOC entry 3506 (class 2606 OID 41797)
-- Name: requisito_pez fk_requisito_pez_requisito; Type: FK CONSTRAINT; Schema: aquarium; Owner: postgres
--

ALTER TABLE ONLY aquarium.requisito_pez
    ADD CONSTRAINT fk_requisito_pez_requisito FOREIGN KEY (id_requisito) REFERENCES aquarium.requisito(id);


-- Completed on 2025-11-24 13:28:53

--
-- PostgreSQL database dump complete
--

