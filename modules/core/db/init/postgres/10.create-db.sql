-- begin TASKMAN_TASK
create table TASKMAN_TASK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ bigint not null,
    REPORTER_EMAIL varchar(255),
    ASSIGNEE_ID uuid,
    STATE varchar(50) not null,
    SUBJECT varchar(255) not null,
    CONTENT text,
    --
    primary key (ID)
)^
-- end TASKMAN_TASK
-- begin TASKMAN_TASK_MESSAGE
create table TASKMAN_TASK_MESSAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REPORTER varchar(255),
    DIRECTION varchar(50),
    SUBJECT varchar(255) not null,
    CONTENT text,
    TASK_ID uuid not null,
    IMAP_MESSAGE_ID uuid,
    ORIGINAL_IMAP_MESSAGE_ID varchar(255),
    --
    primary key (ID)
)^
-- end TASKMAN_TASK_MESSAGE
