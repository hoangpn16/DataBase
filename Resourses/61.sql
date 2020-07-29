-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MATHANG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MATHANG` (
  `MAHANG` VARCHAR(20) NOT NULL,
  `TENHANG` VARCHAR(40) NOT NULL,
  `ĐVT` VARCHAR(45) NOT NULL,
  `SLHC` INT NOT NULL,
  `GBHT` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`MAHANG`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PHIEUNHAP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PHIEUNHAP` (
  `SOPHIEU` VARCHAR(20) NOT NULL,
  `NGAYNHAP` VARCHAR(45) NOT NULL,
  `TENNCC` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SOPHIEU`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`HĐXUAT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`HĐXUAT` (
  `SOHĐ` INT NOT NULL,
  `NGAYBAN` VARCHAR(45) NOT NULL,
  `TENNMH` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SOHĐ`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NHAPHANG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NHAPHANG` (
  `SO_LUONG` INT NULL,
  `GIA` VARCHAR(45) NULL,
  `MA_HANG` VARCHAR(20) NOT NULL,
  `SOPHIEU` VARCHAR(20) NOT NULL,
  INDEX `fk_NHAPHANG_MATHANG1_idx` (`MA_HANG` ASC) VISIBLE,
  PRIMARY KEY (`MA_HANG`, `SOPHIEU`),
  INDEX `fk_NHAPHANG_PHIEUNHAP1_idx` (`SOPHIEU` ASC) VISIBLE,
  CONSTRAINT `fk_NHAPHANG_MATHANG1`
    FOREIGN KEY (`MA_HANG`)
    REFERENCES `mydb`.`MATHANG` (`MAHANG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NHAPHANG_PHIEUNHAP1`
    FOREIGN KEY (`SOPHIEU`)
    REFERENCES `mydb`.`PHIEUNHAP` (`SOPHIEU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`XUATHANG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`XUATHANG` (
  `SO_LUONG` INT NULL,
  `GIA_XUAT` VARCHAR(15) NULL,
  `MA_HANG` VARCHAR(20) NOT NULL,
  `SOHĐ` INT NOT NULL,
  INDEX `fk_XUATHANG_MATHANG1_idx` (`MA_HANG` ASC) VISIBLE,
  PRIMARY KEY (`MA_HANG`, `SOHĐ`),
  INDEX `fk_XUATHANG_HĐXUAT2_idx` (`SOHĐ` ASC) VISIBLE,
  CONSTRAINT `fk_XUATHANG_MATHANG1`
    FOREIGN KEY (`MA_HANG`)
    REFERENCES `mydb`.`MATHANG` (`MAHANG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_XUATHANG_HĐXUAT2`
    FOREIGN KEY (`SOHĐ`)
    REFERENCES `mydb`.`HĐXUAT` (`SOHĐ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;