const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [
                    {
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "用户",
                        "menuJump": "列表",
                        "tableName": "yonghu"
                    },
                    {
                        "buttons": ["新增", "查看","修改",  "删除"],
                        "menu": "管理员",
                        "menuJump": "列表",
                        "tableName": "users"
                    },
                    {
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "维护人员",
                        "menuJump": "列表",
                        "tableName": "weihurenyuan"
                    }
                ], "menu": "用户管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除", "投放"],
                    "menu": "合作商户",
                    "menuJump": "列表",
                    "tableName": "hezuoshanghu"
                }, {
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "区域信息",
                    "menuJump": "列表",
                    "tableName": "quyuxinxi"
                }], "menu": "商户管理"
            }, {
                "child": [
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "充电宝投放",
                        "menuJump": "列表",
                        "tableName": "chongdianbaotoufang"
                    },
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "充电宝维护",
                        "menuJump": "列表",
                        "tableName": "chongdianbaoweihu"
                    }], "menu": "充电宝管理"
            }, {
                "child": [
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "租赁订单",
                        "menuJump": "列表",
                        "tableName": "zulindingdan"
                    },
                    {
                        "buttons": ["删除", "修改", "查看"],
                        "menu": "归还订单",
                        "menuJump": "列表",
                        "tableName": "guihaidingdan"
                    },
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "费用订单",
                        "menuJump": "列表",
                        "tableName": "feiyongdingdan"
                    }
                ],
                "menu": "订单管理"
            }, {
                "child": [
                    {
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "轮播图管理",
                        "tableName": "config"
                    },
                    {
                        "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                        "menu": "公告栏",
                        "menuJump": "列表",
                        "tableName": "gonggaolan"
                    }],
                "menu": "系统管理"
            }, {
                "child": [
                    {
                        "menu": "修改密码",
                        "tableName": "updatePassword"
                    }
                ],
                "menu": "个人中心"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看"],
                    "menu": "合作商户列表",
                    "menuJump": "列表",
                    "tableName": "hezuoshanghu"
                }], "menu": "合作商户模块"
            }, {
                "child": [{
                    "buttons": ["查看", "租赁"],
                    "menu": "充电宝投放列表",
                    "menuJump": "列表",
                    "tableName": "chongdianbaotoufang"
                }], "menu": "充电宝模块"
            }, {
                "child": [{"buttons": ["查看"], "menu": "公告栏列表", "menuJump": "列表", "tableName": "gonggaolan"}],
                "menu": "公告栏模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [
                    {
                        "buttons": ["查看", "归还"],
                        "menu": "租赁订单",
                        "menuJump": "列表",
                        "tableName": "zulindingdan"
                    },
                    {
                        "buttons": ["查看"],
                        "menu": "归还订单",
                        "menuJump": "列表",
                        "tableName": "guihaidingdan"
                    },
                    {
                        "buttons": ["查看", "支付"],
                        "menu": "费用订单",
                        "menuJump": "列表",
                        "tableName": "feiyongdingdan"
                    }
                ],
                "menu": "订单管理"
            }, {
                "child": [
                    {
                        "menu": "修改密码",
                        "tableName": "updatePassword"
                    },
                    {
                        "menu": "个人信息",
                        "tableName": "center"
                    }
                ],
                "menu": "个人中心"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看"],
                    "menu": "合作商户列表",
                    "menuJump": "列表",
                    "tableName": "hezuoshanghu"
                }], "menu": "合作商户模块"
            }, {
                "child": [{
                    "buttons": ["查看", "租赁"],
                    "menu": "充电宝投放列表",
                    "menuJump": "列表",
                    "tableName": "chongdianbaotoufang"
                }], "menu": "充电宝投放模块"
            }, {
                "child": [{"buttons": ["查看"], "menu": "公告栏列表", "menuJump": "列表", "tableName": "gonggaolan"}],
                "menu": "公告栏模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "yonghu"
        }, {
            "backMenu": [{
                "child": [
                    {
                        "buttons": ["查看"],
                        "menu": "租赁订单",
                        "menuJump": "列表",
                        "tableName": "zulindingdan"
                    },
                    {
                        "buttons": ["查看", "费用", "审核"],
                        "menu": "归还订单",
                        "menuJump": "列表",
                        "tableName": "guihaidingdan"
                    },
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "费用订单",
                        "menuJump": "列表",
                        "tableName": "feiyongdingdan"
                    }
                ],
                "menu": "订单管理"
            },{
                "child": [
                    {
                        "buttons": ["查看", "维护登记"],
                        "menu": "充电宝投放",
                        "menuJump": "列表",
                        "tableName": "chongdianbaotoufang"
                    },
                    {
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "充电宝维护",
                        "menuJump": "列表",
                        "tableName": "chongdianbaoweihu"
                    }], "menu": "充电宝管理"
            }, {
                "child": [
                    {
                        "menu": "修改密码",
                        "tableName": "updatePassword"
                    },
                    {
                        "menu": "个人信息",
                        "tableName": "center"
                    }
                ],
                "menu": "个人中心"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看"],
                    "menu": "合作商户列表",
                    "menuJump": "列表",
                    "tableName": "hezuoshanghu"
                }], "menu": "合作商户模块"
            }, {
                "child": [{
                    "buttons": ["查看", "租赁"],
                    "menu": "充电宝投放列表",
                    "menuJump": "列表",
                    "tableName": "chongdianbaotoufang"
                }], "menu": "充电宝投放模块"
            }, {
                "child": [{"buttons": ["查看"], "menu": "公告栏列表", "menuJump": "列表", "tableName": "gonggaolan"}],
                "menu": "公告栏模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "维护人员",
            "tableName": "weihurenyuan"
        }]
    }
}
export default menu;
