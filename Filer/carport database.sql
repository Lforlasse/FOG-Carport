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
VALUES  ("Stolpe", "Trykimprægneret", 100, 100, 74, 250, 475),
		("Stolpe", "Egetræ", 90, 90, 56, 400, 750),

		("Rem", "Trykimprægneret", 45, 195, 45, 135, 205),
		("Rem", "Egetræ", 40, 185, 42, 145, 215),
        
		("Spær", "Trykimprægneret", 45, 195, 80, 45, 85),
		("Spær", "Egetræ", 40, 185, 73, 50, 95),

		("Lægte", "Trykimprægneret", 38, 73, 37, 50, 95),
		("Lægte", "Egetræ", 35, 70, 7, 60, 105),
        
        ("Stern, over", "Trykimprægneret", 25, 125, 37, 50, 95),
        ("Stern, mellem", "Trykimprægneret", 25, 125, 37, 50, 95),
        ("Stern, under", "Trykimprægneret", 25, 125, 37, 50, 95),
		("Stern, over", "Egetræ", 20, 115, 41, 60, 110),
        ("Stern, mellem", "Egetræ", 20, 115, 41, 60, 110),
        ("Stern, under", "Egetræ", 20, 115, 41, 60, 110);

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
		("Betontagsten, sort", 35, 15, 224, 25, 45);
	
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
VALUES  ("Skruer 4,5 x 120mm 200stk", "Pakke", 120, 15, 45),
		("Vinkelbeslag", "Styk", 325, 5, 9),
        ("Skruer 5,0 x 100mm 100stk", "Pakke", 67, 10, 25),
        ("Bræddebolt 10 x 120mm", "Styk", 128, 10, 19),
        ("Firkantskive 40 x 40 x 11mm", "Styk", 392, 3, 5),
        ("Hulbånd 1x20mm x 10m", "Rulle", 48, 90, 200),
        ("Skruer 4,0 x 50mm 250stk", "Pakke" ,75, 70, 150),
        ("Universalbeslag 190mm højre", "Styk", 83, 15, 35),
        ("Universalbeslag 190mm venstre", "Styk", 85, 15, 35),
        ("Skruer 4,5 x 60mm 200stk", "Pakke", 102, 15, 40),
        ("PLASTMO bundskruer 200stk", "Pakke", 30, 20, 45);

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
    
    PRIMARY KEY (confStatus)
);

INSERT INTO configurationStatus (confStatus)
VALUES  ("Ny"),
		("Behandles"),
		("Afsluttet");

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
    roofmaterial VARCHAR (30),
    
    PRIMARY KEY (confId),
    FOREIGN KEY (confStatus) REFERENCES configurationStatus (confStatus)
    
    );
ALTER TABLE configurations auto_increment=224466;
    
INSERT INTO configurations (confStatus,custName,custPhone,custEmail,custPostal,length,width,height,material,roofMaterial)
VALUES  ("Afsluttet", "Abbott", 44884488, "abbott@bot.com", 5020, 300, 620, 225, "Egetræ", "PLASTMO"),
		("Behandles", "Costello", 22662266, "costello@ost.com", 2550, 300, 450, 225, "Trykimprægneret", "Betontagsten, sort");





use carport;