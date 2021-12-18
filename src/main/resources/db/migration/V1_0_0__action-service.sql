create table Partner
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255)                     ,
    image_url VARCHAR DEFAULT 'PHOTO_NOT_FOUND'
);

create table Coupon
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    status        VARCHAR(255),
    partner       VARCHAR(255),
    description   VARCHAR(255),
    discount      VARCHAR(255),
    species       VARCHAR(255),
    promocode     VARCHAR(255),
    frameset_link VARCHAR(255),
    goto_link     VARCHAR(255),
    short_name    VARCHAR(255),
    date_start    TIMESTAMP   ,
    date_end      TIMESTAMP   ,
    image_url     VARCHAR(255),
    partner_id    BIGINT      ,
    region_name   VARCHAR(5)
);

ALTER TABLE Coupon
    ADD CONSTRAINT partner_id_action_id_fk FOREIGN KEY (partner_id) REFERENCES Partner (id) ON DELETE CASCADE


