create table users
(
    id       bigint auto_increment comment '主键'
        primary key,
    username varchar(100)                           not null comment '用户名',
    password varchar(100)                           not null comment '密码',
    role     varchar(100) default '管理员'          null comment '角色',
    addtime  timestamp    default CURRENT_TIMESTAMP not null comment '新增时间'
)
    comment '用户表' charset = utf8mb4;

insert into users value(1, 'admin', 'admin', '管理员',CURRENT_TIMESTAMP );
