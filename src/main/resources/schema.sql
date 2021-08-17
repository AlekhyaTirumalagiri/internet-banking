DROP TABLE IF EXISTS user_transactions;
CREATE TABLE user_transactions (
id INT AUTO_INCREMENT  PRIMARY KEY,
transaction_date DATE NOT NULL,
vendor VARCHAR_IGNORECASE(20) NOT NULL,
type VARCHAR_IGNORECASE(20) NOT NULL,
amount DOUBLE(20) NOT NULL,
category VARCHAR_IGNORECASE(20) NULL
);
