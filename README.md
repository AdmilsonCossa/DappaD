DappaD
======

notepad


database creation:

CREATE USER dappadadmin@localhost identified BY '1234';
GRANT usage ON *.* TO dappadadmin@localhost identified BY '1234';
GRANT ALL privileges ON dappad.* TO dappadadmin@localhost;
USE dappad;


CREATE TABLE `notes` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`TITLE` VARCHAR(30) NULL DEFAULT NULL,
	`TEXT` VARCHAR(30) NULL DEFAULT NULL,
	`CREATED` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`ID`)
)
