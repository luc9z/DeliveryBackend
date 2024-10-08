CREATE TABLE DELIVERY (
    ID BIGINT NOT NULL,
    CUSTOMER_NAME VARCHAR(255) NOT NULL,
    ADDRESS_DELIVERY VARCHAR(255) NOT NULL,
    CEP VARCHAR(8) NOT NULL,
    DELIVERY_DATE DATE NOT NULL,
    STATUS VARCHAR(50) NOT NULL,
    DRIVER_ID BIGINT
);

ALTER TABLE DELIVERY ADD PRIMARY KEY (ID);

ALTER TABLE DELIVERY MODIFY ID BIGINT AUTO_INCREMENT;

ALTER TABLE DELIVERY
    ADD CONSTRAINT FK_DRIVER_ID
    FOREIGN KEY (DRIVER_ID)
    REFERENCES DRIVER(ID);
