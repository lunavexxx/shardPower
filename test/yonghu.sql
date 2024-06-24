create table yonghu
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    yonghuzhanghao varchar(200)                        not null comment '用户账号',
    mima           varchar(200)                        not null comment '密码',
    yonghuxingming varchar(200)                        null comment '用户姓名',
    xingbie        varchar(200)                        null comment '性别',
    nianling       int                                 null comment '年龄',
    touxiang       varchar(200)                        null comment '头像',
    yonghushouji   varchar(200)                        null comment '用户手机',
    constraint yonghuzhanghao
        unique (yonghuzhanghao)
)
    comment '用户' charset = utf8mb4;

