USE `hotel`;

CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8 ;
USE `hotel` ;

CREATE TABLE IF NOT EXISTS `hotel`.`user` (
                                              `id` BIGINT NOT NULL AUTO_INCREMENT,
                                              `login` VARCHAR(255) NOT NULL,
                                              `password` VARCHAR(255) NOT NULL,
                                              `role` INT NOT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 19
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hotel`.`admin` (
                                               `id` BIGINT NOT NULL,
                                               `firstname` VARCHAR(255) NOT NULL,
                                               `lastname` VARCHAR(255) NOT NULL,
                                               `middlename` VARCHAR(255) NULL DEFAULT NULL,
                                               `birth` DATE NOT NULL,
                                               PRIMARY KEY (`id`),
                                               CONSTRAINT `id`
                                                   FOREIGN KEY (`id`)
                                                       REFERENCES `hotel`.`user` (`id`)
                                                       ON DELETE CASCADE
                                                       ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hotel`.`client` (
                                                `id` BIGINT NOT NULL,
                                                `firstname` VARCHAR(255) NOT NULL,
                                                `lastname` VARCHAR(255) NOT NULL,
                                                `middlename` VARCHAR(255) NULL DEFAULT NULL,
                                                `birth` DATE NOT NULL,
                                                PRIMARY KEY (`id`),
                                                CONSTRAINT `idd`
                                                    FOREIGN KEY (`id`)
                                                        REFERENCES `hotel`.`user` (`id`)
                                                        ON DELETE CASCADE
                                                        ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hotel`.`application` (
                                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `class` VARCHAR(45) NOT NULL,
                                                     `capacity` INT NOT NULL,
                                                     `date_in` DATE NOT NULL,
                                                     `date_out` DATE NOT NULL,
                                                     `id_client` BIGINT NOT NULL,
                                                     `id_admin` BIGINT NULL DEFAULT NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `id_client` (`id_client` ASC) VISIBLE,
                                                     UNIQUE INDEX `id_admin_UNIQUE` (`id_admin` ASC) VISIBLE,
                                                     CONSTRAINT `admin_vs_application`
                                                         FOREIGN KEY (`id_admin`)
                                                             REFERENCES `hotel`.`admin` (`id`)
                                                             ON DELETE RESTRICT
                                                             ON UPDATE RESTRICT,
                                                     CONSTRAINT `FK_application_client_id`
                                                         FOREIGN KEY (`id_client`)
                                                             REFERENCES `hotel`.`client` (`id`)
                                                             ON DELETE RESTRICT
                                                             ON UPDATE RESTRICT)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hotel`.`room` (
                                              `id` BIGINT NOT NULL AUTO_INCREMENT,
                                              `place_count` INT NOT NULL,
                                              `class` VARCHAR(255) NOT NULL,
                                              `price` DECIMAL(19,2) NOT NULL,
                                              `free` TINYINT NOT NULL DEFAULT '1',
                                              PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hotel`.`bill` (
                                              `id` BIGINT NOT NULL,
                                              `date_in` DATE NOT NULL,
                                              `date_out` DATE NOT NULL,
                                              `payed` TINYINT NOT NULL DEFAULT '0',
                                              `id_room` BIGINT NOT NULL,
                                              `id_client` BIGINT NOT NULL,
                                              `admin_id` BIGINT NOT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE INDEX `admin_id_UNIQUE` (`admin_id` ASC) VISIBLE,
                                              UNIQUE INDEX `id_client_UNIQUE` (`id_client` ASC) VISIBLE,
                                              UNIQUE INDEX `id_room_UNIQUE` (`id_room` ASC) VISIBLE,
                                              INDEX `id_room_idx` (`id_room` ASC) VISIBLE,
                                              INDEX `id_client_idx` (`id_client` ASC) VISIBLE,
                                              INDEX `fk_bill_admin1_idx` (`admin_id` ASC) VISIBLE,
                                              CONSTRAINT `fk_bill_admin1`
                                                  FOREIGN KEY (`admin_id`)
                                                      REFERENCES `hotel`.`admin` (`id`),
                                              CONSTRAINT `id_client1`
                                                  FOREIGN KEY (`id_client`)
                                                      REFERENCES `hotel`.`client` (`id`)
                                                      ON DELETE RESTRICT
                                                      ON UPDATE RESTRICT,
                                              CONSTRAINT `id_room`
                                                  FOREIGN KEY (`id_room`)
                                                      REFERENCES `hotel`.`room` (`id`)
                                                      ON DELETE RESTRICT
                                                      ON UPDATE RESTRICT)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
