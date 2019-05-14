delete from catalog_item_spec;
commit;
delete from catalog_item_review;
commit;
delete from catalog_item;
commit;
delete from cart_items;
commit;
delete from cart;
commit;
insert into cart (id, status, account_code, store)
values (SEQ_CART_ID.nextval, 'NEW', '564', 'Iasi2');
insert into cart (id, status, account_code, store)
values (SEQ_CART_ID.nextval, 'NEW', '123123', 'Iasi5');
insert into cart (id, status, account_code, store)
values (SEQ_CART_ID.nextval, 'NEW', '222', 'Iasi1');
insert into cart (id, status, account_code, store)
values (SEQ_CART_ID.nextval, 'NEW', '222', 'Iasi1');
commit;

insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'PHONE', 'BRICK9', 'iBrick 9', 1000);
insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'PHONE', 'S10', 'Sam Sung 10', 2500);
insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'ACCESSORY', 'MIST_POD', 'Mist Pods', 500);
insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'ACCESSORY', 'P_APPLE_WATCH', 'Pineapple Watch', 300);
insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'ACCESSORY', 'I_TABLET', 'iTablet', 500);
insert into catalog_item (id, item_type, item_code, item_description, price)
values (SEQ_CATALOG_ITEM_ID.nextval, 'ACCESSORY', 'W_HEADPHONE', 'White Headphones', 50);
commit;

insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'MIST_POD', 100);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'MIST_POD', 80);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'MIST_POD', 99);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'MIST_POD', 110);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 60);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 70);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 30);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 99);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 80);
insert into catalog_item_review (id, item_item_code, review)
values (SEQ_CATALOG_ITEM_REVIEW_ID.nextval, 'P_APPLE_WATCH', 72);
commit;

insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'MIST_POD', 'Comfortable to wear');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'MIST_POD', 'Almost no weight');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'MIST_POD', 'High fidelity');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'MIST_POD', 'Available in Misty Black and Bright White');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'P_APPLE_WATCH', 'Accurate time piece');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'P_APPLE_WATCH', 'Pleasant fragrance');
insert into catalog_item_spec (id, item_item_code, spec)
values (SEQ_CATALOG_ITEM_SPEC_ID.nextval, 'P_APPLE_WATCH', 'Available in Misty Black and Bright White');
commit;