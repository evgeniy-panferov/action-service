ALTER TABLE partner
    ADD COLUMN last_update TIMESTAMP;

ALTER TABLE coupon
    ADD COLUMN last_update TIMESTAMP;

ALTER TABLE coupon ALTER COLUMN description TYPE VARCHAR(20000);

ALTER TABLE coupon ALTER COLUMN partner_id drop not null;

ALTER TABLE coupon DROP COLUMN partner;
ALTER TABLE coupon DROP COLUMN region_name;

ALTER TABLE coupon ALTER COLUMN status        DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN description   DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN discount      DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN species       DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN promocode     DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN frameset_link DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN goto_link     DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN short_name    DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN date_start    DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN date_end      DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN image_url     DROP NOT NULL;
ALTER TABLE coupon ALTER COLUMN partner_id    DROP NOT NULL;