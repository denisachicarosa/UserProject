--DROP SCHEMA company_schema;
--DROP TABLE schema_version;

CREATE SCHEMA IF NOT EXISTS company_schema;

CREATE TABLE company_schema.hibernate_sequence (
  next_val bigint not null AUTO_INCREMENT,
PRIMARY KEY(next_val)
);

CREATE TABLE company_schema.map_permission (
  id_role int not null,
  id_permission int not null
);
CREATE TABLE company_schema.users (
  id_user INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id_user)
);


CREATE TABLE company_schema.roles (
  id_role INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(100),
PRIMARY KEY (id_role)
);

CREATE TABLE company_schema.permissions (
  id_permission INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(200),
PRIMARY KEY (id_permission)
);

CREATE TABLE company_schema.map_role (
    id_user int NOT NULL,
    id_role int NOT NULL
);
--CONSTRAINT FK_Id_User FOREIGN KEY (id_user)
--REFERENCES users(id_user)



ALTER TABLE company_schema.map_role ADD CONSTRAINT Pk_map_role PRIMARY KEY (id_user, id_role);
ALTER TABLE company_schema.map_role ADD CONSTRAINT Fk1_map_role FOREIGN KEY (id_role) REFERENCES roles(id_role) ON DELETE CASCADE;
ALTER TABLE company_schema.map_role ADD CONSTRAINT Fk2_map_role FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE;



ALTER TABLE  company_schema.map_permission ADD CONSTRAINT Pk_map_permission PRIMARY KEY (id_role, id_permission) ;
ALTER TABLE company_schema.map_permission ADD CONSTRAINT Fk1_map_permission FOREIGN KEY (id_role) REFERENCES roles(id_role)  ON DELETE CASCADE;
ALTER TABLE company_schema.map_permission ADD CONSTRAINT Fk2_map_permission FOREIGN KEY (id_permission) REFERENCES permissions(id_permission) ON DELETE CASCADE;