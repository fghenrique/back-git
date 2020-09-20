INSERT INTO `usuarios` (nome, login, password) VALUES ('fulano', 'fulano', '12345');
INSERT INTO `usuarios` (nome, login, password) VALUES ('beltrano', 'beltrano', '12345');

INSERT INTO `roles` (nome) VALUES ('ROLES_USER');
INSERT INTO `roles` (nome) VALUES ('ROLES_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,1);