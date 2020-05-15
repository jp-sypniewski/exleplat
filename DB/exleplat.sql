-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema exleplat
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `exleplat` ;

-- -----------------------------------------------------
-- Schema exleplat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exleplat` DEFAULT CHARACTER SET utf8 ;
USE `exleplat` ;

-- -----------------------------------------------------
-- Table `profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `profile` ;

CREATE TABLE IF NOT EXISTS `profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `about` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `role` ENUM('owner', 'siteadmin', 'contentadmin', 'user') NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `active` TINYINT NOT NULL,
  `profile_id` INT NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_user_profile_idx` (`profile_id` ASC),
  CONSTRAINT `fk_user_profile`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `topic` ;

CREATE TABLE IF NOT EXISTS `topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `author_username` VARCHAR(32) NOT NULL,
  `content` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_topic_user1_idx` (`author_username` ASC),
  CONSTRAINT `fk_topic_user1`
    FOREIGN KEY (`author_username`)
    REFERENCES `user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS jpauser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jpauser' IDENTIFIED BY 'whatsaneal';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jpauser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `exleplat`;
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about`) VALUES (1, 'jp', 'sypniewski', 'jp.sypniewski@gmail.com', 'first');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `exleplat`;
INSERT INTO `user` (`username`, `password`, `role`, `created_at`, `updated_at`, `active`, `profile_id`) VALUES ('orangeisntblue', 'password', 'owner', '2020-05-15', '2020-05-15', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `topic`
-- -----------------------------------------------------
START TRANSACTION;
USE `exleplat`;
INSERT INTO `topic` (`id`, `title`, `author_username`, `content`) VALUES (1, 'test', 'orangeisntblue', 'some random stuff');

COMMIT;

