ALTER TABLE group_order
    MODIFY group_order_timeout int NOT NULL,
    MODIFY group_order_employee_name VARCHAR(255) NOT NULL;

ALTER TABLE order_item
    MODIFY order_item_employee_name VARCHAR(255) NOT NULL;