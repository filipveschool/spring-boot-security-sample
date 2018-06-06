CREATE TABLE if not exists `reservation` (
  `id`            INT        NOT NULL AUTO_INCREMENT,
  `user_id`       INT(1)     NOT NULL,
  `party_size`    TINYINT(1) NOT NULL,
  `date`          TIMESTAMP  NOT NULL,
  `restaurant_id` INT        NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;