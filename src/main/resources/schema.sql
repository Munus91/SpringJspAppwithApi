DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS users;


CREATE TABLE goods(
                      good_id SERIAL PRIMARY KEY,
                      name CHARACTER VARYING(100) NOT NULL ,
                      category CHARACTER VARYING(100) NOT NULL,
                      sub_category CHARACTER VARYING(100) NOT NULL,
                      trade_mark CHARACTER VARYING(100) NOT NULL,
                      country_id INT NOT NULL ,
                      price DECIMAL NOT NULL ,
                      amount INT NOT NULL ,
                      good_description CHARACTER VARYING(100),
                      created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL ,
                      updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                      archived BOOLEAN DEFAULT FALSE

);

CREATE TABLE countries(
                          country_id SERIAL PRIMARY KEY,
                          name CHARACTER VARYING(100) NOT NULL

);

CREATE TABLE users(
                      user_id SERIAL PRIMARY KEY,
                      username CHARACTER VARYING(100) NOT NULL ,
                      name CHARACTER VARYING(100) NOT NULL ,
                      surname CHARACTER VARYING(100) NOT NULL ,
                      password CHARACTER VARYING(100) NOT NULL ,
                      role CHARACTER VARYING(100) NOT NULL ,
                      city CHARACTER VARYING(100) NOT NULL ,
                      addressline1 CHARACTER VARYING(100) NOT NULL ,
                      addressline2 CHARACTER VARYING(100) NOT NULL ,
                      created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL ,
                      updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                      archived BOOLEAN DEFAULT FALSE
);