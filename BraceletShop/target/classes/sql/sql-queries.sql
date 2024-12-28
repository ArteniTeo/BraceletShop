-- here will be all SQLs

--schema create query
CREATE SCHEMA IF NOT EXISTS "DocDB"
    AUTHORIZATION postgres;




--appointments create query :
CREATE TABLE IF NOT EXISTS "DocDB".appointments
(
    id integer NOT NULL DEFAULT nextval('"DocDB".appointments_id_seq'::regclass),
    patient_id bigint NOT NULL,
    doctor_id bigint NOT NULL,
    date date NOT NULL,
    details character varying COLLATE pg_catalog."default",
    appointment_type character varying COLLATE pg_catalog."default" NOT NULL,
    "time" time with time zone NOT NULL,
    appointment_status character varying COLLATE pg_catalog."default",
    observation_id bigint,
    CONSTRAINT appointments_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".appointments
    OWNER to postgres;



--doctors create query
CREATE TABLE IF NOT EXISTS "DocDB".doctors
(
    id integer NOT NULL DEFAULT nextval('"DocDB".doctors_id_seq'::regclass),
    user_id bigint NOT NULL,
    firstname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    speciality_id bigint NOT NULL,
    CONSTRAINT doctors_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".doctors
    OWNER to postgres;


--Lab results create query

CREATE TABLE IF NOT EXISTS "DocDB".lab_results
(
    id integer NOT NULL DEFAULT nextval('"DocDB"."lab results_id_seq"'::regclass),
    patient_id bigint NOT NULL,
    doctor_id bigint NOT NULL,
    exam_date date NOT NULL,
    exam_name character varying COLLATE pg_catalog."default" NOT NULL,
    results character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "lab results_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".lab_results
    OWNER to postgres;


--observations create query

CREATE TABLE IF NOT EXISTS "DocDB".observations
(
    id integer NOT NULL DEFAULT nextval('"DocDB".observations_id_seq'::regclass),
    diagnosis character varying COLLATE pg_catalog."default" NOT NULL,
    applied_procedure character varying COLLATE pg_catalog."default",
    recommendation character varying COLLATE pg_catalog."default",
    treatment character varying COLLATE pg_catalog."default",
    referral character varying COLLATE pg_catalog."default",
    CONSTRAINT observations_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".observations
    OWNER to postgres;


--patients create query
CREATE TABLE IF NOT EXISTS "DocDB".patients
(
    id integer NOT NULL DEFAULT nextval('"DocDB".patients_id_seq'::regclass),
    user_id bigint NOT NULL,
    firstname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying COLLATE pg_catalog."default" NOT NULL,
    cnp character varying COLLATE pg_catalog."default" NOT NULL,
    birth_day date NOT NULL,
    gender character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT patients_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".patients
    OWNER to postgres;


--specialities create query

CREATE TABLE IF NOT EXISTS "DocDB".specialities
(
    id integer NOT NULL DEFAULT nextval('"DocDB".specialities_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT specialities_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".specialities
    OWNER to postgres;


--users create query
CREATE TABLE IF NOT EXISTS "DocDB".users
(
    id integer NOT NULL DEFAULT nextval('"DocDB".users_id_seq'::regclass),
    email character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,
    account_type character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".users
    OWNER to postgres;


ALTER TABLE "DocDB".appointments
	ADD COLUMN appointment_type character varying;

ALTER TABLE "DocDB".appointments
	ADD COLUMN "time" time with time zone;