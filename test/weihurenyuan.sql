create table weihurenyuan
(
    id              bigint auto_increment comment '主键'
        primary key,
    addtime         timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    renyuanzhanghao varchar(200)                        not null comment '人员账号',
    mima            varchar(200)                        not null comment '密码',
    renyuanxingming varchar(200)                        null comment '人员姓名',
    xingbie         varchar(200)                        null comment '性别',
    nianling        int                                 null comment '年龄',
    zhaopian        varchar(200)                        null comment '照片',
    lianxifangshi   varchar(200)                        null comment '联系方式',
    weihuquyu       varchar(200)                        null comment '维护区域',
    constraint renyuanzhanghao
        unique (renyuanzhanghao)
)
    comment '维护人员' charset = utf8mb4;

