--liquibase formatted sql
--changeset sapan:1
create table SUBSCRIBER
(
    id   int IDENTITY NOT NULL PRIMARY KEY,
    EMAIL varchar(255),
    FIRST_NAME varchar(255)
);