DROP TABLE IF EXISTS pazymiai;
DROP TABLE IF EXISTS studentai;
CREATE TABLE studentai (
  Id int NOT NULL AUTO_INCREMENT,
  vardas varchar(100) NOT NULL,
  pavarde varchar(100) NOT NULL,
  el_pastas varchar(200) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE pazymiai (
  Id int NOT NULL AUTO_INCREMENT,
  studentas_id int DEFAULT NULL,
  data DATE DEFAULT NULL,
  pazymys int DEFAULT NULL,
  PRIMARY KEY (Id)

);
