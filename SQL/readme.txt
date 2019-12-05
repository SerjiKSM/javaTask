CREATE SCHEMA dev;

CREATE TABLE dev.users (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  first_name varchar(55) DEFAULT NULL,
  last_name varchar(100) DEFAULT NULL,
  login varchar(100) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  role varchar(55) DEFAULT NULL,
  state varchar(55) DEFAULT NULL,
  city varchar(55) DEFAULT NULL,
  state_usa_id int DEFAULT NULL,
  city_canada_id int DEFAULT NULL
);

CREATE TABLE dev.states_usa (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  title varchar(255) DEFAULT NULL
);

CREATE TABLE dev.provinces_canada (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  title varchar(255) DEFAULT NULL
);

CREATE TABLE dev.cities_canada (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  title varchar(255) DEFAULT NULL,
  province_id int NOT NULL
);


INSERT INTO dev_db.dev.states_usa
    (title)
VALUES
        ('State of Idaho'),
        ('State of Iowa'),
	('State of Alabama'),
	('State of Alaska'),
	('State of Arizona');


INSERT INTO dev_db.dev.provinces_canada
    (title)
VALUES
        ('Ontario'),
        ('Quebec'),
	('Alberta'),
	('Manitoba'),
	('British Columbia');


INSERT INTO dev_db.dev.cities_canada
    (title, province_id)
VALUES
       ('Toronto', 1),
       ('Ottawa', 1),
       ('Montreal', 2),
       ('Laval', 2),
       ('Calgary', 3),
       ('Edmonton', 3),
       ('Winnipeg', 4),
       ('Vancouver', 5),
       ('Burnaby', 5);


INSERT INTO dev_db.dev.users
    (first_name, last_name, login, password, role, state, city, state_usa_id, city_canada_id)
VALUES
       ('ser',   'ser', 'ser',  '$2a$10$kbE6GccXzdKgEKouCDMdF.X4S4Qb4qq.nM3OKzShorEjg3UsL/Cuy', 'USER', 'ACTIVE', 'USA', 1, null),
       ('ser1', 'ser1', 'ser1', '$2a$10$MLhiaBEyox2Tr658WTzzdetU7OuegFT91n4bvLJo6J', 'USER', 'ACTIVE', 'USA', 1, null),
       ('ser2', 'ser2', 'ser2', '$2a$10$Zg.7R9rJT2ZcQfenm/Xr7.gQYRC0juwgFR8lSVXev8gzU2e/Xqtoy', 'USER', 'ACTIVE', 'USA', 1, null),
       ('ser3', 'ser3', 'ser3', '$2a$10$hMXb4Dz1szrmzMdJ6SMkeOpCcEfd9MqRvSL1NBmUopPduUOhtzLTy', 'USER', 'ACTIVE', 'CANADA', null, 1),
       ('ser4', 'ser4', 'ser4', '$2a$10$b.6qbNPmc6Mj9im/RmVMYOZOJMC.u3DQUOXVbZz7W9liN0sQsg89C', 'USER', 'ACTIVE', 'CANADA', null, 1);



gradle clean build
 cd build/libs/
 java -jar dev-0.0.1-SNAPSHOT.jar

