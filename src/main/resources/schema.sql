create table `user`
(
    id                       bigint  auto_increment comment 'ID' primary key,
    currency                 varchar(10)   not null comment '통화',
    limit_amount             double        not null comment '한도 금액'
);

create table `merchant`
(
    id                       bigint  auto_increment comment 'ID' primary key,
    fee_rate                 float   not null comment '수수료율'
);

create table `payment`
(
    id                       bigint  auto_increment comment 'ID' primary key,
    user_id                  bigint        not null comment 'USER ID',
    merchant_id              bigint        not null comment 'MERCHANT ID',
    currency                 varchar(10)   not null comment '통화',
    approve_amount           double        not null comment '승인 금액',
    approve_datetime         datetime      not null comment '승인 일시',
    foreign key (user_id)                  references `user`(id),
    foreign key (merchant_id)              references `merchant`(id)
);

create table `payment_detail`
(
    id                       bigint  auto_increment comment 'ID' primary key,
    payment_id               bigint        not null comment 'PAYMENT ID',
    method                   varchar(20)   not null comment '지불 수단',
    card_number              varchar(100)  not null comment '카드 번호',
    expiry_date              char(4)       not null comment '만료 일자',
    cvv                      char(3)       not null comment 'cvv',
    foreign key (payment_id)               references `payment`(id)
);