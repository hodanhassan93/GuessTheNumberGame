create database wileydi004;

use wileydi004;

CREATE TABLE game (
    GAME_ID INT AUTO_INCREMENT PRIMARY KEY,
    GameAnswer VARCHAR(4) NOT NULL,
    GameStatus BOOLEAN NOT NULL
);

CREATE TABLE round (
    ROUND_ID INT AUTO_INCREMENT PRIMARY KEY,
    GAME_ID INT,
    Guess VARCHAR(4),
    Time_of_guess TIMESTAMP,
    Result VARCHAR(7),
    FOREIGN KEY (GAME_ID) REFERENCES game (GAME_ID)
);

INSERT INTO game
VALUES (1, '1234', false),
       (2, '2345', false);

INSERT INTO round
VALUES (1, 1, '6545', '2023-06-28 12:34:56', 'e:0,p:2');


select * from round;