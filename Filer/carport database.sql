DROP DATABASE IF EXISTS `carport`;
CREATE DATABASE IF NOT EXISTS `carport`;
use carport;

CREATE TABLE materials (
	materialName VARCHAR (30),
    
    PRIMARY KEY (materialName)
);

INSERT INTO materials (materialName)
VALUES ("Trykimprægneret"),
("Egetræ");

CREATE TABLE components (
	compId INT AUTO_INCREMENT,
    compDesc VARCHAR(20) NOT NULL,
    material VARCHAR (30),
    compHeigth INT NOT NULL,
    compWidth INT NOT NULL,
    compLength INT NOT NULL DEFAULT 400,
    currentStock INT DEFAULT 0,
    vendorPrice INT,
    salesPrice INT,
    
    PRIMARY KEY (compId),
    FOREIGN KEY (material) REFERENCES materials (materialName)
);
ALTER TABLE components auto_increment=2000;

INSERT INTO components (compDesc,material,compHeigth,compWidth,currentStock,vendorPrice,salesPrice)
VALUES  ("Stolpe", "Trykimprægneret", 10, 10, 74, 250, 475),
		("Stolpe", "Egetræ", 9, 9, 56, 400, 750),

		("Rem", "Trykimprægneret", 5, 19, 45, 135, 205),
		("Rem", "Egetræ", 5, 18, 4, 145, 215),
        
		("Spær", "Trykimprægneret", 5, 19, 80, 45, 85),
		("Spær", "Egetræ", 5, 18, 73, 50, 95),

		("Lægte", "Trykimprægneret", 4, 7, 37, 50, 95),
		("Lægte", "Egetræ", 4, 7, 7, 60, 105),
        
        ("Stern, over", "Trykimprægneret", 3, 13, 37, 50, 95),
        ("Stern, mellem", "Trykimprægneret", 3, 13, 37, 50, 95),
        ("Stern, under", "Trykimprægneret", 3, 13, 37, 50, 95),
		("Stern, over", "Egetræ", 2, 12, 41, 60, 110),
        ("Stern, mellem", "Egetræ", 2, 12, 41, 60, 110),
        ("Stern, under", "Egetræ", 2, 12, 41, 60, 110),

        ("Liste", "Trykimprægneret", 2, 4, 64, 21, 23),
        ("Liste", "Egetræ", 2, 4, 64, 21, 23),

		("Beklædning", "Trykimprægneret", 2, 10, 55, 7, 10),
        ("Beklædning", "Egetræ", 2, 10, 55, 7, 10);

CREATE TABLE roof (
	roofId INT AUTO_INCREMENT,
    roofDesc VARCHAR(30) NOT NULL,
    roofLength INT NOT NULL,
    roofWidth INT NOT NULL,
    currentStock INT DEFAULT 0,
    vendorPrice INT,
    salesPrice INT,
    
    PRIMARY KEY (roofId)
);
ALTER TABLE roof auto_increment=4000;

INSERT INTO roof (roofDesc,roofLength,roofWidth,currentStock,vendorPrice,salesPrice)
VALUES  ("PLASTMO", 200, 120, 71, 75, 130),
		("Betontagsten, sort", 42, 33, 224, 25, 45);
	
CREATE TABLE itemTypes (
	itemType VARCHAR(20) NOT NULL,
    
    PRIMARY KEY (itemType)
);

INSERT INTO itemTypes
VALUES  ("Styk"),
		("Pakke"),
		("Sæt"),
        ("Rulle");
    
CREATE TABLE parts (
	partId INT AUTO_INCREMENT,
    partDesc VARCHAR(50) NOT NULL,
    itemType VARCHAR(20) NOT NULL,
    currentStock INT DEFAULT 0,
    vendorPrice INT,
    salesPrice INT,
    
    PRIMARY KEY (partId),
    FOREIGN KEY (itemType) REFERENCES itemTypes (itemType)
);
ALTER TABLE parts auto_increment=6000;

INSERT INTO parts (partDesc,itemType,currentStock,vendorPrice,salesPrice)
VALUES  ("Skruer 5 x 100mm 100stk", "Pakke", 85, 40, 120),
        ("Skruer 4,5 x 120mm 200stk", "Pakke", 120, 15, 45),
        ("Skruer 4,5 x 70mm 200stk", "Pakke", 60, 20, 65),
        ("Skruer 4,5 x 60mm 200stk", "Pakke", 102, 15, 40),
        ("Skruer 4,5 x 50mm 350stk", "Pakke", 48, 20, 50),
        ("Skruer 4,0 x 50mm 250stk", "Pakke" ,75, 70, 150),
        ("PLASTMO bundskruer 200stk", "Pakke", 30, 20, 45),

        ("Bræddebolt 10 x 120mm", "Sæt", 128, 10, 19),

        ("Hulbånd 1x20mm x 10m", "Rulle", 48, 90, 200),

		("Universalbeslag 190mm højre", "Styk", 83, 15, 35),
        ("Universalbeslag 190mm venstre", "Styk", 85, 15, 35),
        ("Vinkelbeslag", "Styk", 325, 5, 9),
        ("Firkantskive 40 x 40 x 11mm", "Styk", 392, 3, 5),
        ("Bræddeplade 200 x 150 x 5mm", "Styk", 264, 15, 28);


CREATE TABLE validations (
	valueDesc VARCHAR(40) NOT NULL,
    validValue INT NOT NULL,
    
    PRIMARY KEY (valueDesc)
);

INSERT INTO validations (valueDesc,validValue)
VALUES  ("Carspace height", 185),
		("Carspace length", 300),
        ("Carspace width", 250);
        
CREATE TABLE configurationStatus (
	confStatus VARCHAR(20) NOT NULL,
    confStatusId INT NOT NULL,

    PRIMARY KEY (confStatus)
);

INSERT INTO configurationStatus (confStatus, confStatusId)
VALUES  ("Ny", 1),
		("Behandles", 2),
        ("Tilbud sendt", 3),
		("Afsluttet", 4);

CREATE TABLE configurations (
	confId INT NOT NULL AUTO_INCREMENT,
    confStatus VARCHAR (20),
    custName VARCHAR (35) NOT NULL,
    custPhone INT NOT NULL,
    custEmail VARCHAR (30) NOT NULL,
    custPostal INT NOT NULL,
    length INT NOT NULL,
    width INT NOT NULL,
    height INT NOT NULL,
    material VARCHAR (30),
    roofInclination INT DEFAULT 0,
	roofMaterial VARCHAR (30),
    rightSide BOOLEAN DEFAULT  false,
    leftSide BOOLEAN DEFAULT  false,
    backSide BOOLEAN DEFAULT  false,
    createdDate VARCHAR(10) DEFAULT (curdate()),
    changedDate VARCHAR(10) DEFAULT (curdate()),
    
    PRIMARY KEY (confId),
    FOREIGN KEY (confStatus) REFERENCES configurationStatus (confStatus)
    
    );
ALTER TABLE configurations auto_increment=224466;
CREATE TRIGGER changeDateTrigger
    BEFORE UPDATE ON configurations
    FOR EACH ROW
    SET new.changedDate = curdate();

INSERT INTO configurations (confStatus, custName, custPhone, custEmail, custPostal, length, width, height, material, roofInclination, roofMaterial, rightSide, leftSide, backSide, createdDate, changedDate)
VALUES  ("Afsluttet", "Abbott", 44884488, "abbott@bot.com", 5020, 300, 580, 225, "Egetræ", 0, "PLASTMO", true, true, true, "2020-05-25", "2020-05-26"),
		("Behandles", "Costello", 22662266, "costello@ost.com", 2550, 300, 450, 225, "Trykimprægneret", 0, "Betontagsten, sort", false, true, true, "2020-05-26", "2020-05-27");





use carport;