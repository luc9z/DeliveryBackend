CREATE TABLE DRIVER (
    ID BIGINT NOT NULL,
    DRIVER_NAME VARCHAR(255) NOT NULL,
    LICENSE_NUMBER VARCHAR(50) NOT NULL
);

ALTER TABLE DRIVER ADD PRIMARY KEY (ID);

ALTER TABLE DRIVER MODIFY ID BIGINT AUTO_INCREMENT;