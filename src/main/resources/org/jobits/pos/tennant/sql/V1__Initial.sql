CREATE TABLE Base_Datos (
  id         SERIAL NOT NULL, 
  Cuentaid   int4 NOT NULL, 
  nombre     varchar(100) NOT NULL, 
  url        varchar(255) NOT NULL, 
  usuario    varchar(100) NOT NULL, 
  contrasena varchar(255) NOT NULL, 
  driver     varchar(100) NOT NULL,
  Tokenid    int4, 
  estado     varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE Cuenta (
  id         SERIAL NOT NULL, 
  usuario    varchar(50) NOT NULL UNIQUE, 
  contrasena varchar(255) NOT NULL, 
  estado     varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE Token (
  id         SERIAL NOT NULL, 
  token      varchar(255) NOT NULL UNIQUE, 
  expiracion date, 
  PRIMARY KEY (id));
ALTER TABLE Base_Datos ADD CONSTRAINT FKBase_Datos106897 FOREIGN KEY (Tokenid) REFERENCES Token (id);
ALTER TABLE Base_Datos ADD CONSTRAINT FKBase_Datos588987 FOREIGN KEY (Cuentaid) REFERENCES Cuenta (id);
