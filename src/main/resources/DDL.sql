CREATE SCHEMA IF NOT EXISTS public;
--CREATING DATABASE
CREATE DATABASE autoria WITH OWNER postgres;
ALTER SCHEMA public OWNER TO postgres;

--SCHEMA

CREATE TABLE "user" (
                      id SERIAL,
                      password  VARCHAR NOT NULL,
                      email  VARCHAR NOT NULL,
                      first_name  VARCHAR NOT NULL,
                      last_name  VARCHAR NOT NULL,
                      user_role VARCHAR NOT NULL DEFAULT 'ROLE_CUSTOMER',
                      status VARCHAR NOT NULL DEFAULT 'ACTIVE',
                      PRIMARY KEY (id)
);

CREATE TABLE "category" (
                         id INT UNIQUE NOT NULL,
                         name  VARCHAR NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE "body" (
                              id INT UNIQUE NOT NULL,
                              name  VARCHAR NOT NULL,
                              PRIMARY KEY (id)
);

CREATE TABLE "category_body" (
                                  category_id INT NOT NULL,
                                  body_id INT NOT NULL,
                                  FOREIGN KEY (category_id) REFERENCES category (id),
                                  FOREIGN KEY (body_id) REFERENCES body (id)

);

CREATE TABLE "brand" (
                          id INT UNIQUE NOT NULL,
                          name  VARCHAR NOT NULL,
                          PRIMARY KEY (id)
);

CREATE TABLE "model" (
                         id INT UNIQUE NOT NULL,
                         name  VARCHAR NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE "category_brand_model" (
                                  id SERIAL,
                                  category_id INT NOT NULL,
                                  brand_id INT NOT NULL,
                                  model_id INT NOT NULL,
                                  PRIMARY KEY (id),
                                  FOREIGN KEY (category_id) REFERENCES category (id),
                                  FOREIGN KEY (brand_id) REFERENCES brand (id),
                                  FOREIGN KEY (model_id) REFERENCES model (id)
);

CREATE TABLE "region" (
                         id INT UNIQUE NOT NULL,
                         name  VARCHAR NOT NULL,
                         PRIMARY KEY (id)
);
CREATE TABLE "city" (
                          id INT UNIQUE NOT NULL,
                          name  VARCHAR NOT NULL,
                          PRIMARY KEY (id)
);

CREATE TABLE "region_city" (
                                 region_id INT NOT NULL,
                                 city_id INT NOT NULL,
                                 FOREIGN KEY (region_id) REFERENCES region (id),
                                 FOREIGN KEY (city_id) REFERENCES city (id)

);

CREATE TABLE "drive" (
                        id INT UNIQUE NOT NULL,
                        name  VARCHAR NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE "category_drive" (
                         category_id INT NOT NULL,
                         drive_id INT NOT NULL,
                         FOREIGN KEY (category_id) REFERENCES category (id),
                         FOREIGN KEY (drive_id) REFERENCES drive (id)

);

CREATE TABLE "fuel" (
                          id INT UNIQUE NOT NULL,
                          name  VARCHAR NOT NULL,
                          PRIMARY KEY (id)
  );

CREATE TABLE "gearbox" (
                        id INT UNIQUE NOT NULL,
                        name  VARCHAR NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE "category_gearbox" (
                                 category_id INT NOT NULL,
                                 gearbox_id INT NOT NULL,
                                 FOREIGN KEY (category_id) REFERENCES category (id),
                                 FOREIGN KEY (gearbox_id) REFERENCES gearbox (id)

);

CREATE TABLE "colour" (
                           id INT UNIQUE NOT NULL,
                           name  VARCHAR NOT NULL,
                           PRIMARY KEY (id)
);

CREATE TABLE "request" (
                           id SERIAL,
                           category_id INT NOT NULL,
                           body_id INT NOT NULL,
                           brand_id INT NOT NULL,
                           model_id INT NOT NULL,
                           region_id INT,
                           city_id INT,
                           drive_id INT [],
                           fuel_id INT [],
                           gearbox_id INT,
                           colour_id INT,
                           price_min DECIMAL,
                           price_max DECIMAL,
                           user_id INT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (category_id) REFERENCES category (id),
                           FOREIGN KEY (body_id) REFERENCES body (id),
                           FOREIGN KEY (brand_id) REFERENCES brand (id),
                           FOREIGN KEY (model_id) REFERENCES model (id),
                           FOREIGN KEY (region_id) REFERENCES region (id),
                           FOREIGN KEY (city_id) REFERENCES city (id),
                           FOREIGN KEY (gearbox_id) REFERENCES gearbox (id),
                           FOREIGN KEY (colour_id) REFERENCES colour (id),
                           FOREIGN KEY (user_id) REFERENCES "user" (id)
);
