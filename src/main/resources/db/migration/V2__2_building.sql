
CREATE TABLE BUILDING(
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARChAR(30) NOT NULL

);

INSERT INTO BUILDING (ID, NAME) VALUES (1, 'Test Building');
INSERT INTO BUILDING (ID, NAME) VALUES (2, 'Tow Hall');

CREATE TABLE CLASS_ROOM(
                           ID INT AUTO_INCREMENT PRIMARY KEY,
                           NAME VARCHAR(50) NOT NULL,
                           FLOOR INT NOT NULL,
                           CAPACITY INT NOT NULL,
                           BUILDING_ID INT,
                           FOREIGN KEY (BUILDING_ID) REFERENCES BUILDING
);

INSERT INTO CLASS_ROOM (ID, NAME, FLOOR, CAPACITY, BUILDING_ID) VALUES (1, 'RIVER SIDE', 1, 5, 1);