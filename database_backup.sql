--
-- PostgreSQL database dump
--

-- Dumped from database version 12.19
-- Dumped by pg_dump version 12.6

-- Started on 2024-07-30 20:36:05 -03

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
-- TOC entry 3304 (class 1262 OID 17844)
-- Name: barbearia_smartbooking; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE barbearia_smartbooking WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE barbearia_smartbooking OWNER TO postgres;

\connect barbearia_smartbooking

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
-- TOC entry 207 (class 1259 OID 17886)
-- Name: agenda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.agenda (
    id bigint NOT NULL,
    dia date NOT NULL,
    pessoa_id bigint NOT NULL
);


ALTER TABLE public.agenda OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17983)
-- Name: avaliacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.avaliacao (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    nota integer NOT NULL,
    pessoa_id bigint NOT NULL,
    servico_id bigint NOT NULL
);


ALTER TABLE public.avaliacao OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 18424)
-- Name: barbeiro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.barbeiro (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    telefone character varying(255) NOT NULL,
    tipo_pessoa character varying(255) NOT NULL,
    anos_de_experiencia integer,
    agenda_id bigint
);


ALTER TABLE public.barbeiro OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 18363)
-- Name: barbeiro_servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.barbeiro_servico (
    barbeiro_id bigint NOT NULL,
    servico_id bigint NOT NULL
);


ALTER TABLE public.barbeiro_servico OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 18368)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    telefone character varying(255) NOT NULL,
    tipo_pessoa character varying(255) NOT NULL,
    cpf character varying(255),
    data_de_nascimento date
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 18125)
-- Name: cupom_de_desconto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cupom_de_desconto (
    id bigint NOT NULL,
    codigo character varying(255) NOT NULL,
    dt_validade date NOT NULL,
    valor_desconto_numeric numeric(19,2),
    valor_desconto_porcentagem numeric(19,2)
);


ALTER TABLE public.cupom_de_desconto OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 18376)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id bigint NOT NULL,
    bairro character varying(255) NOT NULL,
    cep character varying(255) NOT NULL,
    cidade character varying(255) NOT NULL,
    complemento character varying(255),
    numero character varying(255) NOT NULL,
    rua character varying(255) NOT NULL,
    tipo_endereco character varying(255) NOT NULL,
    uf character varying(255) NOT NULL,
    pessoa_id bigint NOT NULL
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 18134)
-- Name: forma_de_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.forma_de_pagamento (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE public.forma_de_pagamento OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17867)
-- Name: horarios_disponiveis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.horarios_disponiveis (
    id bigint NOT NULL,
    hora_fim timestamp without time zone NOT NULL,
    hora_inicio timestamp without time zone NOT NULL,
    agenda_id bigint NOT NULL
);


ALTER TABLE public.horarios_disponiveis OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 18141)
-- Name: nota_fiscal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_fiscal (
    id bigint NOT NULL,
    numero character varying(255) NOT NULL,
    pdf text NOT NULL,
    serie character varying(255) NOT NULL,
    tipo character varying(255) NOT NULL,
    xml text NOT NULL,
    servico_concluido_id bigint NOT NULL
);


ALTER TABLE public.nota_fiscal OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17908)
-- Name: preco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.preco (
    id bigint NOT NULL,
    preco numeric(19,2) NOT NULL,
    barbeiro_id bigint NOT NULL,
    servico_id bigint NOT NULL
);


ALTER TABLE public.preco OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 18082)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17872)
-- Name: seq_agenda; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_agenda
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_agenda OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 18001)
-- Name: seq_avaliacao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_avaliacao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_avaliacao OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 18132)
-- Name: seq_cupom_de_desconto; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_cupom_de_desconto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_cupom_de_desconto OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17941)
-- Name: seq_endereco; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_endereco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_endereco OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 18139)
-- Name: seq_forma_de_pagamento; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_forma_de_pagamento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_forma_de_pagamento OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17874)
-- Name: seq_horarios_disponiveis; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_horarios_disponiveis
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_horarios_disponiveis OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 18157)
-- Name: seq_nota_fiscal; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_nota_fiscal
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_nota_fiscal OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17860)
-- Name: seq_pessoa; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_pessoa
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_pessoa OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17913)
-- Name: seq_preco; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_preco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_preco OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17850)
-- Name: seq_role; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_role
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_role OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17906)
-- Name: seq_servico; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_servico
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_servico OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 18159)
-- Name: seq_servico_concluido; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_servico_concluido
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_servico_concluido OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 18041)
-- Name: seq_user; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_user OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 18102)
-- Name: seq_users; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_users
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_users OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17901)
-- Name: servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servico (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    duracao integer NOT NULL
);


ALTER TABLE public.servico OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 18261)
-- Name: servico_concluido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servico_concluido (
    id bigint NOT NULL,
    data_do_agendamento date NOT NULL,
    data_do_servico date NOT NULL,
    horario_do_servico timestamp without time zone NOT NULL,
    valor_total numeric(19,2) NOT NULL,
    barbeiro_id bigint NOT NULL,
    cliente_id bigint NOT NULL,
    cupom_de_desconto_id bigint NOT NULL,
    endereco_cobranca_id bigint,
    endereco_servico_id bigint NOT NULL,
    forma_de_pagamento_id bigint NOT NULL,
    nota_fiscal_servico_id bigint NOT NULL
);


ALTER TABLE public.servico_concluido OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 18154)
-- Name: servico_concluido_servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servico_concluido_servico (
    servico_concluido_id bigint NOT NULL,
    servico_id bigint NOT NULL
);


ALTER TABLE public.servico_concluido_servico OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 18087)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    login character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    pessoa_id bigint NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 18095)
-- Name: users_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_role (
    users_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.users_role OWNER TO postgres;

--
-- TOC entry 3273 (class 0 OID 17886)
-- Dependencies: 207
-- Data for Name: agenda; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3279 (class 0 OID 17983)
-- Dependencies: 213
-- Data for Name: avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3298 (class 0 OID 18424)
-- Dependencies: 232
-- Data for Name: barbeiro; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3295 (class 0 OID 18363)
-- Dependencies: 229
-- Data for Name: barbeiro_servico; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3296 (class 0 OID 18368)
-- Dependencies: 230
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3286 (class 0 OID 18125)
-- Dependencies: 220
-- Data for Name: cupom_de_desconto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3297 (class 0 OID 18376)
-- Dependencies: 231
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3288 (class 0 OID 18134)
-- Dependencies: 222
-- Data for Name: forma_de_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3270 (class 0 OID 17867)
-- Dependencies: 204
-- Data for Name: horarios_disponiveis; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3290 (class 0 OID 18141)
-- Dependencies: 224
-- Data for Name: nota_fiscal; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3276 (class 0 OID 17908)
-- Dependencies: 210
-- Data for Name: preco; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3282 (class 0 OID 18082)
-- Dependencies: 216
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3274 (class 0 OID 17901)
-- Dependencies: 208
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3294 (class 0 OID 18261)
-- Dependencies: 228
-- Data for Name: servico_concluido; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3291 (class 0 OID 18154)
-- Dependencies: 225
-- Data for Name: servico_concluido_servico; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3283 (class 0 OID 18087)
-- Dependencies: 217
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3284 (class 0 OID 18095)
-- Dependencies: 218
-- Data for Name: users_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3305 (class 0 OID 0)
-- Dependencies: 205
-- Name: seq_agenda; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_agenda', 1, false);


--
-- TOC entry 3306 (class 0 OID 0)
-- Dependencies: 214
-- Name: seq_avaliacao; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_avaliacao', 1, false);


--
-- TOC entry 3307 (class 0 OID 0)
-- Dependencies: 221
-- Name: seq_cupom_de_desconto; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_cupom_de_desconto', 1, false);


--
-- TOC entry 3308 (class 0 OID 0)
-- Dependencies: 212
-- Name: seq_endereco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_endereco', 1, false);


--
-- TOC entry 3309 (class 0 OID 0)
-- Dependencies: 223
-- Name: seq_forma_de_pagamento; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_forma_de_pagamento', 1, false);


--
-- TOC entry 3310 (class 0 OID 0)
-- Dependencies: 206
-- Name: seq_horarios_disponiveis; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_horarios_disponiveis', 1, false);


--
-- TOC entry 3311 (class 0 OID 0)
-- Dependencies: 226
-- Name: seq_nota_fiscal; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_nota_fiscal', 1, false);


--
-- TOC entry 3312 (class 0 OID 0)
-- Dependencies: 203
-- Name: seq_pessoa; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_pessoa', 1, false);


--
-- TOC entry 3313 (class 0 OID 0)
-- Dependencies: 211
-- Name: seq_preco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_preco', 1, false);


--
-- TOC entry 3314 (class 0 OID 0)
-- Dependencies: 202
-- Name: seq_role; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_role', 1, false);


--
-- TOC entry 3315 (class 0 OID 0)
-- Dependencies: 209
-- Name: seq_servico; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_servico', 1, false);


--
-- TOC entry 3316 (class 0 OID 0)
-- Dependencies: 227
-- Name: seq_servico_concluido; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_servico_concluido', 1, false);


--
-- TOC entry 3317 (class 0 OID 0)
-- Dependencies: 215
-- Name: seq_user; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_user', 1, false);


--
-- TOC entry 3318 (class 0 OID 0)
-- Dependencies: 219
-- Name: seq_users; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_users', 1, false);


--
-- TOC entry 3086 (class 2606 OID 17890)
-- Name: agenda agenda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agenda
    ADD CONSTRAINT agenda_pkey PRIMARY KEY (id);


--
-- TOC entry 3092 (class 2606 OID 17987)
-- Name: avaliacao avaliacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_pkey PRIMARY KEY (id);


--
-- TOC entry 3116 (class 2606 OID 18431)
-- Name: barbeiro barbeiro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbeiro
    ADD CONSTRAINT barbeiro_pkey PRIMARY KEY (id);


--
-- TOC entry 3110 (class 2606 OID 18367)
-- Name: barbeiro_servico barbeiro_servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbeiro_servico
    ADD CONSTRAINT barbeiro_servico_pkey PRIMARY KEY (barbeiro_id, servico_id);


--
-- TOC entry 3112 (class 2606 OID 18375)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 3102 (class 2606 OID 18129)
-- Name: cupom_de_desconto cupom_de_desconto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cupom_de_desconto
    ADD CONSTRAINT cupom_de_desconto_pkey PRIMARY KEY (id);


--
-- TOC entry 3114 (class 2606 OID 18383)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 3104 (class 2606 OID 18138)
-- Name: forma_de_pagamento forma_de_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forma_de_pagamento
    ADD CONSTRAINT forma_de_pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 3084 (class 2606 OID 17871)
-- Name: horarios_disponiveis horarios_disponiveis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_disponiveis
    ADD CONSTRAINT horarios_disponiveis_pkey PRIMARY KEY (id);


--
-- TOC entry 3106 (class 2606 OID 18148)
-- Name: nota_fiscal nota_fiscal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_fiscal
    ADD CONSTRAINT nota_fiscal_pkey PRIMARY KEY (id);


--
-- TOC entry 3090 (class 2606 OID 17912)
-- Name: preco preco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.preco
    ADD CONSTRAINT preco_pkey PRIMARY KEY (id);


--
-- TOC entry 3094 (class 2606 OID 18086)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 3108 (class 2606 OID 18265)
-- Name: servico_concluido servico_concluido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT servico_concluido_pkey PRIMARY KEY (id);


--
-- TOC entry 3088 (class 2606 OID 17905)
-- Name: servico servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id);


--
-- TOC entry 3098 (class 2606 OID 18329)
-- Name: users_role uk_cdpd2ix59qroxmqubyjqplxn1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT uk_cdpd2ix59qroxmqubyjqplxn1 UNIQUE (role_id);


--
-- TOC entry 3100 (class 2606 OID 18101)
-- Name: users_role unique_role_users; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT unique_role_users UNIQUE (users_id, role_id);


--
-- TOC entry 3096 (class 2606 OID 18094)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3137 (class 2620 OID 18118)
-- Name: agenda validachavepessoainsert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoainsert BEFORE INSERT ON public.agenda FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3139 (class 2620 OID 18120)
-- Name: avaliacao validachavepessoainsert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoainsert BEFORE INSERT ON public.avaliacao FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3141 (class 2620 OID 18124)
-- Name: users validachavepessoainsert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoainsert BEFORE INSERT ON public.users FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3136 (class 2620 OID 18117)
-- Name: agenda validachavepessoaupdate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoaupdate BEFORE UPDATE ON public.agenda FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3138 (class 2620 OID 18119)
-- Name: avaliacao validachavepessoaupdate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoaupdate BEFORE UPDATE ON public.avaliacao FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3140 (class 2620 OID 18123)
-- Name: users validachavepessoaupdate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validachavepessoaupdate BEFORE UPDATE ON public.users FOR EACH ROW EXECUTE FUNCTION public.validachavepessoa();


--
-- TOC entry 3117 (class 2606 OID 17896)
-- Name: horarios_disponiveis agenda_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_disponiveis
    ADD CONSTRAINT agenda_fk FOREIGN KEY (agenda_id) REFERENCES public.agenda(id);


--
-- TOC entry 3135 (class 2606 OID 18432)
-- Name: barbeiro agenda_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbeiro
    ADD CONSTRAINT agenda_fk FOREIGN KEY (agenda_id) REFERENCES public.agenda(id);


--
-- TOC entry 3134 (class 2606 OID 18437)
-- Name: barbeiro_servico barbeiro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbeiro_servico
    ADD CONSTRAINT barbeiro_fk FOREIGN KEY (barbeiro_id) REFERENCES public.barbeiro(id);


--
-- TOC entry 3119 (class 2606 OID 18442)
-- Name: preco barbeiro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.preco
    ADD CONSTRAINT barbeiro_fk FOREIGN KEY (barbeiro_id) REFERENCES public.barbeiro(id);


--
-- TOC entry 3130 (class 2606 OID 18447)
-- Name: servico_concluido barbeiro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT barbeiro_fk FOREIGN KEY (barbeiro_id) REFERENCES public.barbeiro(id);


--
-- TOC entry 3126 (class 2606 OID 18409)
-- Name: servico_concluido cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT cliente_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


--
-- TOC entry 3128 (class 2606 OID 18281)
-- Name: servico_concluido cupom_de_desconto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT cupom_de_desconto_fk FOREIGN KEY (cupom_de_desconto_id) REFERENCES public.cupom_de_desconto(id);


--
-- TOC entry 3127 (class 2606 OID 18414)
-- Name: servico_concluido endereco_cobranca_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT endereco_cobranca_fk FOREIGN KEY (endereco_cobranca_id) REFERENCES public.endereco(id);


--
-- TOC entry 3129 (class 2606 OID 18419)
-- Name: servico_concluido endereco_servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT endereco_servico_fk FOREIGN KEY (endereco_servico_id) REFERENCES public.endereco(id);


--
-- TOC entry 3131 (class 2606 OID 18296)
-- Name: servico_concluido forma_de_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT forma_de_pagamento_fk FOREIGN KEY (forma_de_pagamento_id) REFERENCES public.forma_de_pagamento(id);


--
-- TOC entry 3132 (class 2606 OID 18301)
-- Name: servico_concluido nota_fiscal_servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido
    ADD CONSTRAINT nota_fiscal_servico_fk FOREIGN KEY (nota_fiscal_servico_id) REFERENCES public.nota_fiscal(id);


--
-- TOC entry 3121 (class 2606 OID 18104)
-- Name: users_role role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 3123 (class 2606 OID 18266)
-- Name: nota_fiscal servico_concluido_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_fiscal
    ADD CONSTRAINT servico_concluido_fk FOREIGN KEY (servico_concluido_id) REFERENCES public.servico_concluido(id);


--
-- TOC entry 3125 (class 2606 OID 18306)
-- Name: servico_concluido_servico servico_concluido_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido_servico
    ADD CONSTRAINT servico_concluido_fk FOREIGN KEY (servico_concluido_id) REFERENCES public.servico_concluido(id);


--
-- TOC entry 3118 (class 2606 OID 17920)
-- Name: preco servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.preco
    ADD CONSTRAINT servico_fk FOREIGN KEY (servico_id) REFERENCES public.servico(id);


--
-- TOC entry 3120 (class 2606 OID 18003)
-- Name: avaliacao servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT servico_fk FOREIGN KEY (servico_id) REFERENCES public.servico(id);


--
-- TOC entry 3124 (class 2606 OID 18201)
-- Name: servico_concluido_servico servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_concluido_servico
    ADD CONSTRAINT servico_fk FOREIGN KEY (servico_id) REFERENCES public.servico(id);


--
-- TOC entry 3133 (class 2606 OID 18389)
-- Name: barbeiro_servico servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbeiro_servico
    ADD CONSTRAINT servico_fk FOREIGN KEY (servico_id) REFERENCES public.servico(id);


--
-- TOC entry 3122 (class 2606 OID 18109)
-- Name: users_role users_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT users_fk FOREIGN KEY (users_id) REFERENCES public.users(id);


-- Completed on 2024-07-30 20:36:05 -03

--
-- PostgreSQL database dump complete
--

