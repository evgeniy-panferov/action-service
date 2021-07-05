CREATE TABLE Region
(
    id        bigserial,
    name      VARCHAR(5) NOT NULL,
    action_id bigint
);

alter table region
    add constraint region_action_id foreign key (action_id) references action (id);

