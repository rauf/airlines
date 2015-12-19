# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id                        bigint not null,
  picture                   varbinary(255),
  name                      varchar(255),
  password                  varchar(255),
  gender                    varchar(255),
  address                   varchar(255),
  contact_no                varchar(255),
  email                     varchar(255),
  date_of_birth             timestamp,
  security_answer           varchar(255),
  age                       integer,
  security_question_id      bigint,
  constraint pk_admin primary key (id))
;

create table airplane (
  id                        bigint not null,
  reg_no                    varchar(255),
  type                      varchar(255),
  total_seat                varchar(255),
  constraint pk_airplane primary key (id))
;

create table airport (
  id                        bigint not null,
  name                      varchar(255),
  country                   varchar(255),
  city                      varchar(255),
  address                   varchar(255),
  constraint pk_airport primary key (id))
;

create table contact_us (
  id                        bigint not null,
  subject                   varchar(255),
  description               clob,
  date                      timestamp,
  user_id                   bigint,
  constraint pk_contact_us primary key (id))
;

create table fare (
  id                        bigint not null,
  amount                    integer,
  description               varchar(255),
  condition                 varchar(255),
  constraint pk_fare primary key (id))
;

create table feedback (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  message                   varchar(255),
  rating                    varchar(255),
  constraint pk_feedback primary key (id))
;

create table flight (
  id                        bigint not null,
  depart_date               timestamp,
  arrival_time              timestamp,
  departure_time            timestamp,
  routee_id                 bigint,
  constraint pk_flight primary key (id))
;

create table flight_query (
  id                        bigint not null,
  depart_date               timestamp,
  source                    varchar(255),
  destination               varchar(255),
  adult                     integer,
  children                  integer,
  infant                    integer,
  constraint pk_flight_query primary key (id))
;

create table passenger (
  id                        bigint not null,
  name                      varchar(255),
  age                       integer,
  gender                    varchar(255),
  constraint pk_passenger primary key (id))
;

create table routee (
  id                        bigint not null,
  airport_id                bigint,
  fare_id                   bigint,
  source                    varchar(255),
  destination               varchar(255),
  intermediate              varchar(255),
  constraint uq_routee_airport_id unique (airport_id),
  constraint pk_routee primary key (id))
;

create table security_question (
  id                        bigint not null,
  question                  varchar(255),
  constraint pk_security_question primary key (id))
;

create table transactionn (
  id                        bigint not null,
  date                      timestamp,
  mode                      varchar(255),
  amount                    integer,
  user_id                   bigint,
  constraint pk_transactionn primary key (id))
;

create table user (
  id                        bigint not null,
  picture                   blob,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  gender                    varchar(255),
  address_line1             varchar(255),
  address_line2             varchar(255),
  pin_code                  integer,
  contact_no                varchar(255),
  date_of_birth             timestamp,
  age                       integer,
  security_question_id      bigint,
  security_answer           varchar(255),
  constraint pk_user primary key (id))
;


create table flight_airplane (
  flight_id                      bigint not null,
  airplane_id                    bigint not null,
  constraint pk_flight_airplane primary key (flight_id, airplane_id))
;

create table transactionn_passenger (
  transactionn_id                bigint not null,
  passenger_id                   bigint not null,
  constraint pk_transactionn_passenger primary key (transactionn_id, passenger_id))
;

create table user_flight (
  user_id                        bigint not null,
  flight_id                      bigint not null,
  constraint pk_user_flight primary key (user_id, flight_id))
;
create sequence admin_seq;

create sequence airplane_seq;

create sequence airport_seq;

create sequence contact_us_seq;

create sequence fare_seq;

create sequence feedback_seq;

create sequence flight_seq;

create sequence flight_query_seq;

create sequence passenger_seq;

create sequence routee_seq;

create sequence security_question_seq;

create sequence transactionn_seq;

create sequence user_seq;

alter table admin add constraint fk_admin_securityQuestion_1 foreign key (security_question_id) references security_question (id) on delete restrict on update restrict;
create index ix_admin_securityQuestion_1 on admin (security_question_id);
alter table contact_us add constraint fk_contact_us_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_contact_us_user_2 on contact_us (user_id);
alter table flight add constraint fk_flight_routee_3 foreign key (routee_id) references routee (id) on delete restrict on update restrict;
create index ix_flight_routee_3 on flight (routee_id);
alter table routee add constraint fk_routee_airport_4 foreign key (airport_id) references airport (id) on delete restrict on update restrict;
create index ix_routee_airport_4 on routee (airport_id);
alter table routee add constraint fk_routee_fare_5 foreign key (fare_id) references fare (id) on delete restrict on update restrict;
create index ix_routee_fare_5 on routee (fare_id);
alter table transactionn add constraint fk_transactionn_user_6 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_transactionn_user_6 on transactionn (user_id);
alter table user add constraint fk_user_securityQuestion_7 foreign key (security_question_id) references security_question (id) on delete restrict on update restrict;
create index ix_user_securityQuestion_7 on user (security_question_id);



alter table flight_airplane add constraint fk_flight_airplane_flight_01 foreign key (flight_id) references flight (id) on delete restrict on update restrict;

alter table flight_airplane add constraint fk_flight_airplane_airplane_02 foreign key (airplane_id) references airplane (id) on delete restrict on update restrict;

alter table transactionn_passenger add constraint fk_transactionn_passenger_tra_01 foreign key (transactionn_id) references transactionn (id) on delete restrict on update restrict;

alter table transactionn_passenger add constraint fk_transactionn_passenger_pas_02 foreign key (passenger_id) references passenger (id) on delete restrict on update restrict;

alter table user_flight add constraint fk_user_flight_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_flight add constraint fk_user_flight_flight_02 foreign key (flight_id) references flight (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists admin;

drop table if exists airplane;

drop table if exists flight_airplane;

drop table if exists airport;

drop table if exists contact_us;

drop table if exists fare;

drop table if exists feedback;

drop table if exists flight;

drop table if exists user_flight;

drop table if exists flight_query;

drop table if exists passenger;

drop table if exists transactionn_passenger;

drop table if exists routee;

drop table if exists security_question;

drop table if exists transactionn;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists admin_seq;

drop sequence if exists airplane_seq;

drop sequence if exists airport_seq;

drop sequence if exists contact_us_seq;

drop sequence if exists fare_seq;

drop sequence if exists feedback_seq;

drop sequence if exists flight_seq;

drop sequence if exists flight_query_seq;

drop sequence if exists passenger_seq;

drop sequence if exists routee_seq;

drop sequence if exists security_question_seq;

drop sequence if exists transactionn_seq;

drop sequence if exists user_seq;

