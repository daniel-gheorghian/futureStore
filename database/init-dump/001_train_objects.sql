create table cart
(
  id           NUMBER NOT NULL,
  status       VARCHAR(20),
  account_code VARCHAR(100),
  store        VARCHAR(100),
  PRIMARY KEY (id)
);

create table cart_items
(
  id               NUMBER NOT NULL,
  cart_id          NUMBER,
  item_type        VARCHAR(50),
  item_code        VARCHAR(50),
  item_description VARCHAR(150),
  quantity         NUMBER,
  price            NUMBER,
  PRIMARY KEY (id)
);

create table catalog_item
(
  id               NUMBER NOT NULL,
  item_type        VARCHAR(50),
  item_code        VARCHAR(50),
  item_description VARCHAR(50),
  price            NUMBER,
  PRIMARY KEY (id)
);

create table catalog_item_review
(
  id             NUMBER NOT NULL,
  item_item_code VARCHAR(50),
  review         NUMBER,
  PRIMARY KEY (id)
);

create table catalog_item_spec
(
  id             NUMBER NOT NULL,
  item_item_code VARCHAR(50),
  spec           VARCHAR(1000),
  PRIMARY KEY (id)
);

create sequence SEQ_CART_ID;
create sequence SEQ_CART_ITEM_ID;
create sequence SEQ_CATALOG_ITEM_ID;
create sequence SEQ_CATALOG_ITEM_REVIEW_ID;
create sequence SEQ_CATALOG_ITEM_SPEC_ID;