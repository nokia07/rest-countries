CREATE TABLE IF NOT EXISTS countries (
    id INT NOT NULL PRIMARY KEY,
    name varchar(32) DEFAULT NULL,
    capital varchar(20) DEFAULT NULL,
    currency varchar(13) DEFAULT NULL,
    population BIGINT DEFAULT NULL
);
