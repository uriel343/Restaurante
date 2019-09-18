-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbrestaurante2018053
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbrestaurante2018053
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbrestaurante2018053` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dbrestaurante2018053` ;

-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`areas` (
  `idarea` INT(11) NOT NULL AUTO_INCREMENT,
  `nombrearea` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idarea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`clientes` (
  `idcliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `metodopago` VARCHAR(30) NOT NULL,
  `nit` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`cocineros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`cocineros` (
  `idcocinero` INT(11) NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(30) NOT NULL,
  `apellidos` VARCHAR(30) NOT NULL,
  `edad` INT(11) NOT NULL,
  PRIMARY KEY (`idcocinero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`meseros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`meseros` (
  `idmesero` INT(11) NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(30) NOT NULL,
  `apellidos` VARCHAR(30) NOT NULL,
  `edad` INT(11) NOT NULL,
  PRIMARY KEY (`idmesero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`mesas` (
  `idmesa` INT(11) NOT NULL AUTO_INCREMENT,
  `capacidad` VARCHAR(30) NOT NULL,
  `idarea` INT(11) NOT NULL,
  PRIMARY KEY (`idmesa`),
  INDEX `idarea` (`idarea` ASC) VISIBLE,
  CONSTRAINT `mesas_ibfk_1`
    FOREIGN KEY (`idarea`)
    REFERENCES `dbrestaurante2018053`.`areas` (`idarea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`orden` (
  `idorden` INT NOT NULL,
  `idmesero` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `idmesa` INT NOT NULL,
  PRIMARY KEY (`idorden`),
  INDEX `idmesero` (`idmesero` ASC) VISIBLE,
  INDEX `idcliente` (`idcliente` ASC) VISIBLE,
  INDEX `orden_ibfk_4_idx` (`idmesa` ASC) VISIBLE,
  CONSTRAINT `orden_ibfk_1`
    FOREIGN KEY (`idmesero`)
    REFERENCES `dbrestaurante2018053`.`meseros` (`idmesero`),
  CONSTRAINT `orden_ibfk_2`
    FOREIGN KEY (`idcliente`)
    REFERENCES `dbrestaurante2018053`.`clientes` (`idcliente`),
  CONSTRAINT `orden_ibfk_4`
    FOREIGN KEY (`idmesa`)
    REFERENCES `dbrestaurante2018053`.`mesas` (`idmesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`platos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`platos` (
  `idplato` INT NOT NULL,
  `nombreplato` VARCHAR(45) NOT NULL,
  `precioplato` DOUBLE NOT NULL,
  PRIMARY KEY (`idplato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbrestaurante2018053`.`detalleorden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbrestaurante2018053`.`detalleorden` (
  `idorden` INT(11) NOT NULL,
  `iddetalleorden` INT(11) NOT NULL,
  `precioplato` DOUBLE NOT NULL,
  `cantidadplato` INT(11) NOT NULL,
  `preciototal` DOUBLE NOT NULL DEFAULT ('precioplato' * 'cantidad'),
  `fechaorden` DATETIME NOT NULL,
  `idcocinero` INT NOT NULL,
  `idplato` INT NOT NULL,
  PRIMARY KEY (`iddetalleorden`, `idorden`),
  INDEX `idorden` (`idorden` ASC) VISIBLE,
  INDEX `detalleorden_ibfk_2_idx` (`idcocinero` ASC) VISIBLE,
  INDEX `detalleorden_ibfk_3_idx` (`idplato` ASC) VISIBLE,
  CONSTRAINT `detalleorden_ibfk_1`
    FOREIGN KEY (`idorden`)
    REFERENCES `dbrestaurante2018053`.`orden` (`idorden`),
  CONSTRAINT `detalleorden_ibfk_2`
    FOREIGN KEY (`idcocinero`)
    REFERENCES `dbrestaurante2018053`.`cocineros` (`idcocinero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `detalleorden_ibfk_3`
    FOREIGN KEY (`idplato`)
    REFERENCES `dbrestaurante2018053`.`platos` (`idplato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

