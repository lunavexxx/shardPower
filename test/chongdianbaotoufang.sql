create table chongdianbaotoufang
(
    id                  bigint auto_increment comment '主键'
        primary key,
    addtime             timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    chongdianbaobianhao varchar(200)                        null comment '充电宝编号',
    shanghubianhao      varchar(200)                        null comment '商户编号',
    shanghumingcheng    varchar(200)                        null comment '商户名称',
    xiangxidizhi        varchar(200)                        null comment '详细地址',
    pinpai              varchar(200)                        null comment '品牌',
    tupian              varchar(200)                        null comment '图片',
    quyu                varchar(200)                        null comment '区域',
    meixiaoshifeiyong   int                                 null comment '每小时费用',
    shengyudianliang    int                                 null comment '剩余电量',
    toufangshijian      date                                null comment '投放时间',
    yajin               varchar(20)                         null,
    constraint chongdianbaobianhao
        unique (chongdianbaobianhao)
)
    comment '充电宝投放' charset = utf8mb4;

