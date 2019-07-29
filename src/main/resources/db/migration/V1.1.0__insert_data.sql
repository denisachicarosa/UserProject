INSERT INTO company_schema.roles (title) VALUES ('admin');
INSERT INTO company_schema.roles (title) VALUES ('manager');
INSERT INTO company_schema.roles (title) VALUES('manager');

INSERT INTO company_schema.users (username,password)   VALUES('Ana','ana');
INSERT INTO company_schema.users (username,password)   VALUES('Bill','pass');
INSERT INTO company_schema.users (username,password)   VALUES('Cain','Lockwood');
INSERT INTO company_schema.users (username,password)   VALUES('Jessica','pearson');


INSERT INTO company_schema.permissions (description) VALUES ('delete users');
INSERT INTO company_schema.permissions (description) VALUES ('update users');
INSERT INTO company_schema.permissions (description) VALUES ('add users');
INSERT INTO company_schema.permissions (description) VALUES ('view users');
INSERT INTO company_schema.permissions (description) VALUES ('change his own password');

INSERT INTO company_schema.map_role (id_role,id_user)  VALUES('1','2');
INSERT INTO company_schema.map_role (id_role,id_user)  VALUES('1','3');
INSERT INTO company_schema.map_role (id_role,id_user)  VALUES('2','1');

INSERT INTO company_schema.map_permission (id_role,id_permission)  VALUES('1','1');
INSERT INTO company_schema.map_permission (id_role,id_permission)  VALUES('1','2');
INSERT INTO company_schema.map_permission (id_role,id_permission)  VALUES('2','2');

INSERT INTO company_schema.hibernate_sequence (next_val) values ('4');