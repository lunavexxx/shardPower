create table config
(
    id    bigint auto_increment comment '主键'
        primary key,
    name  varchar(100) not null comment '配置参数名称',
    value varchar(100) null comment '配置参数值'
)
    comment '配置文件' charset = utf8mb4;

