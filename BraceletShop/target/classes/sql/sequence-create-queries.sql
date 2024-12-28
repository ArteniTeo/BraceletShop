CREATE SEQUENCE IF NOT EXISTS "DocDB".appointments_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".appointments_id_seq
    OWNER TO postgres;

-- ===========================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".doctors_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".doctors_id_seq
    OWNER TO postgres;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB"."lab results_id_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY lab_results.id;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".observations_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY observations.id;

ALTER SEQUENCE "DocDB".observations_id_seq
    OWNER TO postgres;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".patients_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".patients_id_seq
    OWNER TO postgres;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".specialities_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".specialities_id_seq
    OWNER TO postgres;


--======================================================


CREATE SEQUENCE IF NOT EXISTS "DocDB".users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".users_id_seq
    OWNER TO postgres;


   INSERT INTO "DocDB".users(
    email, username, password, status, account_type)
    VALUES ('ira@gmail.com', 'ira', 'pswd', 'ACTIVE', 'PATIENT');


   INSERT INTO "DocDB".patients(
   	user_id, firstname, lastname, phone_number, cnp, birth_day, gender)
   	VALUES (1, 'FirstName', 'LastName', '0730679884', '9084903926731', '1980-05-19', 'FEMALE');


   INSERT INTO "DocDB".doctors(
   	user_id, firstname, lastname, speciality)
   	VALUES (1, 'Artur', 'Donica', 'Din ala pt spate');


   INSERT INTO "DocDB".appointments(
   	patient_id, doctor_id, date, details, observations)
   	VALUES (1, 1, '2023-08-23', 'No details', 'No observations');

