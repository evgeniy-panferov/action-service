create table Partner
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255)                      NOT NULL,
    image_url VARCHAR DEFAULT 'PHOTO_NOT_FOUND' NOT NULL
);

create table Action
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    status        VARCHAR(255) NOT NULL,
    partner       VARCHAR(255) NOT NULL,
    description   VARCHAR(255) NOT NULL,
    discount      VARCHAR(255) NOT NULL,
    species       VARCHAR(255) NOT NULL,
    promocode     VARCHAR(255) NOT NULL,
    frameset_link VARCHAR(255) NOT NULL,
    goto_link     VARCHAR(255) NOT NULL,
    short_name    VARCHAR(255) NOT NULL,
    date_start    TIMESTAMP    NOT NULL,
    date_end      TIMESTAMP    NOT NULL,
    image_url     VARCHAR(255) NOT NULL,
    partner_id    BIGINT       NOT NULL,
    region_name   VARCHAR(5) NOT NULL
);

ALTER TABLE Action
    ADD CONSTRAINT partner_id_action_id_fk FOREIGN KEY (partner_id) REFERENCES Partner (id) ON DELETE CASCADE


