drop database handson;
create database handson;
use handson;

CREATE TABLE `Pizza` (
	`pizzaId` INT NOT NULL,
	`pizzaName` VARCHAR(20) NULL DEFAULT NULL,
	`price` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`pizzaId`)
)COLLATE='latin1_swedish_ci';
INSERT INTO `handson`.`pizza` (`pizzaId`, `pizzaName`, `price`) VALUES ('10001', 'XYZVegS', '200');
INSERT INTO `handson`.`pizza` (`pizzaId`, `pizzaName`, `price`) VALUES ('10002', 'XYZVegM', '400');
INSERT INTO `handson`.`pizza` (`pizzaId`, `pizzaName`, `price`) VALUES ('10003', 'XYZVegL', '600');
INSERT INTO `handson`.`pizza` (`pizzaId`, `pizzaName`, `price`) VALUES ('10004', 'XYZNonVegS', '400');


CREATE TABLE `Pizza_Order` (
	`orderId` INT NOT NULL AUTO_INCREMENT,
	`customerName` VARCHAR(30) NULL DEFAULT NULL,
	`contactNumber` VARCHAR(10) NULL DEFAULT NULL,
	`pizzaId` INT NULL,
	`numberOfPiecesOrdered` INT NULL,
	`bill` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`orderId`),
	CONSTRAINT `FK__pizza` FOREIGN KEY (`pizzaId`) REFERENCES `pizza` (`pizzaId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)COLLATE='latin1_swedish_ci';


INSERT INTO `handson`.`pizza_order` (`orderId`, `customerName`, `contactNumber`,`pizzaId`,`numberOfPiecesOrdered`,`bill`) VALUES ('5001', 'Peter',  '1234567890','10001','1','200');
INSERT INTO `handson`.`pizza_order` (`orderId`, `customerName`, `contactNumber`,`pizzaId`,`numberOfPiecesOrdered`,`bill`) VALUES ('5002', 'Thomas', '6574893012','10001','2','400');
INSERT INTO `handson`.`pizza_order` (`orderId`, `customerName`, `contactNumber`,`pizzaId`,`numberOfPiecesOrdered`,`bill`) VALUES ('5003', 'Decken', '1243568790','10003','1','600');
INSERT INTO `handson`.`pizza_order` (`orderId`, `customerName`, `contactNumber`,`pizzaId`,`numberOfPiecesOrdered`,`bill`) VALUES ('5004', 'Jenifer','1029384756','10004','2','800');

commit;

