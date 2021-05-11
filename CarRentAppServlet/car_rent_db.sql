-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema car_rent_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema car_rent_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `car_rent_db` DEFAULT CHARACTER SET utf8 ;
USE `car_rent_db` ;

-- -----------------------------------------------------
-- Table `car_rent_db`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`event` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `active` BIT(1) NULL DEFAULT NULL COMMENT '',
  `date` DATE NULL DEFAULT NULL COMMENT '',
  `description` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `language` INT(11) NULL DEFAULT NULL COMMENT '',
  `name` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `picture` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `place` INT(11) NULL DEFAULT NULL COMMENT '',
  `price` DOUBLE NULL DEFAULT NULL COMMENT '',
  `time` TIME NULL DEFAULT NULL COMMENT '',
  `local_date_time` DATETIME NULL DEFAULT NULL COMMENT '',
  `status` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`users` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `email` VARCHAR(255) NOT NULL COMMENT '',
  `first_name` VARCHAR(50) NOT NULL COMMENT '',
  `last_name` VARCHAR(100) NOT NULL COMMENT '',
  `password` VARCHAR(255) NOT NULL COMMENT '',
  `status` VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' COMMENT '',
  `roles` VARCHAR(20) NULL DEFAULT 'USER' COMMENT '',
  `activation_code` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `resume` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`lecture` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `file` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `name` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `theme` INT(11) NULL DEFAULT NULL COMMENT '',
  `description` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `short_description` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `status_lecture` INT(11) NULL DEFAULT NULL COMMENT '',
  `language` INT(11) NULL DEFAULT NULL COMMENT '',
  `user_id` BIGINT(20) NOT NULL COMMENT '',
  `duration` BIGINT(20) NULL DEFAULT NULL COMMENT '',
  `event_lecture_id` BIGINT(20) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FKsinkc0esmf4gh5cvl7yn69wm5` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `FKsinkc0esmf4gh5cvl7yn69wm5`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_conference_hall`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`event_lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`event_lecture` (
  `event_id` BIGINT(20) NOT NULL COMMENT '',
  `lecture_id` BIGINT(20) NOT NULL COMMENT '',
  `id` BIGINT(20) NOT NULL COMMENT '',
  `order_number` INT(11) NULL DEFAULT NULL COMMENT '',
  `theme` INT(11) NULL DEFAULT NULL COMMENT '',
  INDEX `FK18rauhtpmpf2dy7rcsni01su0` (`lecture_id` ASC)  COMMENT '',
  INDEX `FK18ao4i7gqsbgtmfs0s3mtw9an` (`event_id` ASC)  COMMENT '',
  CONSTRAINT `FK18ao4i7gqsbgtmfs0s3mtw9an`
    FOREIGN KEY (`event_id`)
    REFERENCES `db_conference_hall`.`event` (`id`),
  CONSTRAINT `FK18rauhtpmpf2dy7rcsni01su0`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `db_conference_hall`.`lecture` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`event_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`event_theme` (
  `event_id` BIGINT(20) NOT NULL COMMENT '',
  `themes` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  INDEX `FKm2vqpfpw8d8vevcpt8gogjdi4` (`event_id` ASC)  COMMENT '',
  CONSTRAINT `FKm2vqpfpw8d8vevcpt8gogjdi4`
    FOREIGN KEY (`event_id`)
    REFERENCES `db_conference_hall`.`event` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`lecture_lectors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`lecture_lectors` (
  `lecture_id` BIGINT(20) NOT NULL COMMENT '',
  `lectors_id` BIGINT(20) NOT NULL COMMENT '',
  INDEX `FKrywho7vm03odo4n785y78rceq` (`lectors_id` ASC)  COMMENT '',
  INDEX `FKhe742kuw8mxdtwftb3d18lx7e` (`lecture_id` ASC)  COMMENT '',
  CONSTRAINT `FKhe742kuw8mxdtwftb3d18lx7e`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `db_conference_hall`.`lecture` (`id`),
  CONSTRAINT `FKrywho7vm03odo4n785y78rceq`
    FOREIGN KEY (`lectors_id`)
    REFERENCES `db_conference_hall`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`lecture_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`lecture_theme` (
  `lecture_id` BIGINT(20) NOT NULL COMMENT '',
  `themes` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  INDEX `FKt64xik7qt59w0efxraanji9cg` (`lecture_id` ASC)  COMMENT '',
  CONSTRAINT `FKt64xik7qt59w0efxraanji9cg`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `db_conference_hall`.`lecture` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`ticket` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `price` DOUBLE NULL DEFAULT NULL COMMENT '',
  `event_id` BIGINT(20) NOT NULL COMMENT '',
  `user_id` BIGINT(20) NOT NULL COMMENT '',
  `status` INT(11) NULL DEFAULT NULL COMMENT '',
  `status_ticket` INT(11) NULL DEFAULT NULL COMMENT '',
  `code` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `discount` INT(11) NULL DEFAULT NULL COMMENT '',
  `qrcode` TINYBLOB NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FKfytuhjopeamxbt1cpudy92x5n` (`event_id` ASC)  COMMENT '',
  INDEX `FKmvugyjf7b45u0juyue7k3pct0` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `FKfytuhjopeamxbt1cpudy92x5n`
    FOREIGN KEY (`event_id`)
    REFERENCES `db_conference_hall`.`event` (`id`),
  CONSTRAINT `FKmvugyjf7b45u0juyue7k3pct0`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_conference_hall`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`user_lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`user_lecture` (
  `user_id` BIGINT(20) NOT NULL COMMENT '',
  `lecture_id` BIGINT(20) NOT NULL COMMENT '',
  INDEX `FKffd6b4u31730vwxl8i0btltsk` (`lecture_id` ASC)  COMMENT '',
  INDEX `FK8jmutxfqq0f1qx29tokcio1oq` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `FK8jmutxfqq0f1qx29tokcio1oq`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_conference_hall`.`users` (`id`),
  CONSTRAINT `FKffd6b4u31730vwxl8i0btltsk`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `db_conference_hall`.`lecture` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `car_rent_db`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_rent_db`.`user_role` (
  `user_id` BIGINT(20) NOT NULL COMMENT '',
  `roles` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  INDEX `FKj345gk1bovqvfame88rcx7yyx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_conference_hall`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
