CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rolename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename_UNIQUE` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_id_roles_idx` (`role_id`),
  CONSTRAINT `fk_id_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO users(username, password) VALUES("user", "$2a$12$DMvxwTYMzYLM0BLRzUR46uhQkhxJl9V/cMgSm5FtlqXbvZv0jNedC");
INSERT INTO users(username, password) VALUES("admin", "$2a$12$lXnBGLz50QiTQpEj4yh5tu2f/U8Zg8vtO9VQewWoW3la2UyTB2MKC");
INSERT INTO roles(rolename) VALUES('ROLE_USER');
INSERT INTO roles(rolename) VALUES('ROLE_ADMIN');
INSERT INTO users_roles(user_id, role_id) VALUES(1, 2);
INSERT INTO users_roles(user_id, role_id) VALUES(2, 1);
INSERT INTO users_roles(user_id, role_id) VALUES(2, 2);