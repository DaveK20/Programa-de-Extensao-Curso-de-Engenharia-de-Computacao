-- MySQL Script generated by MySQL Workbench
-- Sat Jul 15 20:18:22 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- Schema patrimonio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema patrimonio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `patrimonio` DEFAULT CHARACTER SET utf8mb3 ;


-- -----------------------------------------------------
-- Table `patrimonio`.`tipo_patrimonio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`tipo_patrimonio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_tipo_patrimonio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Tipo_UNIQUE` (`nome_tipo_patrimonio` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`unidade_administrativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`unidade_administrativa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sigla` VARCHAR(6) NOT NULL,
  `nome` VARCHAR(52) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`classificacao_generica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`classificacao_generica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`patrimonio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`patrimonio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `observacoes` VARCHAR(45) NULL DEFAULT NULL,
  `numero_de_identificacao` INT NOT NULL,
  `pesquisa_museologica` VARCHAR(45) NULL,
  `tema` VARCHAR(45) NULL,
  `catalogacao` VARCHAR(6) NOT NULL,
  `tombo` INT NOT NULL,
  `movimento` VARCHAR(45) NULL,
  `inventario_museologico` VARCHAR(10) NOT NULL,
  `inventario_patrimonial` INT NOT NULL,
  `informacao_data` VARCHAR(100) NULL,
  `pais` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `cep` INT NULL,
  `local_guardado` VARCHAR(45) NOT NULL,
  `assinatura` VARCHAR(45) NULL DEFAULT 'Assinatura ileg�vel',
  `titulo` VARCHAR(45) NULL DEFAULT 'T�tulo ileg�vel',
  `tipo_patrimonio_id` INT NOT NULL,
  `unidade_administrativa_id` INT NOT NULL,
  `classificacao_generica_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patrimonio_tipo_patrimonio1_idx` (`tipo_patrimonio_id` ASC) VISIBLE,
  INDEX `fk_patrimonio_unidade_administrativa1_idx` (`unidade_administrativa_id` ASC) VISIBLE,
  INDEX `fk_patrimonio_classificacao_generica1_idx` (`classificacao_generica_id` ASC) VISIBLE,
  CONSTRAINT `fk_patrimonio_tipo_patrimonio1`
    FOREIGN KEY (`tipo_patrimonio_id`)
    REFERENCES `patrimonio`.`tipo_patrimonio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patrimonio_unidade_administrativa1`
    FOREIGN KEY (`unidade_administrativa_id`)
    REFERENCES `patrimonio`.`unidade_administrativa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patrimonio_classificacao_generica1`
    FOREIGN KEY (`classificacao_generica_id`)
    REFERENCES `patrimonio`.`classificacao_generica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `patrimonio`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`pais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(19) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `sigla` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(28) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`procedencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`procedencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL,
  `patrimonio_id` INT NOT NULL,
  `pais_id` INT NOT NULL,
  `estado_id` INT NOT NULL,
  `cidade_id` INT NOT NULL,
  INDEX `fk_procedencia_pais1_idx` (`pais_id` ASC) ,
  INDEX `fk_procedencia_estado1_idx` (`estado_id` ASC) ,
  INDEX `fk_procedencia_cidade1_idx` (`cidade_id` ASC) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_procedencia_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_procedencia_pais1`
    FOREIGN KEY (`pais_id`)
    REFERENCES `patrimonio`.`pais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_procedencia_estado1`
    FOREIGN KEY (`estado_id`)
    REFERENCES `patrimonio`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_procedencia_cidade1`
    FOREIGN KEY (`cidade_id`)
    REFERENCES `patrimonio`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `patrimonio` ;

-- -----------------------------------------------------
-- Table `patrimonio`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL DEFAULT 'desconhecido',
  `biografia` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`forma_aquisicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`forma_aquisicao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`aquisicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`aquisicao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `patrimonio_id` INT NOT NULL,
  `forma_aquisicao_id` INT NOT NULL,
  INDEX `fk_forma_aquisicao_has_patrimonio_forma_aquisicao1_idx` (`forma_aquisicao_id` ASC) ,
  PRIMARY KEY (`id`),
  INDEX `fk_aquisicao_patrimonio1_idx` (`patrimonio_id` ASC) ,
  CONSTRAINT `fk_forma_aquisicao_has_patrimonio_forma_aquisicao1`
    FOREIGN KEY (`forma_aquisicao_id`)
    REFERENCES `patrimonio`.`forma_aquisicao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aquisicao_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`tipo_imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`tipo_imagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `largura` INT NOT NULL,
  `altura` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`imagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `data` DATE NULL DEFAULT NULL,
  `arquivo` BLOB NOT NULL,
  `tipo_imagem_id` INT NOT NULL,
  `patrimonio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_imagem_tipo_imagem1_idx` (`tipo_imagem_id` ASC) ,
  INDEX `fk_imagem_patrimonio1_idx` (`patrimonio_id` ASC) ,
  CONSTRAINT `fk_imagem_tipo_imagem1`
    FOREIGN KEY (`tipo_imagem_id`)
    REFERENCES `patrimonio`.`tipo_imagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imagem_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`nome_alternativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`nome_alternativo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_alternativo` VARCHAR(45) NOT NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nome_alternativo_autor1_idx` (`autor_id` ASC) ,
  CONSTRAINT `fk_nome_alternativo_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `patrimonio`.`autor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`palavra_chave`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`palavra_chave` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `palavra_chave` VARCHAR(45) NOT NULL,
  `patrimonio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_palavra_chave_patrimonio1_idx` (`patrimonio_id` ASC) ,
  CONSTRAINT `fk_palavra_chave_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`patrimonio_has_autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`patrimonio_has_autor` (
  `patrimonio_id` INT NOT NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`patrimonio_id`, `autor_id`),
  INDEX `fk_patrimonio_has_autor_autor1_idx` (`autor_id` ASC) ,
  INDEX `fk_patrimonio_has_autor_patrimonio1_idx` (`patrimonio_id` ASC) ,
  CONSTRAINT `fk_patrimonio_has_autor_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `patrimonio`.`autor` (`id`),
  CONSTRAINT `fk_patrimonio_has_autor_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`patrimonio_has_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`patrimonio_has_material` (
  `patrimonio_id_patrimonio` INT NOT NULL,
  `material_id_material` INT NOT NULL,
  PRIMARY KEY (`patrimonio_id_patrimonio`, `material_id_material`),
  INDEX `fk_patrimonio_has_material_material1_idx` (`material_id_material` ASC) ,
  INDEX `fk_patrimonio_has_material_patrimonio1_idx` (`patrimonio_id_patrimonio` ASC) ,
  CONSTRAINT `fk_patrimonio_has_material_material1`
    FOREIGN KEY (`material_id_material`)
    REFERENCES `patrimonio`.`material` (`id`),
  CONSTRAINT `fk_patrimonio_has_material_patrimonio1`
    FOREIGN KEY (`patrimonio_id_patrimonio`)
    REFERENCES `patrimonio`.`patrimonio` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`tecnica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`tecnica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patrimonio`.`patrimonio_has_tecnica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patrimonio`.`patrimonio_has_tecnica` (
  `patrimonio_id` INT NOT NULL,
  `tecnica_id` INT NOT NULL,
  PRIMARY KEY (`patrimonio_id`, `tecnica_id`),
  INDEX `fk_patrimonio_has_tecnica_tecnica1_idx` (`tecnica_id` ASC) ,
  INDEX `fk_patrimonio_has_tecnica_patrimonio1_idx` (`patrimonio_id` ASC) ,
  CONSTRAINT `fk_patrimonio_has_tecnica_patrimonio1`
    FOREIGN KEY (`patrimonio_id`)
    REFERENCES `patrimonio`.`patrimonio` (`id`),
  CONSTRAINT `fk_patrimonio_has_tecnica_tecnica1`
    FOREIGN KEY (`tecnica_id`)
    REFERENCES `patrimonio`.`tecnica` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
