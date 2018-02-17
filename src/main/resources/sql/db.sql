DROP DATABASE IF EXISTS SCHOOL_RESTAURANT_DB;

CREATE DATABASE SCHOOL_RESTAURANT_DB DEFAULT CHARACTER SET utf8;

USE SCHOOL_RESTAURANT_DB;

DROP TABLE IF EXISTS tbl_identity;
DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_dish;
DROP TABLE IF EXISTS tbl_order;
DROP TABLE IF EXISTS tbl_student_order;
DROP TABLE IF EXISTS tbl_canteen_order;

-- TABLE IDENTITY --
CREATE TABLE tbl_identity(
  tiId INT AUTO_INCREMENT,
  tiName VARCHAR(20) NOT NULL,
  tiDetail VARCHAR(50),
  PRIMARY KEY(tiId)
) AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- TABLE USER --
CREATE TABLE tbl_user(
  tuId INT AUTO_INCREMENT,
  tuName VARCHAR(50) NOT NULL UNIQUE COMMENT '唯一键：用户名',
  tuPwd VARCHAR(32) NOT NULL,
  tuAddress VARCHAR(100) NOT NULL,
  tuDate DATE NOT NULL,
  tiId INT NOT NULL,
  tuDetail VARCHAR(100),
  deleteFlg TINYINT(1) DEFAULT '0' COMMENT '0：未删除 1：已删除',
  PRIMARY KEY(tuId),
  FOREIGN KEY(tiId) REFERENCES tbl_identity(tiId)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- TABLE DISH --
CREATE TABLE tbl_dish(
  tdId INT AUTO_INCREMENT,
  tdName VARCHAR(20) NOT NULL,
  tdImg VARCHAR(50),
  tuId INT NOT NULL,
  tdPrice VARCHAR(10) NOT NULL,
  tdDate TIMESTAMP NOT NULL,
  tdDetail VARCHAR(100),
  deleteFlg TINYINT(1) DEFAULT '0',
  PRIMARY KEY(tdId),
  FOREIGN KEY(tuId) REFERENCES tbl_user(tuId)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- TABLE ORDER --
CREATE TABLE tbl_order(
  toId INT AUTO_INCREMENT,
  toNum INT(20) NOT NULL COMMENT '商品数量',
  toPrice VARCHAR(10) NOT NULL,
  toDate TIMESTAMP NOT NULL,
  tdName VARCHAR(20) NOT NULL,
  tuId INT NOT NULL,
  statusFlg TINYINT(1) DEFAULT '0' COMMENT '0：未受理 1：已受理 2：已完成',
  deleteFlg TINYINT(1) DEFAULT '0',
  PRIMARY KEY(toId),
  FOREIGN KEY(tuId) REFERENCES tbl_user(tuId)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- TABLE EXHIBITION --
CREATE TABLE tbl_exhibition(
  teId INT  AUTO_INCREMENT,
  teName VARCHAR(20) NOT NULL COMMENT '展示名称',
  tuId INT NOT NULL,
  deleteFlg TINYINT(1) DEFAULT '0',
  PRIMARY KEY(teId),
  FOREIGN KEY(tuId) REFERENCES tbl_user(tuId)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- TABLE CART --
CREATE TABLE tbl_cart(
  tcId INT  AUTO_INCREMENT,
  tcNum INT(20) NOT NULL COMMENT '商品数量',
  tdId INT NOT NULL,
  tuId INT NOT NULL,
  PRIMARY KEY(tcId),
  FOREIGN KEY(tdId) REFERENCES tbl_dish(tdId),
  FOREIGN KEY(tuId) REFERENCES tbl_user(tuId)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;