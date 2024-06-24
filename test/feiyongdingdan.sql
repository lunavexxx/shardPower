create table feiyongdingdan
(
    id                  bigint auto_increment comment '主键'
        primary key,
    addtime             timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    zulinbianhao        varchar(200)                           null comment '租赁编号',
    chongdianbaobianhao varchar(200)                           null comment '充电宝编号',
    quyu                varchar(200)                           null comment '区域',
    tupian              varchar(200)                           null comment '图片',
    shanghubianhao      varchar(200)                           null comment '商户编号',
    shanghumingcheng    varchar(200)                           null comment '商户名称',
    kaishishijian       varchar(200)                           null comment '开始时间',
    jieshushijian       varchar(200)                           null comment '结束时间',
    meixiaoshifeiyong   varchar(200)                           null comment '每小时费用',
    zulinshizhang       varchar(200)                           not null comment '租赁时长',
    zulinfeiyong        varchar(200)                           null comment '租赁费用',
    yonghuzhanghao      varchar(200)                           null comment '用户账号',
    yonghuxingming      varchar(200)                           null comment '用户姓名',
    yonghushouji        varchar(200)                           null comment '用户手机',
    renyuanzhanghao     varchar(200)                           null comment '人员账号',
    renyuanxingming     varchar(200)                           null comment '人员姓名',
    ispay               varchar(200) default '未支付'          null comment '是否支付',
    yajin               varchar(20)                            null
)
    comment '费用订单' charset = utf8mb4;

