create table quyuxinxi
(
    id      bigint auto_increment comment '主键'
        primary key,
    addtime timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    quyu    varchar(200)                        null comment '区域'
)
    comment '区域信息' charset = utf8mb4;

