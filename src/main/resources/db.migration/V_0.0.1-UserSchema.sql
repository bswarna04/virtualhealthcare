CREATE SCHEMA `mmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

CREATE TABLE `mmsdb`.`patients` (
                                    `pid` INT NOT NULL AUTO_INCREMENT,
                                    `firstname` VARCHAR(50) NULL,
                                    `lastname` VARCHAR(50) NULL,
                                    `gender` VARCHAR(45) NULL,
                                    `dateofbirth` DATE NULL,
                                    `email` VARCHAR(100) NULL,
                                    `password` VARCHAR(50) NULL,
                                    PRIMARY KEY (`pid`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE `mmsdb`.`doctors` (
                                   `did` INT NOT NULL AUTO_INCREMENT,
                                   `firstname` VARCHAR(50) NULL,
                                   `lastname` VARCHAR(50) NULL,
                                   `email` VARCHAR(50) NULL,
                                   `phone` VARCHAR(45) NULL,
                                   `specialization` VARCHAR(50) NULL,
                                   PRIMARY KEY (`did`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE `mmsdb`.`medical_records` (
                                           `rid` INT NOT NULL AUTO_INCREMENT,
                                           `recordtype` VARCHAR(50) NULL,
                                           `filename` VARCHAR(50) NULL,
                                           `dateuploaded` DATETIME NULL,
                                           `pid` INT NULL,
                                           PRIMARY KEY (`rid`),
                                           INDEX `pid_FK_idx` (`pid` ASC) VISIBLE,
                                           CONSTRAINT `pid_FK`
                                               FOREIGN KEY (`pid`)
                                                   REFERENCES `mmsdb`.`patients` (`pid`)
                                                   ON DELETE NO ACTION
                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE `mmsdb`.`appointments` (
                                        `aid` INT NOT NULL AUTO_INCREMENT,
                                        `apptdate` DATE NULL,
                                        `appttime` VARCHAR(50) NULL,
                                        `status` VARCHAR(45) NULL,
                                        `pid` INT NOT NULL,
                                        `did` INT NOT NULL,
                                        PRIMARY KEY (`aid`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

ALTER TABLE `mmsdb`.`appointments`
    ADD INDEX `did_FK_idx` (`did` ASC) VISIBLE;
;
ALTER TABLE `mmsdb`.`appointments`
    ADD CONSTRAINT `did_FK`
        FOREIGN KEY (`did`)
            REFERENCES `mmsdb`.`doctors` (`did`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `mmsdb`.`appointments`
    ADD INDEX `patid_FK_idx` (`pid` ASC) VISIBLE;
;
ALTER TABLE `mmsdb`.`appointments`
    ADD CONSTRAINT `patid_FK`
        FOREIGN KEY (`pid`)
            REFERENCES `mmsdb`.`patients` (`pid`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
