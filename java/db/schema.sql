CREATE TABLE IF NOT EXISTS public.employee
(
    employeeid integer NOT NULL DEFAULT nextval('employee_employeeid_seq'::regclass),
    end_date timestamp(6) without time zone,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "position" character varying(255) COLLATE pg_catalog."default",
    start_date timestamp(6) without time zone,
    CONSTRAINT employee_pkey PRIMARY KEY (employeeid)
)



CREATE OR REPLACE FUNCTION getEmployeesByWildcardName(wildcard_name TEXT)
RETURNS TABLE(employeeid INT, name VARCHAR, "position" VARCHAR, start_date TIMESTAMP, end_date TIMESTAMP) AS $$
BEGIN
    RETURN QUERY
    SELECT e.employeeid, e.name, e."position", e.start_date, e.end_date
    FROM public.employee e
    WHERE e.name ILIKE '%' || wildcard_name || '%';
END;
$$ LANGUAGE plpgsql;