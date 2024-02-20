--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

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

DROP DATABASE IF EXISTS wmb_ii;
--
-- Name: wmb_ii; Type: DATABASE; Schema: -; Owner: rfms
--

CREATE DATABASE wmb_ii WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';


ALTER DATABASE wmb_ii OWNER TO rfms;

\connect wmb_ii

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
-- Name: m_customer_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_customer_seq
    START WITH 9
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_customer_seq OWNER TO rfms;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: m_customer; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_customer (
    id bigint DEFAULT nextval('public.m_customer_seq'::regclass) NOT NULL,
    customer_name character varying(50) NOT NULL,
    mobile_phone_no character varying(20) NOT NULL,
    is_member boolean,
    user_credential_id integer
);


ALTER TABLE public.m_customer OWNER TO rfms;

--
-- Name: m_customer_discount_id_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_customer_discount_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_customer_discount_id_seq OWNER TO rfms;

--
-- Name: m_customer_discount; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_customer_discount (
    id integer DEFAULT nextval('public.m_customer_discount_id_seq'::regclass) NOT NULL,
    disc_id bigint,
    customer_id bigint
);


ALTER TABLE public.m_customer_discount OWNER TO rfms;

--
-- Name: m_discount_id_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_discount_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_discount_id_seq OWNER TO rfms;

--
-- Name: m_discount; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_discount (
    id integer DEFAULT nextval('public.m_discount_id_seq'::regclass) NOT NULL,
    disc_desciption character varying(50),
    pct integer
);


ALTER TABLE public.m_discount OWNER TO rfms;

--
-- Name: m_menu_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_menu_seq
    START WITH 22
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_menu_seq OWNER TO rfms;

--
-- Name: m_menu; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_menu (
    id bigint DEFAULT nextval('public.m_menu_seq'::regclass) NOT NULL,
    menu_name character varying(100) NOT NULL
);


ALTER TABLE public.m_menu OWNER TO rfms;

--
-- Name: m_menu_price_id_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_menu_price_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_menu_price_id_seq OWNER TO rfms;

--
-- Name: m_menu_price; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_menu_price (
    id integer DEFAULT nextval('public.m_menu_price_id_seq'::regclass) NOT NULL,
    menu_id bigint NOT NULL,
    price real NOT NULL
);


ALTER TABLE public.m_menu_price OWNER TO rfms;

--
-- Name: m_table_seq; Type: SEQUENCE; Schema: public; Owner: rfms
--

CREATE SEQUENCE public.m_table_seq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.m_table_seq OWNER TO rfms;

--
-- Name: m_table; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_table (
    id integer DEFAULT nextval('public.m_table_seq'::regclass) NOT NULL,
    table_name character(3) NOT NULL
);


ALTER TABLE public.m_table OWNER TO rfms;

--
-- Name: m_trans_type; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.m_trans_type (
    trans_type_id character varying(3) NOT NULL,
    description character varying(50)
);


ALTER TABLE public.m_trans_type OWNER TO rfms;

--
-- Name: t_bill; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.t_bill (
    id bigint NOT NULL,
    trans_date date NOT NULL,
    customer_id bigint NOT NULL,
    table_id integer,
    trans_type character varying(3) NOT NULL
);


ALTER TABLE public.t_bill OWNER TO rfms;

--
-- Name: t_bill_detail; Type: TABLE; Schema: public; Owner: rfms
--

CREATE TABLE public.t_bill_detail (
    id bigint NOT NULL,
    bill_id bigint NOT NULL,
    menu_price_id integer NOT NULL,
    qty real NOT NULL
);


ALTER TABLE public.t_bill_detail OWNER TO rfms;

--
-- Data for Name: m_customer; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_customer (id, customer_name, mobile_phone_no, is_member, user_credential_id) FROM stdin;
1	Kadir	0877123333	f	\N
2	Basuki	0812399123	f	\N
3	Munaroh	0888901920	t	\N
4	Adinda	0815343411	f	\N
5	Rozak	0857129823	f	\N
6	Devi	0877745983	t	\N
7	Qibil	0821834583	f	\N
8	Nurman	0877567211	f	\N
\.


--
-- Data for Name: m_customer_discount; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_customer_discount (id, disc_id, customer_id) FROM stdin;
1	1	3
2	1	6
\.


--
-- Data for Name: m_discount; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_discount (id, disc_desciption, pct) FROM stdin;
1	Discount 10%	10
\.


--
-- Data for Name: m_menu; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_menu (id, menu_name) FROM stdin;
1	Nasi Putih
2	Sayur Sop
4	Es Teh Tawar
5	Sayur Lodeh
6	Tempe
7	Nasi Goreng
8	Telor Ceplok
9	Nasi Goreng Spesial
10	Sayur Kangkung
11	Telor Dadar
12	Kopi Kapal Api
13	Aneka Gorengan
14	Indomie Goreng Telor
15	Es Ovaltine
16	Telor Balado
17	Sayur Buncis
18	Es Teh Manis
19	Tempe Orek
20	Sayur Tahu
21	Indomie Kari Ayam Telor
3	Tahu
\.


--
-- Data for Name: m_menu_price; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_menu_price (id, menu_id, price) FROM stdin;
1	1	3000
2	2	2000
3	3	2000
4	4	1500
5	5	2500
6	6	2000
7	7	12000
8	8	5000
9	9	25000
10	10	1500
11	11	5000
12	12	4000
13	13	2000
14	14	10000
15	15	6000
16	16	4000
17	17	3000
18	18	1500
19	19	3000
20	20	3000
21	21	10000
22	1	4000
\.


--
-- Data for Name: m_table; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_table (id, table_name) FROM stdin;
1	T01
2	T02
3	T03
4	T04
\.


--
-- Data for Name: m_trans_type; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.m_trans_type (trans_type_id, description) FROM stdin;
EI	Eat In
TA	Take Away
\.


--
-- Data for Name: t_bill; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.t_bill (id, trans_date, customer_id, table_id, trans_type) FROM stdin;
1	2022-06-01	1	1	EI
2	2022-06-01	2	2	EI
3	2022-06-01	3	1	EI
4	2022-06-02	4	\N	TA
5	2022-06-03	2	1	EI
6	2022-06-03	5	2	EI
7	2022-06-03	6	3	EI
8	2022-06-03	7	2	EI
9	2022-06-03	8	4	EI
10	2022-06-04	2	1	EI
11	2022-06-04	5	4	EI
12	2022-06-05	5	\N	TA
\.


--
-- Data for Name: t_bill_detail; Type: TABLE DATA; Schema: public; Owner: rfms
--

COPY public.t_bill_detail (id, bill_id, menu_price_id, qty) FROM stdin;
1	1	1	1
2	1	2	1
3	1	3	2
4	1	4	1
5	2	1	1
6	2	5	1
7	2	6	2
8	2	4	1
9	3	7	1
10	3	8	1
11	4	9	1
12	5	1	1
13	5	10	1
14	5	11	1
15	5	4	1
16	6	12	1
17	6	13	5
18	7	14	1
19	7	15	1
20	8	1	0.5
21	8	16	1
22	8	17	1
23	8	13	2
24	8	18	1
25	9	1	1
26	9	19	1
27	9	20	1
28	9	4	1
29	10	22	1
30	10	5	1
31	10	6	1
32	10	18	1
33	11	21	1
34	11	18	1
35	12	13	15
\.


--
-- Name: m_customer_discount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_customer_discount_id_seq', 1, false);


--
-- Name: m_customer_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_customer_seq', 206, true);


--
-- Name: m_discount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_discount_id_seq', 1, false);


--
-- Name: m_menu_price_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_menu_price_id_seq', 25, true);


--
-- Name: m_menu_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_menu_seq', 34, true);


--
-- Name: m_table_seq; Type: SEQUENCE SET; Schema: public; Owner: rfms
--

SELECT pg_catalog.setval('public.m_table_seq', 5, false);


--
-- Name: m_customer_discount m_customer_discount_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_customer_discount
    ADD CONSTRAINT m_customer_discount_pkey PRIMARY KEY (id);


--
-- Name: m_customer m_customer_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_customer
    ADD CONSTRAINT m_customer_pkey PRIMARY KEY (id);


--
-- Name: m_discount m_discount_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_discount
    ADD CONSTRAINT m_discount_pkey PRIMARY KEY (id);


--
-- Name: m_menu m_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_menu
    ADD CONSTRAINT m_menu_pkey PRIMARY KEY (id);


--
-- Name: m_menu_price m_menu_price_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_menu_price
    ADD CONSTRAINT m_menu_price_pkey PRIMARY KEY (id);


--
-- Name: m_table m_table_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_table
    ADD CONSTRAINT m_table_pkey PRIMARY KEY (id);


--
-- Name: m_trans_type m_trans_type_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_trans_type
    ADD CONSTRAINT m_trans_type_pkey PRIMARY KEY (trans_type_id);


--
-- Name: t_bill_detail t_bill_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill_detail
    ADD CONSTRAINT t_bill_detail_pkey PRIMARY KEY (id);


--
-- Name: t_bill t_bill_pkey; Type: CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill
    ADD CONSTRAINT t_bill_pkey PRIMARY KEY (id);


--
-- Name: m_customer_discount m_customer_discount_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_customer_discount
    ADD CONSTRAINT m_customer_discount_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.m_customer(id);


--
-- Name: m_customer_discount m_customer_discount_disc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_customer_discount
    ADD CONSTRAINT m_customer_discount_disc_id_fkey FOREIGN KEY (disc_id) REFERENCES public.m_discount(id);


--
-- Name: m_menu_price m_menu_price_menu_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.m_menu_price
    ADD CONSTRAINT m_menu_price_menu_id_fkey FOREIGN KEY (menu_id) REFERENCES public.m_menu(id);


--
-- Name: t_bill t_bill_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill
    ADD CONSTRAINT t_bill_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.m_customer(id);


--
-- Name: t_bill_detail t_bill_detail_bill_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill_detail
    ADD CONSTRAINT t_bill_detail_bill_id_fkey FOREIGN KEY (bill_id) REFERENCES public.t_bill(id);


--
-- Name: t_bill_detail t_bill_detail_menu_price_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill_detail
    ADD CONSTRAINT t_bill_detail_menu_price_id_fkey FOREIGN KEY (menu_price_id) REFERENCES public.m_menu_price(id);


--
-- Name: t_bill t_bill_table_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill
    ADD CONSTRAINT t_bill_table_id_fkey FOREIGN KEY (table_id) REFERENCES public.m_table(id);


--
-- Name: t_bill t_bill_trans_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: rfms
--

ALTER TABLE ONLY public.t_bill
    ADD CONSTRAINT t_bill_trans_type_fkey FOREIGN KEY (trans_type) REFERENCES public.m_trans_type(trans_type_id);


--
-- PostgreSQL database dump complete
--

