CREATE TABLE Region
(
    id        bigserial,
    name      VARCHAR(5) NOT NULL,
    coupon_id bigint
);

alter table region
    add constraint region_action_id foreign key (coupon_id) references Coupon (id);

