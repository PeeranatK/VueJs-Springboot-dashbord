CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  value VARCHAR(255)
);

-- Add initial data
INSERT IGNORE INTO user (username, password) VALUES ('user1', 'pass1');
INSERT IGNORE INTO user (username, password) VALUES ('user2', '$2a$10$Nj4orWefY24sEiEbwXw8ZeP2ErmxkDaqRYKW1XmaBMRzNJ2CTJ/jm');
