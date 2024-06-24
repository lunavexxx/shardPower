create table gonggaolan
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    gonggaobiaoti  varchar(200)                        not null comment '公告标题',
    fengmiantupian varchar(200)                        null comment '封面图片',
    neirong        longtext                            null comment '内容',
    faburiqi       date                                null comment '发布日期',
    faburen        varchar(200)                        null comment '发布人'
)
    comment '公告栏' charset = utf8mb4;

