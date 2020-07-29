-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema detainghiencuu
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema detainghiencuu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `detainghiencuu` DEFAULT CHARACTER SET utf8mb4 ;
USE `detainghiencuu` ;

-- -----------------------------------------------------
-- Table `detainghiencuu`.`GIAOVIEN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detainghiencuu`.`GIAOVIEN` (
  `MA_GV` VARCHAR(20) NOT NULL,
  `TEN_GV` VARCHAR(45) NULL,
  `HOC_HAM` VARCHAR(45) NULL,
  `HOC_VI` VARCHAR(45) NULL,
  PRIMARY KEY (`MA_GV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detainghiencuu`.`DETAI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detainghiencuu`.`DETAI` (
  `MA_DETAI` VARCHAR(20) NOT NULL,
  `TEN_DETAI` VARCHAR(45) NULL,
  `LINHVUCNC` VARCHAR(60) NULL,
  `MA_GV` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`MA_DETAI`),
  INDEX `fk_DETAI_GIAOVIEN_idx` (`MA_GV` ASC) VISIBLE,
  CONSTRAINT `fk_DETAI_GIAOVIEN`
    FOREIGN KEY (`MA_GV`)
    REFERENCES `detainghiencuu`.`GIAOVIEN` (`MA_GV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detainghiencuu`.`SINHVIEN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detainghiencuu`.`SINHVIEN` (
  `MA_SV` VARCHAR(20) NOT NULL,
  `HO_TEN` VARCHAR(45) NULL,
  `TEN_LOP` VARCHAR(45) NULL,
  PRIMARY KEY (`MA_SV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detainghiencuu`.`sv_detai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detainghiencuu`.`sv_detai` (
  `SINHVIEN_MA_SV` VARCHAR(20) NOT NULL,
  `DETAI_MA_DETAI` VARCHAR(20) NOT NULL,
  INDEX `fk_sv_detai_SINHVIEN1_idx` (`SINHVIEN_MA_SV` ASC) VISIBLE,
  INDEX `fk_sv_detai_DETAI1_idx` (`DETAI_MA_DETAI` ASC) VISIBLE,
  PRIMARY KEY (`SINHVIEN_MA_SV`),
  CONSTRAINT `fk_sv_detai_SINHVIEN1`
    FOREIGN KEY (`SINHVIEN_MA_SV`)
    REFERENCES `detainghiencuu`.`SINHVIEN` (`MA_SV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sv_detai_DETAI1`
    FOREIGN KEY (`DETAI_MA_DETAI`)
    REFERENCES `detainghiencuu`.`DETAI` (`MA_DETAI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
