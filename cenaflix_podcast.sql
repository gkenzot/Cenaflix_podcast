DROP DATABASE IF EXISTS cenaflix_podcast;
CREATE DATABASE IF NOT EXISTS cenaflix_podcast;

USE cenaflix_podcast;

CREATE TABLE usuario (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(30),
login VARCHAR(100),
senha TEXT,
tipo VARCHAR(30)
);

CREATE TABLE podcast (
id INT PRIMARY KEY AUTO_INCREMENT,
produtor VARCHAR(100),
nome VARCHAR(100),
numero INT,
duracao varchar(5),
url VARCHAR(100)
);

INSERT INTO usuario (nome, login, senha, tipo)
VALUES
('Ana', 'ana@email.com', md5('123'), 'Admin'),
('Otavio', 'otavio@email.com', md5('123'), 'Operador'),
('Ulisses', 'ulisses@email.com', md5('123'), 'Usuario'),
('Antonia', 'antonia@email.com', md5('123'), 'Atendente');

INSERT INTO podcast (produtor, nome, numero, duracao, url) VALUES
('João Silva', 'Podcast 1', 1, '01:20', 'http://exemplo.com/podcast1.mp3'),
('Maria Oliveira', 'Podcast 2', 2, '00:40', 'http://exemplo.com/podcast2.mp3'),
('Carlos Santos', 'Podcast 3', 3, '02:10', 'http://exemplo.com/podcast3.mp3');


SELECT * FROM usuario;
SELECT * FROM podcast;