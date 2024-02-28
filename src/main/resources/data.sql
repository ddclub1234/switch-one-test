insert into `payment_user`(id, currency, limit_amount) values (1000, 'USD', 10000.00);

insert into `merchant`(id, fee_rate) values (1000, 0.05);

insert into `payment`(id, user_id, merchant_id, currency, approve_amount, approve_datetime) values (1000, 1000, 1000, 'USD', 400.00, current_timestamp);

insert into `payment_detail`(id, payment_id, method, card_number, expiry_date, cvv) values (1000, 1000, 'creditCard', '1234-5678-9123-4567', '12/24', '123');