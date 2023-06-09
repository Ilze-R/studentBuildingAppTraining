--Student functionality related data

--Student table
CREATE TABLE STUDENT (
                         ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARCHAR(30) NOT NULL,
                         SURNAME VARCHAR(30) NOT NULL,
                         PERSONAL_CODE BIGINT NOT NULL
);

--Student data
INSERT INTO STUDENT (NAME, SURNAME, PERSONAL_CODE) VALUES ( 'Pirmas', 'Test', 12345678);
INSERT INTO STUDENT (NAME, SURNAME, PERSONAL_CODE) VALUES ( 'Antras', 'Test', 234516376);
INSERT INTO STUDENT (NAME, SURNAME, PERSONAL_CODE) VALUES ( 'Trecias', 'Test', 643786478);

ALTER TABLE STUDENT ALTER COLUMN ID RESTART WITH 4;