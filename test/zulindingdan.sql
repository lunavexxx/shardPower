create table zulindingdan
(
    id                  bigint auto_increment comment '主键'
        primary key,
    addtime             timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    zulinbianhao        varchar(200)                        null comment '租赁编号',
    chongdianbaobianhao varchar(200)                        null comment '充电宝编号',
    tupian              varchar(200)                        null comment '图片',
    quyu                varchar(200)                        null comment '区域',
    shanghubianhao      varchar(200)                        null comment '商户编号',
    shanghumingcheng    varchar(200)                        null comment '商户名称',
    meixiaoshifeiyong   varchar(200)                        null comment '每小时费用',
    kaishishijian       datetime                            null comment '开始时间',
    yonghuzhanghao      varchar(200)                        null comment '用户账号',
    yonghuxingming      varchar(200)                        null comment '用户姓名',
    yonghushouji        varchar(200)                        null comment '用户手机',
    yajin               varchar(20)                         null,
    constraint zulinbianhao
        unique (zulinbianhao)
)
    comment '租赁订单' charset = utf8mb4;

