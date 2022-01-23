INSERT INTO countries VALUES (1,'China');
INSERT INTO countries VALUES (2,'USA');
INSERT INTO countries VALUES (3,'South Korea');



INSERT INTO goods ( name ,
                    category ,
                    sub_category ,
                    trade_mark ,
                    country_id ,
                    price ,
                    amount ,
                    good_description ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('iPhone X', 'Smartphones and gadjets','Smartphones', 'Apple',2,90000,14,'Nice smartphone','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);
INSERT INTO goods ( name ,
                    category ,
                    sub_category ,
                    trade_mark ,
                    country_id ,
                    price ,
                    amount ,
                    good_description ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('Honor 5', 'Smartphones and gadjets','Smartphones', 'Honor',1,30000,26,'Nice smartphone','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);

INSERT INTO goods ( name ,
                    category ,
                    sub_category ,
                    trade_mark ,
                    country_id ,
                    price ,
                    amount ,
                    good_description ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('Samsung S9', 'Smartphones and gadjets','Smartphones', 'Samsung',3,50000,33,'Nice smartphone','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);

INSERT INTO goods ( name ,
                    category ,
                    sub_category ,
                    trade_mark ,
                    country_id ,
                    price ,
                    amount ,
                    good_description ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('Huawei P20', 'Smartphones and gadjets','Smartphones', 'Huawei',1,13000,29,'Nice smartphone','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);

INSERT INTO users ( username ,
                    name ,
                    surname ,
                    password ,
                    role ,
                    city ,
                    addressline1 ,
                    addressline2 ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('mad_dog', 'John','Jameson', '$2a$12$kn6rKABuW2Ga2xoPqSoKpuTAail6XVNkU/eED2thrdzG4GFOwcSh.','ADMIN','Dallas','Gill Street','Building 4','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);

INSERT INTO users ( username ,
                    name ,
                    surname ,
                    password ,
                    role ,
                    city ,
                    addressline1 ,
                    addressline2 ,
                    created_at ,
                    updated_at ,
                    archived )
VALUES ('tom_sawyer', 'Alan','Marshall', '$2a$12$kn6rKABuW2Ga2xoPqSoKpuTAail6XVNkU/eED2thrdzG4GFOwcSh.','USER','Atlanta','Oak Street','Building 9','2017-07-01T14:59:55','2017-07-01T14:59:55',FALSE);