-- [SPACE] + additional [;] at the end of line means end of command for hibernate 

create or replace TRIGGER BODIES_TRG 		BEFORE INSERT ON BODIES 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT BODIES_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER BOOKING_TRG 		BEFORE INSERT ON BOOKING 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT BOOKING_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER CARS_TRG 			BEFORE INSERT ON CARS 			FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT CARS_SEQ.NEXTVAL 			INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER COLORS_TRG 		BEFORE INSERT ON COLORS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT COLORS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER LOCATIONS_TRG 	BEFORE INSERT ON LOCATIONS		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT LOCATIONS_SEQ.NEXTVAL 	INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER MANUFACTURERS_TRG BEFORE INSERT ON MANUFACTURERS	FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT MANUFACTURERS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER MODELS_TRG 		BEFORE INSERT ON MODELS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT MODELS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER RENTERS_TRG 		BEFORE INSERT ON RENTERS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT RENTERS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER TRANSMISSIONS_TRG BEFORE INSERT ON TRANSMISSIONS	FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT TRANSMISSIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;
create or replace TRIGGER WHEELS_TRG 		BEFORE INSERT ON WHEELS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT WHEELS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END; ;

create or replace TRIGGER BOOKING_SORT_TRG AFTER INSERT ON BOOKING FOR EACH ROW DECLARE v_found number(19,2); BEGIN SELECT COUNT(*) INTO v_found FROM CARS_WAWA WHERE ID = :NEW.CAR; IF(v_found > 0) THEN INSERT INTO BOOKING_WAWA ("ID", PRICE, SINCE, "UNTIL", CAR, RENTER) VALUES (:NEW."ID", :NEW.PRICE, :NEW.SINCE, :NEW."UNTIL", :NEW.CAR, :NEW.RENTER); END IF; END;
create or replace TRIGGER CARS_SORT_TRG AFTER INSERT ON CARS FOR EACH ROW DECLARE v_location varchar2(40); BEGIN SELECT CITY INTO v_location FROM LOCATIONS l WHERE l."ID" = :NEW."LOCATION"; IF (v_location = 'Warszawa') THEN INSERT INTO CARS_WAWA ("ID", "POWER", WEIGHT, "BODY", COLOR, WHEELS, "LOCATION", "MODEL", TRANSMISSION) VALUES (:NEW."ID", :NEW."POWER", :NEW.WEIGHT, :NEW."BODY", :NEW.COLOR, :NEW.WHEELS, :NEW."LOCATION", :NEW."MODEL", :NEW.TRANSMISSION); END IF; END; ;

-- VIEWS ----------------------------------------------------------

CREATE OR REPLACE VIEW ALLCARS ("ID", "POWER", "WEIGHT", "BODY", "COLOR", "WHEELS", "LOCATION", "MODEL", "TRANSMISSION") AS SELECT "ID","POWER","WEIGHT","BODY","COLOR","WHEELS","LOCATION","MODEL","TRANSMISSION" FROM ( SELECT * FROM CARS UNION ALL SELECT * FROM CARS_WAWA ) allcars ORDER BY ID;

-- CONSTANTS ------------------------------------------------------

insert into BODIES (ID, TYPE) values (null, 'SEDAN');
insert into BODIES (ID, TYPE) values (null, 'HATCHBACK');
insert into BODIES (ID, TYPE) values (null, 'MPV');
insert into BODIES (ID, TYPE) values (null, 'SUV');
insert into BODIES (ID, TYPE) values (null, 'COUPE');
insert into BODIES (ID, TYPE) values (null, 'COMBI');

insert into COLORS (ID, TYPE) values (null, 'BLACK');
insert into COLORS (ID, TYPE) values (null, 'WHITE');
insert into COLORS (ID, TYPE) values (null, 'RED');
insert into COLORS (ID, TYPE) values (null, 'GREEN');
insert into COLORS (ID, TYPE) values (null, 'BLUE');
insert into COLORS (ID, TYPE) values (null, 'YELLOW');
insert into COLORS (ID, TYPE) values (null, 'BROWN');
insert into COLORS (ID, TYPE) values (null, 'PURPLE');

insert into WHEELS (ID, TYPE) values (null, 'FRONT');
insert into WHEELS (ID, TYPE) values (null, 'REAR');
insert into WHEELS (ID, TYPE) values (null, '_4x4');

insert into TRANSMISSIONS (ID, TYPE) values (null, 'AUTO');
insert into TRANSMISSIONS (ID, TYPE) values (null, 'MANUAL');

insert into LOCATIONS (ID, CITY) values (null, 'Warszawa');
insert into LOCATIONS (ID, CITY) values (null, 'Wrocław');

insert into MANUFACTURERS (ID, NAME) values (null, 'Audi');
insert into MANUFACTURERS (ID, NAME) values (null, 'BMW');
insert into MANUFACTURERS (ID, NAME) values (null, 'Citroen');
insert into MANUFACTURERS (ID, NAME) values (null, 'Fiat');
insert into MANUFACTURERS (ID, NAME) values (null, 'Ford');
insert into MANUFACTURERS (ID, NAME) values (null, 'Honda');
insert into MANUFACTURERS (ID, NAME) values (null, 'Hyundai');
insert into MANUFACTURERS (ID, NAME) values (null, 'Mazda');
insert into MANUFACTURERS (ID, NAME) values (null, 'Mercedes-Benz');
insert into MANUFACTURERS (ID, NAME) values (null, 'Mitsubishi');
insert into MANUFACTURERS (ID, NAME) values (null, 'Nissan');
insert into MANUFACTURERS (ID, NAME) values (null, 'Opel');
insert into MANUFACTURERS (ID, NAME) values (null, 'Peugeot');
insert into MANUFACTURERS (ID, NAME) values (null, 'Renault');
insert into MANUFACTURERS (ID, NAME) values (null, 'Seat');
insert into MANUFACTURERS (ID, NAME) values (null, 'Skoda');
insert into MANUFACTURERS (ID, NAME) values (null, 'Toyota');
insert into MANUFACTURERS (ID, NAME) values (null, 'Volkswagen');
insert into MANUFACTURERS (ID, NAME) values (null, 'Volvo');

-- CAR MODELS -----------------------------------------------------------------------

----------
-- Audi --
----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'A3', 2000, 1);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'A4', 1998, 1);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'A5', 2007, 1);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Q3', 2012, 1);
---------
-- BMW --
---------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'i3',  2014, 2);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'E46', 2000, 2);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'E70', 2010, 2);
-------------
-- Citroen --
-------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'C3', 2004, 3);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'C5', 2004, 3);
----------
-- Fiat --
----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Panda', 2003, 4);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Doblo', 2002, 4);
----------
-- Ford --
----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'C-MAX', 2005, 5);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Fiesta', 2008, 5);
-----------
-- Honda --
-----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Civic', 2007, 6);
-------------
-- Hyundai --
-------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'i40', 2015, 7);
-----------
-- Mazda --
-----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, '6', 2006, 8);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'CX-5', 2006, 8);
--------------
-- Mercedes --
--------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'W212', 2010, 9);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'W209 (CLK-500)', 2007, 9);
----------------
-- Mitsubishi --
----------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Colt', 2009, 10);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Eclipse', 1999, 10);
------------
-- Nissan --
------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Juke', 2011, 11);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Micra', 1991, 11);
----------
-- Opel --
----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Astra', 2006, 12);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Omega', 2005, 12);
-------------
-- Renault --
-------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Clio', 2005, 14);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Kangoo', 2008, 14);
-----------
-- Skoda --
-----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Octavia', 2005, 16);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Rapid', 2012, 16);
------------
-- Toyota --
------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Yaris', 2004, 17);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'RAV4', 2005, 17);
----------------
-- Volkswagen --
----------------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Polo', 1999, 18);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'Passat', 2004, 18);
-----------
-- Volvo --
-----------
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'V40', 2012, 19);
insert into MODELS (ID, NAME, YEAR, MANUFACTURER) values (null, 'XC70', 2007, 19);

-- CARS FOR RENT -----------------------------------------------------------------------------------------------------------------------

-------------
-- Audi A3 --
------------- 
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 101, 1100, 2, 1, 1, 1, 1, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 150, 1210, 2, 4, 1, 1, 1, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 180, 1100, 2, 7, 1, 2, 1, 1);
-------------
-- Audi A4 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 125, 1200, 1, 3, 1, 2, 2, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 174, 1320, 1, 2, 1, 1, 2, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 193, 1540, 6, 5, 1, 2, 2, 2);
-------------
-- Audi A5 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 225, 1610, 5, 1, 1, 1, 3, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 225, 1610, 5, 1, 1, 2, 3, 2);
-------------
-- Audi Q3 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 170, 1650, 4, 2, 3, 1, 4, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 200, 1650, 4, 2, 3, 2, 4, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 200, 1650, 4, 1, 3, 2, 4, 1);
------------
-- BMW i3 --
------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 170, 1230, 2, 6, 2, 1, 5, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 170, 1230, 2, 8, 2, 2, 5, 1);
-------------
-- BMW E46 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 193, 1520, 1, 1, 2, 1, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 193, 1520, 1, 3, 2, 1, 6, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 193, 1520, 1, 5, 2, 2, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 143, 1360, 2, 2, 2, 1, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 143, 1360, 2, 1, 2, 2, 6, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 143, 1360, 2, 4, 2, 2, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 360, 1440, 5, 1, 2, 1, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 360, 1440, 5, 1, 2, 2, 6, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 200, 1790, 6, 1, 2, 1, 6, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 200, 1790, 6, 2, 2, 2, 6, 1);
-------------
-- BMW E70 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 355, 2125, 4, 1, 3, 1, 7, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 355, 2125, 4, 1, 3, 2, 7, 1);
----------------
-- Citroen C3 --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 5, 1, 1, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 4, 1, 1, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 7, 1, 1, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  90, 1150, 2, 1, 1, 1, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  90, 1150, 2, 2, 1, 1, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 5, 1, 2, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 4, 1, 2, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  60, 1100, 2, 6, 1, 2, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  90, 1150, 2, 2, 1, 2, 8, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  90, 1150, 2, 8, 1, 2, 8, 2);
----------------
-- Citroen C5 --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1310, 6, 2, 1, 1, 9, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1310, 6, 2, 1, 1, 9, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1310, 6, 2, 1, 2, 9, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1310, 6, 2, 1, 2, 9, 2);
----------------
-- Fiat Panda --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  54,  650, 2, 5, 1, 1, 10, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  54,  650, 2, 5, 1, 2, 10, 2);
----------------
-- Fiat Doblo --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 103, 1400, 3, 2, 1, 1, 11, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 103, 1400, 3, 2, 1, 2, 11, 2);
----------------
-- Ford C-MAX --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1527, 3, 4, 1, 2, 12, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1527, 3, 6, 1, 2, 12, 2);
-----------------
-- Ford Fiesta --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 100, 1100, 2, 1, 1, 1, 13, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 100, 1100, 2, 2, 1, 1, 13, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 182, 1300, 1, 1, 1, 2, 13, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 182, 1300, 1, 2, 1, 2, 13, 2);
-----------------
-- Honda Civic --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 197, 1350, 1, 1, 1, 1, 14, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 197, 1350, 1, 3, 1, 1, 14, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1200, 2, 1, 1, 2, 14, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1200, 2, 3, 1, 2, 14, 2);
-----------------
-- Hyundai i40 --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 135, 1428, 6, 5, 1, 2, 15, 2);
-------------
-- Mazda 6 --
-------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 175, 1345, 1, 3, 1, 1, 16, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 175, 1345, 1, 1, 1, 1, 16, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 175, 1345, 1, 3, 1, 2, 16, 1);
----------------
-- Mazda CX-5 --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 225, 1645, 4, 2, 1, 1, 17, 1);
-------------------
-- Mercedes W212 --
-------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 560, 1645, 5, 1, 2, 1, 18, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 560, 1645, 5, 1, 2, 2, 18, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 184, 1720, 1, 1, 2, 1, 18, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 292, 1810, 6, 1, 2, 2, 18, 1);
-----------------------------
-- Mercedes W209 (CLK-500) --
-----------------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 388, 1820, 5, 3, 2, 1, 19, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 388, 1820, 5, 2, 2, 2, 19, 1);
---------------------
-- Mitsubishi Colt --
---------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  95, 1100, 2, 5, 1, 1, 20, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  95, 1100, 2, 1, 1, 2, 20, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  95, 1100, 2, 5, 1, 2, 20, 2);
------------------------
-- Mitsubishi Eclipse --
------------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 205, 1410, 2, 6, 1, 2, 21, 2);
-----------------
-- Nissan Juke --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 190, 1456, 4, 7, 3, 1, 22, 1);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 190, 1456, 4, 7, 3, 2, 22, 1);
------------------
-- Nissan Micra --
------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  55,  775, 2, 3, 1, 2, 23, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  55,  775, 2, 5, 1, 2, 23, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  55,  775, 2, 8, 1, 2, 23, 2);
----------------
-- Opel Astra --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 115, 1210, 2, 2, 1, 1, 24, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1210, 1, 2, 1, 1, 24, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 125, 1210, 6, 2, 1, 1, 24, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 115, 1210, 2, 2, 1, 2, 24, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 140, 1210, 1, 2, 1, 2, 24, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 125, 1210, 6, 2, 1, 2, 24, 2);
----------------
-- Opel Omega --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 177, 1445, 6, 1, 2, 1, 25, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 177, 1445, 6, 1, 2, 2, 25, 2);
------------------
-- Renault Clio --
------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  68, 1080, 2, 7, 1, 2, 26, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  68, 1080, 2, 8, 1, 2, 26, 2);
--------------------
-- Renault Kangoo --
--------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 106, 1150, 3, 4, 1, 1, 27, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 106, 1150, 3, 4, 1, 2, 27, 2);
-------------------
-- Skoda Octavia --
-------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 115, 1140, 2, 2, 1, 1, 28, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 115, 1140, 2, 1, 1, 1, 28, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 143, 1200, 1, 1, 1, 2, 28, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 143, 1200, 1, 2, 1, 2, 28, 2);
-----------------
-- Skoda Rapid --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 150, 1230, 1, 1, 1, 1, 29, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 150, 1230, 1, 2, 1, 2, 29, 2);
------------------
-- Toyota Yaris --
------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  65,  850, 2, 7, 1, 1, 30, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  65,  850, 2, 7, 1, 2, 30, 2);
-----------------
-- Toyota RAV4 --
-----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 181, 1570, 4, 1, 3, 1, 31, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 181, 1570, 4, 2, 3, 2, 31, 2);
---------------------
-- Volkswagen Polo --
---------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null,  55,  850, 2, 3, 1, 2, 32, 2);
-----------------------
-- Volkswagen Passat --
-----------------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 105, 1150, 6, 5, 1, 1, 33, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 105, 1150, 6, 5, 1, 2, 33, 2);
---------------
-- Volvo V40 --
---------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 150, 1350, 2, 2, 1, 1, 34, 2);
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 150, 1350, 2, 1, 1, 2, 34, 2);
----------------
-- Volvo XC70 --
----------------
insert into CARS (ID, POWER, WEIGHT, BODY, COLOR, WHEELS, LOCATION, MODEL, TRANSMISSION) values (null, 180, 1415, 6, 2, 1, 1, 35, 2);
