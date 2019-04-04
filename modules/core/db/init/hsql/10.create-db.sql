-- begin TASKMAN_TASK
create table TASKMAN_TASK (
    ID varchar(36) not null,
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
    ASSIGNEE_ID varchar(36),
    STATE varchar(50) not null,
    SUBJECT varchar(255) not null,
    CONTENT longvarchar,
    --
    primary key (ID)
)^
-- end TASKMAN_TASK
-- begin TASKMAN_TASK_MESSAGE
create table TASKMAN_TASK_MESSAGE (
    ID varchar(36) not null,
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
    CONTENT longvarchar,
    TASK_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end TASKMAN_TASK_MESSAGE
