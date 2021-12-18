alter table partner add column description varchar;
alter table partner add column exclusive boolean;

create table Category(
    id BIGSERIAL PRIMARY KEY,
    name varchar,
    admitad_id varchar,
    language varchar,
    partner_id bigint,
    foreign key (partner_id) references partner (id)
)