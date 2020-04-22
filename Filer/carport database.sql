DROP DATABASE IF EXISTS `carport`;
CREATE DATABASE IF NOT EXISTS `carport`;
use carport;

CREATE TABLE materials (
	materialName VARCHAR (30),
    
    PRIMARY KEY (materialName)
);

INSERT INTO materials (materialName)
VALUES ("Trykimprægneret"),
("Egetræ"),
("Lærk");

CREATE TABLE components (
	compId INT AUTO_INCREMENT,
    compDescription VARCHAR(20) NOT NULL,
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

INSERT INTO components (compDescription,material,compHeigth,compWidth,currentStock,vendorPrice,salesPrice)
VALUES  ("Stople", "Trykimprægneret", 10, 10, 74, 250, 475),
		("Stople", "Egetræ", 9, 9, 56, 400, 750),

		("Rem", "Trykimprægneret", 5, 20, 45, 135, 205),
		("Rem", "Egetræ", 4, 22, 42, 145, 215),

		("Spær", "Trykimprægneret", 5, 12, 80, 45, 85),
		("Spær", "Egetræ", 4, 11, 73, 50, 95),

		("Lægte", "Trykimprægneret", 4, 12, 37, 50, 95),
		("Lægte", "Egetræ", 4, 11, 23, 60, 105),
        
        ("Stern", "Trykimprægneret", 3, 15, 37, 50, 95),
		("Stern", "Egetræ", 2, 14, 41, 60, 110);

CREATE TABLE roof (
	compId INT AUTO_INCREMENT,
    compDescription VARCHAR(30) NOT NULL,
    compHeight INT,
    compWidth INT,
    currentStock INT DEFAULT 0,
    vendorPrice INT,
    salesPrice INT,
    
    PRIMARY KEY (compId)
);
ALTER TABLE roof auto_increment=4000;

INSERT INTO roof (compDescription,compHeight,compWidth,currentStock,vendorPrice,salesPrice)
VALUES  ("PLASTMO", 200, 120, 71, 75, 130),
		("Betontagsten, sort", 15, 35, 224, 25, 45);
	
CREATE TABLE itemTypes (
	itemType VARCHAR(20) NOT NULL,
    
    PRIMARY KEY (itemType)
);

INSERT INTO itemTypes
VALUES  ("Styk"),
		("Pakke"),
		("Sæt");
    
CREATE TABLE parts (
	partsId INT AUTO_INCREMENT,
    partDescription VARCHAR(50) NOT NULL,
    itemType VARCHAR(20) NOT NULL,
    currentStock INT DEFAULT 0,
    vendorPrice INT,
    salesPrice INT,
    
    PRIMARY KEY (partsId),
    FOREIGN KEY (itemType) REFERENCES itemTypes (itemType)
);
ALTER TABLE parts auto_increment=6000;

INSERT INTO parts (partDescription,itemType,currentStock,vendorPrice,salesPrice)
VALUES  ("Skruer 4,5 x 120mm 200stk", "Pakke", 120, 15, 45),
		("Vinkelbeslag", "Styk", 325, 5, 9),
        ("Skruer 5,0 x 100mm 100stk", "Pakke", 67, 10, 25),
        ("Bræddebolt 10 x 120mm", "Styk", 128, 10, 19),
        ("Firkantskive 40 x 40 x 11mm", "Styk", 392, 3, 5);
        
        

CREATE TABLE validations (
	valueDescription VARCHAR(40) NOT NULL,
    validValue INT NOT NULL,
    
    PRIMARY KEY (valueDescription)
);

INSERT INTO validations (valueDescription,validValue)
VALUES  ("Carspace height", 185),
		("Carspace length", 300),
        ("Carspace width", 250);
        
use carport;