
DROP SCHEMA IF EXISTS `sih` ;

-- -----------------------------------------------------
-- Schema sih
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sih` DEFAULT CHARACTER SET utf8 ;
USE `sih` ;

-- -----------------------------------------------------
-- Table `sih`.`Scheme_Applicant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sih`.`Scheme_Applicant` (
  `applicantID` INT NOT NULL AUTO_INCREMENT,
  `District` VARCHAR(45) NULL,
  `Block` VARCHAR(45) NULL,
   `schemeCode` VARCHAR(45) NULL,
  `panchayat` VARCHAR(45) NULL,
  `hospital` VARCHAR(45) NULL,
  `name` VARCHAR(45) NOT NULL,
  `husband` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `adhharNo` VARCHAR(45) NULL,
  
  `maritial` VARCHAR(45) NULL,
  `selected` VARCHAR(45) not null default "no",
  PRIMARY KEY (`applicantID`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sih`.`Scheme_Applicant_Doc` (
  `applicantID` INT NOT NULL,
  `adhharProof` LongBLOB NULL,
  `residentProof` LongBLOB NULL,
  
  PRIMARY KEY (`applicantID`),
  CONSTRAINT `applicantID1`
    FOREIGN KEY (`applicantID`)
    REFERENCES `sih`.`Scheme_Applicant` (`applicantID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sih`.`mapRoad` (
  `Id` INT NOT NULL,
  `adhharProof` LongBLOB NULL,
  `residentProof` LongBLOB NULL,
  
  PRIMARY KEY (`applicantID`),
  CONSTRAINT `applicantID1`
    FOREIGN KEY (`applicantID`)
    REFERENCES `sih`.`Scheme_Applicant` (`applicantID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
