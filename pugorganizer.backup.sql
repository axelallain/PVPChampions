--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-27 07:04:31 CEST

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
-- TOC entry 3296 (class 1262 OID 16386)
-- Name: pugorganizer; Type: DATABASE; Schema: -; Owner: axelallain
--

CREATE DATABASE pugorganizer WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';


ALTER DATABASE pugorganizer OWNER TO axelallain;

\connect pugorganizer

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 19222)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id bigint NOT NULL,
    date_parution timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    message character varying(255) NOT NULL,
    event_id bigint,
    utilisateur_id bigint
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 19228)
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
    id bigint NOT NULL,
    date_parution timestamp without time zone NOT NULL,
    description character varying(255),
    nom character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    serveur_id bigint,
    utilisateur_id bigint
);


ALTER TABLE public.event OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 19236)
-- Name: event_utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_utilisateur (
    event_id bigint NOT NULL,
    utilisateur_id bigint NOT NULL
);


ALTER TABLE public.event_utilisateur OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 19220)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 19239)
-- Name: serveur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.serveur (
    id bigint NOT NULL,
    nom character varying(255) NOT NULL
);


ALTER TABLE public.serveur OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 19244)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id bigint NOT NULL,
    description character varying(255),
    email character varying(255) NOT NULL,
    image character varying(255),
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    serveur_id bigint
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 3286 (class 0 OID 19222)
-- Dependencies: 201
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, date_parution, message, event_id, utilisateur_id) FROM stdin;
\.


--
-- TOC entry 3287 (class 0 OID 19228)
-- Dependencies: 202
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event (id, date_parution, description, nom, type, serveur_id, utilisateur_id) FROM stdin;
3	2021-05-07 02:20:00		Molten Core	donjon	1	1
\.


--
-- TOC entry 3288 (class 0 OID 19236)
-- Dependencies: 203
-- Data for Name: event_utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event_utilisateur (event_id, utilisateur_id) FROM stdin;
3	1
3	2
\.


--
-- TOC entry 3289 (class 0 OID 19239)
-- Dependencies: 204
-- Data for Name: serveur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.serveur (id, nom) FROM stdin;
1	Sulfuron
\.


--
-- TOC entry 3290 (class 0 OID 19244)
-- Dependencies: 205
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, description, email, image, password, username, serveur_id) FROM stdin;
1		axel.allain.a@gmail.com	\N	$2a$10$ryBwK/hyhbRoFRpuzuSmm.ihtAqMEEI2uSLVcNbq/ywWsSEHLa482	axelallain	1
2		user2@gmail.com	\N	$2a$10$H2C4hdMxctuau/0kC5KlB.6eN8vIBkXT7KVcyBZ3m.yR7xEXeDz0C	user2	1
\.


--
-- TOC entry 3297 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- TOC entry 3135 (class 2606 OID 19227)
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- TOC entry 3137 (class 2606 OID 19235)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- TOC entry 3139 (class 2606 OID 19243)
-- Name: serveur serveur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.serveur
    ADD CONSTRAINT serveur_pkey PRIMARY KEY (id);


--
-- TOC entry 3141 (class 2606 OID 19253)
-- Name: serveur uk_cawdqqe02ju5ajuc3c51ivqes; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.serveur
    ADD CONSTRAINT uk_cawdqqe02ju5ajuc3c51ivqes UNIQUE (nom);


--
-- TOC entry 3143 (class 2606 OID 19257)
-- Name: utilisateur uk_kq7nt5wyq9v9lpcpgxag2f24a; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT uk_kq7nt5wyq9v9lpcpgxag2f24a UNIQUE (username);


--
-- TOC entry 3145 (class 2606 OID 19255)
-- Name: utilisateur uk_rma38wvnqfaf66vvmi57c71lo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT uk_rma38wvnqfaf66vvmi57c71lo UNIQUE (email);


--
-- TOC entry 3147 (class 2606 OID 19251)
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id);


--
-- TOC entry 3148 (class 2606 OID 19258)
-- Name: commentaire fk5tnltpqv3berx50au7tjift39; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fk5tnltpqv3berx50au7tjift39 FOREIGN KEY (event_id) REFERENCES public.event(id);


--
-- TOC entry 3151 (class 2606 OID 19273)
-- Name: event fk6t28b1gy5ehfu0v06krc82281; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT fk6t28b1gy5ehfu0v06krc82281 FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3153 (class 2606 OID 19283)
-- Name: event_utilisateur fk7lnolj7e3q1cqoiw3pmqao3eb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_utilisateur
    ADD CONSTRAINT fk7lnolj7e3q1cqoiw3pmqao3eb FOREIGN KEY (event_id) REFERENCES public.event(id);


--
-- TOC entry 3149 (class 2606 OID 19263)
-- Name: commentaire fkfkx1pegfdsd6e3cp2wblsc5jf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fkfkx1pegfdsd6e3cp2wblsc5jf FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3154 (class 2606 OID 19288)
-- Name: utilisateur fkfoo30p9ydfha8wfoiraoexwlm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT fkfoo30p9ydfha8wfoiraoexwlm FOREIGN KEY (serveur_id) REFERENCES public.serveur(id);


--
-- TOC entry 3152 (class 2606 OID 19278)
-- Name: event_utilisateur fkgse4b270fvc3vdiojwyewa0kk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_utilisateur
    ADD CONSTRAINT fkgse4b270fvc3vdiojwyewa0kk FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3150 (class 2606 OID 19268)
-- Name: event fkpa5qdcnknn84nueetp4s6xkt6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT fkpa5qdcnknn84nueetp4s6xkt6 FOREIGN KEY (serveur_id) REFERENCES public.serveur(id);


-- Completed on 2021-04-27 07:04:31 CEST

--
-- PostgreSQL database dump complete
--

