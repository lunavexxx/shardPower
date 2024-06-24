create table chongdianbaoweihu
(
    id                  bigint auto_increment comment '主键'
        primary key,
    addtime             timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    chongdianbaobianhao varchar(200)                        null comment '充电宝编号',
    shanghubianhao      varchar(200)                        null comment '商户编号',
    shanghumingcheng    varchar(200)                        null comment '商户名称',
    tupian              varchar(200)                        null comment '图片',
    quyu                varchar(200)                        null comment '区域',
    pinpai              varchar(200)                        null comment '品牌',
    guzhangmiaoshu      longtext                            null comment '故障描述',
    chulijieguo         longtext                            null comment '处理结果',
    chulishijian        date                                null comment '处理时间',
    renyuanzhanghao     varchar(200)                        null comment '人员账号',
    renyuanxingming     varchar(200)                        null comment '人员姓名'
)
    comment '充电宝维护' charset = utf8mb4;

