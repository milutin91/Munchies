ALTER TABLE restaurant
    MODIFY restaurant_name VARCHAR(255) NOT NULL,
    MODIFY restaurant_short_name VARCHAR(255) NOT NULL,
    MODIFY restaurant_address VARCHAR(255) NOT NULL,
    MODIFY restaurant_phone_number VARCHAR(255) NOT NULL,
    MODIFY restaurant_menu_url VARCHAR(255) NOT NULL,
    MODIFY restaurant_created VARCHAR(255) NOT NULL;

ALTER TABLE delivery_info
    MODIFY restaurant_id int NOT NULL,
    MODIFY delivery_info_time int NOT NULL,
    MODIFY delivery_info_additional_charges double NOT NULL,
    MODIFY delivery_info_created datetime NOT NULL;

ALTER TABLE employee
    MODIFY employee_firstname varchar(255) NOT NULL,
    MODIFY employee_lastname varchar(255) NOT NULL,
    MODIFY employee_email varchar(255) NOT NULL,
    MODIFY employee_password varchar(255) NOT NULL,
    MODIFY employee_role varchar(255) NOT NULL,
    MODIFY employee_created datetime NOT NULL;

ALTER TABLE group_order
    MODIFY restaurant_id int NOT NULL,
    MODIFY employee_id int NOT NULL,
    MODIFY group_order_created datetime NOT NULL;

ALTER TABLE order_item
    MODIFY group_order_id int NOT NULL,
    MODIFY employee_id int NOT NULL,
    MODIFY order_item_description varchar(255) NOT NULL,
    MODIFY order_item_quantity int NOT NULL,
    MODIFY order_item_price double NOT NULL,
    MODIFY order_item_created datetime NOT NULL;