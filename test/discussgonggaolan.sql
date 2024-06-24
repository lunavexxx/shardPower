create table discussgonggaolan
(
    id       bigint auto_increment comment '主键'
        primary key,
    addtime  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    refid    bigint                              not null comment '关联表id',
    userid   bigint                              not null comment '用户id',
    nickname varchar(200)                        null comment '用户名',
    content  longtext                            not null comment '评论内容',
    reply    longtext                            null comment '回复内容'
)
    comment '公告栏评论表' charset = utf8mb4;

