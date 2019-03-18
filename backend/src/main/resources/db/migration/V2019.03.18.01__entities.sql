CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 START WITH 100;

CREATE TABLE request_type (
  id    BIGINT      NOT NULL,
  name  VARCHAR(64) NOT NULL,
  CONSTRAINT pk_request_type PRIMARY KEY (id)
);

CREATE TABLE form (
  id            BIGINT NOT NULL,
  policy_number VARCHAR(128),
  name          VARCHAR(255),
  surname       VARCHAR(255),
  request       VARCHAR(2000),
  request_type  BIGINT NOT NULL,
  CONSTRAINT pk_form PRIMARY KEY (id),
  CONSTRAINT fk_request_type FOREIGN KEY (request_type) REFERENCES request_type(id)
);