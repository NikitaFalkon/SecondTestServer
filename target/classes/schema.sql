CREATE TABLE IF NOT EXISTS bank (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    bic VARCHAR(20),
    account VARCHAR(20),
    treasuryaccount VARCHAR(20),
    PRIMARY KEY (id)

);
CREATE TABLE IF NOT EXISTS organization (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    inn VARCHAR(20),
    kpp VARCHAR(20),
    cname VARCHAR(25),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS document (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    sum NUMERIC(15, 2),
    date TIMESTAMP,
    GUID VARCHAR (36),
    number VARCHAR (20),
    type VARCHAR (2),
    BANKPAY_ID INTEGER,
    ORGPAY_ID INTEGER,
    BANKREC_ID INTEGER,
    ORGREC_ID INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (bankrec_id) REFERENCES bank(Id),
    FOREIGN KEY (bankpay_id) REFERENCES bank(Id),
    FOREIGN KEY (orgpay_id) REFERENCES organization(Id),
    FOREIGN KEY (orgrec_id) REFERENCES organization(Id)
);