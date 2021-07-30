INSERT INTO category (id, category_name, display_name, category_image, parent_cat_id) VALUES (1, 'women', 'WOMEN', 'women.jpg', null);
INSERT INTO category (id, category_name, display_name, category_image, parent_cat_id) VALUES (2, 'kids', 'KIDS', 'kids.jpg', null);
INSERT INTO category (id, category_name, display_name, category_image, parent_cat_id) VALUES (3, 'tradition', 'TRADITIONAL WEAR', 'salvar.jpg', 1);
INSERT INTO category (id, category_name, display_name, category_image, parent_cat_id) VALUES (4, 'tradition', 'MODERN WEAR', 'tees.jpg', 1);


/********************* Product ***********************/
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (1, 50, 'Cargo', false, null, 'Cargo Description', 'Cargo Tee', 1);
	
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (2, 10, 'Saree', true, null, 'Saree Description', 'Bannaras Silk', 2);
	
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (3, 0, 'Salvar', true, null, 'Salvar Description', 'Trendy Silk', 2);
	
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (4, 0, 'Salvar1', true, null, 'Salvar Description', 'Trendy Silk', 3);
/*
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (5, 20, 'Salvar2', true, null, 'Salvar Description', 'Trendy Silk', 3);
*/
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (6, 0, 'Salvar1', true, null, 'Salvar Description', 'Trendy Silk', 4);
	
INSERT INTO public.product(id, discount, display_name, is_available, other_properties, product_desc, product_name, category_id)
	VALUES (7, 20, 'Salvar2', true, null, 'Salvar Description', 'Trendy Silk', 4);


/********************* Color *************************/	
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (1, '#FF5733', 'red', 'RED');
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (2, '#FFBD33', 'orange', 'ORANGE');
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (3, '#DBFF33', 'yellow', 'YELLOW');
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (4, '#0D3D56', 'indigo', 'INDIGO');
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (5, '#c02F1D', 'ruby', 'RUBY');
INSERT INTO public.color(id, color_code, color_name, display_name) VALUES (6, '#33FFBD', 'maroon', 'MAROON');

	
/********************* Size *************************/
INSERT INTO public.size(id, display_name, size)	VALUES (1, 'XS', '32');
INSERT INTO public.size(id, display_name, size)	VALUES (2, 'S', '34');
INSERT INTO public.size(id, display_name, size)	VALUES (3, 'M', '36');
INSERT INTO public.size(id, display_name, size)	VALUES (4, 'L', '38');
INSERT INTO public.size(id, display_name, size)	VALUES (5, 'XL', '42');
INSERT INTO public.size(id, display_name, size)	VALUES (6, 'XXL', '44');


/********************* Product Details *************************/	
/*** Product 1 *****/
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (1, 'Cargo-S', 3, 10, true, false, 101, 1, 1, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (2, 'Cargo-M', 3, 10, true, true, 101, 1, 1, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (3, 'Cargo-L', 3, 10, true, false, 101, 1, 1, 4);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (4, 'Cargo-S', 3, 10, true, false, 101, 3, 1, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (5, 'Cargo-M', 3, 10, true, false, 101, 3, 1, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (6, 'Cargo-L', 3, 10, true, false, 101, 3, 1, 4);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (7, 'Cargo-S', 3, 10, true, false, 101, 4, 1, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (8, 'Cargo-M', 3, 10, true, false, 101, 4, 1, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (9, 'Cargo-L', 3, 10, true, false, 101, 4, 1, 4);
	

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (10, 'Saree', 3, 10, true, false, 101, 1, 2, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (11, 'Saree', 3, 10, true, true, 101, 1, 2, 3);

/*** Product 2 *****/
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (12, 'Saree', 3, 10, true, false, 101, 2, 2, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (13, 'Saree', 3, 10, true, true, 101, 2, 2, 3);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (14, 'Saree', 3, 10, true, false, 101, 4, 2, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (15, 'Saree', 3, 10, true, false, 101, 4, 2, 3);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (16, 'Saree', 3, 10, true, false, 101, 6, 2, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (17, 'Saree', 3, 10, true, false, 101, 6, 2, 3);
	
/*** Product 3 *****/
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (18, 'Salvar-', 3, 10, true, false, 101, 1, 3, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (19, 'Salvar-S', 3, 10, true, false, 101, 1, 3, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (20, 'Salvar-M', 3, 10, true, false, 101, 1, 3, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (21, 'Salvar-L', 3, 10, true, false, 101, 1, 3, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (22, 'Salvar-XL', 3, 10, true, false, 101, 1, 3, 5);
	
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (23, 'Salvar-XS', 3, 10, true, false, 101, 2, 3, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (24, 'Salvar-S', 3, 10, true, false, 101, 2, 3, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (25, 'Salvar-M', 3, 10, true, false, 101, 2, 3, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (26, 'Salvar-L', 3, 10, true, false, 101, 2, 3, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (27, 'Salvar-XL', 3, 10, true, false, 101, 2, 3, 5);


/*** Product 4 *****/
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (28, 'Salvar-XS', 3, 10, true, false, 101, 1, 4, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (29, 'Salvar-S', 3, 10, true, false, 101, 1, 4, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (30, 'Salvar-M', 3, 10, true, false, 101, 1, 4, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (31, 'Salvar-L', 3, 10, true, false, 101, 1, 4, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (32, 'Salvar-XL', 3, 10, true, false, 101, 1, 4, 5);
	
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (33, 'Salvar-XS', 3, 10, true, false, 101, 2, 4, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (34, 'Salvar-S', 3, 10, true, false, 101, 2, 4, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (35, 'Salvar-M', 3, 10, true, false, 101, 2, 4, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (36, 'Salvar-L', 3, 10, true, false, 101, 2, 4, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (37, 'Salvar-XL', 3, 10, true, false, 101, 2, 4, 5);
	

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (38, 'Salvar-XS', 3, 10, true, false, 101, 4, 4, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (39, 'Salvar-S', 3, 10, true, false, 101, 4, 4, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (40, 'Salvar-M', 3, 10, true, false, 101, 4, 4, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (41, 'Salvar-L', 3, 10, true, false, 101, 4, 4, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (42, 'Salvar-XL', 3, 10, true, false, 101, 4, 4, 5);
	
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (43, 'Salvar-XS', 3, 10, true, false, 101, 5, 4, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (44, 'Salvar-S', 3, 10, true, false, 101, 5, 4, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (45, 'Salvar-M', 3, 10, true, true, 101, 5, 4, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (46, 'Salvar-L', 3, 10, true, false, 101, 5, 4, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (47, 'Salvar-XL', 3, 10, true, false, 101, 5, 4, 5);
	

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (48, 'Salvar-XS', 3, 10, true, false, 101, 6, 4, 1);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (49, 'Salvar-S', 3, 10, true, false, 101, 6, 4, 2);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (50, 'Salvar-M', 3, 10, true, false, 101, 6, 4, 3);

INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (51, 'Salvar-L', 3, 10, true, false, 101, 6, 4, 4);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (52, 'Salvar-XL', 3, 10, true, false, 101, 6, 4, 5);
	
INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (53, 'Salvar-XL', 3, 10, true, true, 601, 6, 6, 5);
	
	INSERT INTO public.product_details(id, pd_name, avail_qty, discount, is_avail, is_default, price, color_id, product_id, size_id)
	VALUES (54, 'Salvar-L', 3, 10, true, true, 601, 3, 7, 4);
/********************* Image *************************/
INSERT INTO public.image(
	id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (1, 'Image of Saree', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/8488135/2019/1/21/0f22c134-75ce-41be-9ff6-1ce6ddc001461548063067216-SASSAFRAS-Women-Beige-Printed-Maxi-Dress-7251548063065751-1.jpg', 2, 'Saree_thumb.jpg', 1, 2);

INSERT INTO public.image(
	id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (2, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/7719007/2018/11/19/1cac68d7-2389-48c8-b6d0-0a16c7d4236b1542608837264-Libas-Women-Dresses-9261542608836986-1.jpg', 2, 'Salvar_thumb.jpg', 2, 3);
	
INSERT INTO public.image(id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (3, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/2/18/818d5abc-7760-4fb3-b609-e3b9863e07d61550506908300-1.jpg', 2, 'Salvar_thumb.jpg', 2, 3);

INSERT INTO public.image(id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (4, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/2/18/818d5abc-7760-4fb3-b609-e3b9863e07d61550506908300-1.jpg', 2, 'Salvar_thumb.jpg', 1, 1);

INSERT INTO public.image(id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (5, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/2/18/818d5abc-7760-4fb3-b609-e3b9863e07d61550506908300-1.jpg', 2, 'Salvar_thumb.jpg', 1, 4);

INSERT INTO public.image(id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (6, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/2/18/818d5abc-7760-4fb3-b609-e3b9863e07d61550506908300-1.jpg', 2, 'Salvar_thumb.jpg', 1, 6);

INSERT INTO public.image(id, img_name, img_path, priority, thumbnail_img, color_id, product_id)
	VALUES (7, 'Image of Salvar', 'https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/2/18/818d5abc-7760-4fb3-b609-e3b9863e07d61550506908300-1.jpg', 2, 'Salvar_thumb.jpg', 1, 7);

/********************* Address *************************/
INSERT INTO public.address(	id, address1, address2, city, country, pincode, state) VALUES (1, '12, MyStreet1', 'MyTown1', 'MyCity1', 'MyCountry1', 100001, 'MyState1');
INSERT INTO public.address(	id, address1, address2, city, country, pincode, state) VALUES (2, '13, MyStreet2', 'MyTown2', 'MyCity2', 'MyCountry1', 100002, 'MyState2');
INSERT INTO public.address(	id, address1, address2, city, country, pincode, state) VALUES (3, '14, MyStreet3', 'MyTown3', 'MyCity3', 'MyCountry1', 100003, 'MyState3');

/********************* Customer *************************/
INSERT INTO public.customer(id, name, is_reg_user) VALUES (1, 'MyCustomer1', false);

INSERT INTO public.customer(
	id, creation_date, last_modified_date, email, mobile, name, password, is_reg_user, is_subscribed, is_terms_accepted, billaddress_id, shipaddress_id, bill_same_as_ship)
	VALUES (2, NOW(), NOW(), 'customer2@itech.com', '9876543210', 'MyCustomer2', 'test2', true, true, true, 1, 1, true);
	
INSERT INTO public.customer(
	id, creation_date, last_modified_date, email, mobile, name, password, is_reg_user, is_subscribed, is_terms_accepted, billaddress_id, shipaddress_id, bill_same_as_ship)
	VALUES (3, NOW(), NOW(), 'customer3@itech.com', '9876543210', 'MyCustomer3', 'test3', true, true, true, 2, 3, false);

/********************* Cart *************************/
INSERT INTO public.cart( id, creation_date, last_modified_date, shipping_charge, customer_id) VALUES (1, NOW(), NOW(), '10', 2);

INSERT INTO public.cart( id, creation_date, last_modified_date, shipping_charge, customer_id) VALUES (2, NOW(), NOW(), '20', 3);

/********************* Cart Items *************************/
INSERT INTO public.cart_item(id, creation_date, last_modified_date, is_item_placed, qty, image_id, product_detail_id)
	VALUES (1, NOW(), NOW(), true, 2, 1, 2);
	
INSERT INTO public.cart_item(id, creation_date, last_modified_date, is_item_placed, qty, image_id, product_detail_id)
	VALUES (2, NOW(), NOW(), false, 3, 2, 4);
	
INSERT INTO public.cart_item(id, creation_date, last_modified_date, is_item_placed, qty, image_id, product_detail_id)
	VALUES (3, NOW(), NOW(), false, 2, 1, 5);
	
INSERT INTO public.cart_item(id, creation_date, last_modified_date, is_item_placed, qty, image_id, product_detail_id)
	VALUES (4, NOW(), NOW(), true, 2, 2, 4);
	
INSERT INTO public.cart_item(id, creation_date, last_modified_date, is_item_placed, qty, image_id, product_detail_id)
	VALUES (5, NOW(), NOW(), false, 1, 3, 7);
	
/********************* Cart & Cart Items *************************/	
INSERT INTO public.cart_cart_items(cart_id, cart_items_id) VALUES (1, 1);
INSERT INTO public.cart_cart_items(cart_id, cart_items_id) VALUES (1, 2);
INSERT INTO public.cart_cart_items(cart_id, cart_items_id) VALUES (2, 3);
INSERT INTO public.cart_cart_items(cart_id, cart_items_id) VALUES (2, 4);
INSERT INTO public.cart_cart_items(cart_id, cart_items_id) VALUES (2, 5);
