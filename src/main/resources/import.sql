INSERT INTO `usuarios` (nome, login, password, enabled) VALUES ('fulano', 'fulano', '$2a$10$Dl5PAe9kftBJETlV5uJNgOxqiNCjKTaeIgibMSXDHZMQ8sb3KrDvu', true);
INSERT INTO `usuarios` (nome, login, password,enabled) VALUES ('beltrano', 'beltrano', '$2a$10$4ay.9Vaw3VjmGc1AnAdRVuNEGDkZ1zlklZV/s2PjEO.URvKZHdiwm', true);

INSERT INTO `roles` (nome,enabled) VALUES ('ROLE_USER', true);
INSERT INTO `roles` (nome, enabled) VALUES ('ROLE_ADMIN', true);

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,1);