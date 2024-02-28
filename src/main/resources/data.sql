insert into `user`(id, currency, limit_amount) values (1, 'USD', 10000.00);

insert into `merchant`(id, fee_rate) values (1, 0.05);

insert into `payment`(id, user_id, merchant_id, currency, approve_amount, approve_datetime) values (1, 1, 1, 'USD', 400.00, current_timestamp);

insert into `payment_detail`(id, payment_id, card_number, expiry_date, cvv) values (1, 1, '1234-5678-9123-4567', '1224', '123');