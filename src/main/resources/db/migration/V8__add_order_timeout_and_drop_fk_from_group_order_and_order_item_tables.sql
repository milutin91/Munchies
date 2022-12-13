ALTER TABLE group_order
ADD COLUMN group_order_timeout int AFTER employee_id,
ADD COLUMN group_order_employee_name VARCHAR(255);

ALTER TABLE group_order DROP FOREIGN KEY group_order_ibfk_2;

ALTER TABLE group_order DROP COLUMN employee_id;

ALTER TABLE order_item DROP FOREIGN KEY order_item_ibfk_2;
ALTER TABLE order_item DROP COLUMN employee_id;
ALTER TABLE order_item DROP COLUMN order_item_quantity;

ALTER TABLE order_item
ADD COLUMN order_item_employee_name VARCHAR(255) AFTER group_order_id;