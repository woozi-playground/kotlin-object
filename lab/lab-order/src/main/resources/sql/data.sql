INSERT INTO poc.shops (shop_id, commission_rate, min_order_amount, name, `open`) VALUES(1, 0.0, 15000, '우지고기', true);
INSERT INTO poc.menus (menu_id, food_description, food_name, shop_id) VALUES(1, '고기가 땡기는 이 밤', '1인 세트', 1);
INSERT INTO poc.option_group_specs (option_group_spec_id, basic, exclusive, name, menu_id) VALUES(1, true, true, '기본', 1);
INSERT INTO poc.option_group_specs (option_group_spec_id, basic, exclusive, name, menu_id) VALUES(2, true, false, '고기 선택', 1);
INSERT INTO poc.option_group_specs (option_group_spec_id, basic, exclusive, name, menu_id) VALUES(3, false, false, '음료 추가 선택', 1);
INSERT INTO poc.option_specs (option_spec_id, name, price, option_group_spec_id) VALUES(1, '300g', 14000, 1);
INSERT INTO poc.option_specs (option_spec_id, name, price, option_group_spec_id) VALUES(2, '삼겹', 0, 2);
INSERT INTO poc.option_specs (option_spec_id, name, price, option_group_spec_id) VALUES(3, '목살', 0, 2);
INSERT INTO poc.option_specs (option_spec_id, name, price, option_group_spec_id) VALUES(4, '콜라 500ml 추가', 1500, 3);
INSERT INTO poc.option_specs (option_spec_id, name, price, option_group_spec_id) VALUES(5, '사이다 500ml 추가', 1500, 3);

