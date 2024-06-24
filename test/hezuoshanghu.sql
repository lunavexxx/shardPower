create table hezuoshanghu
(
    id               bigint auto_increment comment '主键'
        primary key,
    addtime          timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    shanghubianhao   varchar(200)                        null comment '商户编号',
    shanghumingcheng varchar(200)                        null comment '商户名称',
    quyu             varchar(200)                        null comment '区域',
    xiangxidizhi     varchar(200)                        null comment '详细地址',
    lianxiren        varchar(200)                        null comment '联系人',
    lianxifangshi    varchar(200)                        null comment '联系方式',
    shanghutupian    varchar(200)                        null comment '商户图片',
    shanghuhao       varchar(100)                        null,
    constraint shanghubianhao
        unique (shanghubianhao)
)
    comment '合作商户' charset = utf8mb4;

