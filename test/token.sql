create table token
(
    id            bigint auto_increment comment '主键'
        primary key,
    userid        bigint                              not null comment '用户id',
    username      varchar(100)                        not null comment '用户名',
    tablename     varchar(100)                        null comment '表名',
    role          varchar(100)                        null comment '角色',
    token         varchar(200)                        not null comment '密码',
    addtime       timestamp default CURRENT_TIMESTAMP not null comment '新增时间',
    expiratedtime timestamp default CURRENT_TIMESTAMP not null comment '过期时间'
)
    comment 'token表' charset = utf8mb4;

