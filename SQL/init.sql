DROP DATABASE IF EXISTS imas;

DROP USER IF EXISTS yagi2;
CREATE USER yagi2 WITH PASSWORD 'yagi2' CREATEDB;

CREATE DATABASE imas
    WITH OWNER = yagi2
    ENCODING = 'UTF8';

\c imas yagi2

DROP TABLE IF EXISTS character;

CREATE TABLE character
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(16),
    phonetic VARCHAR(16),
    age INT,
    cv_name VARCHAR(16),
    cv_phonetic VARCHAR(16)
);

ALTER TABLE character
    OWNER TO yagi2;