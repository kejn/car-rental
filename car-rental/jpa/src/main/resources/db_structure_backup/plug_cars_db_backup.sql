--------------------------------------------------------
--  File created - wtorek-grudnia-08-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for DB Link PLUG_CARS_DB_WAWA
--------------------------------------------------------

  CREATE DATABASE LINK "PLUG_CARS_DB_WAWA"
   USING 'plug_cars_db_wawa';
--------------------------------------------------------
--  DDL for Sequence WHEELS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."WHEELS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence BODIES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."BODIES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence RENTERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."RENTERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence TRANSMISSIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."TRANSMISSIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence BOOKING_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."BOOKING_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence CARS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."CARS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence MANUFACTURERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."MANUFACTURERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence MODELS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."MODELS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence COLORS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."COLORS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence LOCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CAR_RENTAL"."LOCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Table WHEELS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."WHEELS" 
   (	"ID" NUMBER(19,2), 
	"TYPE" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table COLORS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."COLORS" 
   (	"ID" NUMBER(19,2), 
	"TYPE" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOKING
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."BOOKING" 
   (	"ID" NUMBER(19,2), 
	"PRICE" FLOAT(126), 
	"SINCE" DATE, 
	"UNTIL" DATE, 
	"CAR" NUMBER(19,2), 
	"RENTER" NUMBER(19,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CARS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."CARS" 
   (	"ID" NUMBER(19,2), 
	"POWER" NUMBER(5,0), 
	"WEIGHT" NUMBER(5,0), 
	"BODY" NUMBER(19,2), 
	"COLOR" NUMBER(19,2), 
	"WHEELS" NUMBER(19,2), 
	"LOCATION" NUMBER(19,2), 
	"MODEL" NUMBER(19,2), 
	"TRANSMISSION" NUMBER(19,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TRANSMISSIONS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."TRANSMISSIONS" 
   (	"ID" NUMBER(19,2), 
	"TYPE" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BODIES
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."BODIES" 
   (	"ID" NUMBER(19,2), 
	"TYPE" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RENTERS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."RENTERS" 
   (	"ID" NUMBER(19,2), 
	"EMAIL" VARCHAR2(320 CHAR), 
	"NAME" VARCHAR2(40 CHAR), 
	"PHONE" VARCHAR2(9 CHAR), 
	"SURNAME" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MANUFACTURERS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."MANUFACTURERS" 
   (	"ID" NUMBER(19,2), 
	"NAME" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOCATIONS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."LOCATIONS" 
   (	"ID" NUMBER(19,2), 
	"CITY" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MODELS
--------------------------------------------------------

  CREATE TABLE "CAR_RENTAL"."MODELS" 
   (	"ID" NUMBER(19,2), 
	"NAME" VARCHAR2(40 CHAR), 
	"YEAR" NUMBER(5,0), 
	"MANUFACTURER" NUMBER(19,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010970
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010970" ON "CAR_RENTAL"."WHEELS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010967
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010967" ON "CAR_RENTAL"."TRANSMISSIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010953
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010953" ON "CAR_RENTAL"."LOCATIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010956
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010956" ON "CAR_RENTAL"."MANUFACTURERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010937
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010937" ON "CAR_RENTAL"."BOOKING" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010930
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010930" ON "CAR_RENTAL"."BODIES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010961
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010961" ON "CAR_RENTAL"."MODELS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010947
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010947" ON "CAR_RENTAL"."CARS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010950
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010950" ON "CAR_RENTAL"."COLORS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010964
--------------------------------------------------------

  CREATE UNIQUE INDEX "CAR_RENTAL"."SYS_C0010964" ON "CAR_RENTAL"."RENTERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table WHEELS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."WHEELS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."WHEELS" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."WHEELS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table COLORS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."COLORS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."COLORS" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."COLORS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOOKING
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("SINCE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("UNTIL" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("CAR" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" MODIFY ("RENTER" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BOOKING" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CARS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."CARS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("POWER" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("WEIGHT" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("BODY" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("COLOR" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("WHEELS" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("LOCATION" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("MODEL" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."CARS" MODIFY ("TRANSMISSION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRANSMISSIONS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."TRANSMISSIONS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."TRANSMISSIONS" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."TRANSMISSIONS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BODIES
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."BODIES" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BODIES" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."BODIES" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RENTERS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."RENTERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."RENTERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."RENTERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MANUFACTURERS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."MANUFACTURERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MANUFACTURERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MANUFACTURERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOCATIONS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."LOCATIONS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."LOCATIONS" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."LOCATIONS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MODELS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."MODELS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MODELS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MODELS" MODIFY ("YEAR" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MODELS" MODIFY ("MANUFACTURER" NOT NULL ENABLE);
  ALTER TABLE "CAR_RENTAL"."MODELS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOOKING
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."BOOKING" ADD CONSTRAINT "FK_2JPUN0VG1DBSCIPCS8SCNATL0" FOREIGN KEY ("RENTER")
	  REFERENCES "CAR_RENTAL"."RENTERS" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."BOOKING" ADD CONSTRAINT "FK_S8AS9WA1FT553YMSHW3SA1XK7" FOREIGN KEY ("CAR")
	  REFERENCES "CAR_RENTAL"."CARS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CARS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_474XRTQNPA6LWC38EBNHG7WWU" FOREIGN KEY ("MODEL")
	  REFERENCES "CAR_RENTAL"."MODELS" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_66WQ4UGQR21S57AIF1TI2HNML" FOREIGN KEY ("LOCATION")
	  REFERENCES "CAR_RENTAL"."LOCATIONS" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_77HIFYNYNO646H41P08W8A4IN" FOREIGN KEY ("COLOR")
	  REFERENCES "CAR_RENTAL"."COLORS" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_BB01NMCB5WF760BO614WVP6N9" FOREIGN KEY ("WHEELS")
	  REFERENCES "CAR_RENTAL"."WHEELS" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_LCJJP26OJS4CSWP3D1XO9C9L4" FOREIGN KEY ("BODY")
	  REFERENCES "CAR_RENTAL"."BODIES" ("ID") ENABLE;
  ALTER TABLE "CAR_RENTAL"."CARS" ADD CONSTRAINT "FK_Q05YGOVJXEEXT1CWX8V6D40AQ" FOREIGN KEY ("TRANSMISSION")
	  REFERENCES "CAR_RENTAL"."TRANSMISSIONS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MODELS
--------------------------------------------------------

  ALTER TABLE "CAR_RENTAL"."MODELS" ADD CONSTRAINT "FK_OGJ08QNH3STXKAYGJ5XV64SFK" FOREIGN KEY ("MANUFACTURER")
	  REFERENCES "CAR_RENTAL"."MANUFACTURERS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger WHEELS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."WHEELS_TRG" 		BEFORE INSERT ON WHEELS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT WHEELS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."WHEELS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BOOKING_SORT_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."BOOKING_SORT_TRG" AFTER INSERT ON BOOKING FOR EACH ROW DECLARE v_location varchar2(40); v_loc_id number(19,2); BEGIN SELECT LOCATION INTO v_loc_id FROM CARS c WHERE c.ID = :NEW.CAR; SELECT CITY INTO v_location FROM LOCATIONS l WHERE l.ID = v_loc_id; IF (v_location = 'Warszawa') THEN INSERT INTO BOOKING_WAWA ("ID", PRICE, SINCE, "UNTIL", CAR, RENTER) VALUES (:NEW."ID", :NEW.PRICE, :NEW.SINCE, :NEW."UNTIL", :NEW.CAR, :NEW.RENTER); END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."BOOKING_SORT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger COLORS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."COLORS_TRG" 		BEFORE INSERT ON COLORS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT COLORS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."COLORS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BOOKING_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."BOOKING_TRG" 		BEFORE INSERT ON BOOKING 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT BOOKING_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."BOOKING_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MANUFACTURERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."MANUFACTURERS_TRG" BEFORE INSERT ON MANUFACTURERS	FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT MANUFACTURERS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."MANUFACTURERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MODELS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."MODELS_TRG" 		BEFORE INSERT ON MODELS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT MODELS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."MODELS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRANSMISSIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."TRANSMISSIONS_TRG" BEFORE INSERT ON TRANSMISSIONS	FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT TRANSMISSIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."TRANSMISSIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BODIES_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."BODIES_TRG" 		BEFORE INSERT ON BODIES 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT BODIES_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."BODIES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOCATIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."LOCATIONS_TRG" 	BEFORE INSERT ON LOCATIONS		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT LOCATIONS_SEQ.NEXTVAL 	INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."LOCATIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RENTERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."RENTERS_TRG" 		BEFORE INSERT ON RENTERS 		FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT RENTERS_SEQ.NEXTVAL 		INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."RENTERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CARS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "CAR_RENTAL"."CARS_TRG" 			BEFORE INSERT ON CARS 			FOR EACH ROW BEGIN IF (INSERTING AND :NEW.ID IS NULL) THEN SELECT CARS_SEQ.NEXTVAL 			INTO :NEW.ID FROM SYS.DUAL; END IF; END;
/
ALTER TRIGGER "CAR_RENTAL"."CARS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Synonymn RENTERS_WAWA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE SYNONYM "CAR_RENTAL"."RENTERS_WAWA" FOR "CAR_RENTAL"."RENTERS"@"PLUG_CARS_DB_WAWA";
--------------------------------------------------------
--  DDL for Synonymn BOOKING_WAWA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE SYNONYM "CAR_RENTAL"."BOOKING_WAWA" FOR "CAR_RENTAL"."BOOKING"@"PLUG_CARS_DB_WAWA";
