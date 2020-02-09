create table category
(
    id         int auto_increment
        primary key,
    created_at timestamp    default CURRENT_TIMESTAMP not null,
    updated_at timestamp                              null on update CURRENT_TIMESTAMP,
    name       varchar(20)  default ''                not null,
    icon_url   varchar(200) default ''                not null,
    sort       int          default 0                 not null,
    constraint name_unique_index
        unique (name)
);

INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (1, '2019-06-10 15:33:37', '2019-06-10 15:33:37', '美食', '/static/image/firstpage/food_u.png', 99);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (2, '2019-06-10 15:34:34', '2019-06-10 15:34:34', '酒店', '/static/image/firstpage/snack_u.png', 98);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (3, '2019-06-10 15:36:36', '2019-06-10 15:36:36', '休闲娱乐', '/static/image/firstpage/bar_o.png', 97);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (4, '2019-06-10 15:37:09', '2019-06-10 15:37:09', '结婚', '/static/image/firstpage/jiehun.png', 96);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (5, '2019-06-10 15:37:31', '2019-06-10 15:37:31', '足疗按摩', '/static/image/firstpage/zuliao.png', 96);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (6, '2019-06-10 15:37:49', '2019-06-10 15:37:49', 'KTV', '/static/image/firstpage/ktv_u.png', 95);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (7, '2019-06-10 15:38:14', '2019-06-10 15:38:14', '景点', '/static/image/firstpage/jingdian.png', 94);
INSERT INTO dianpingdb.category (id, created_at, updated_at, name, icon_url, sort) VALUES (8, '2019-06-10 15:38:35', '2019-06-10 15:38:35', '丽人', '/static/image/firstpage/liren.png', 93);
create table seller
(
    id            int auto_increment
        primary key,
    name          varchar(80)   default ''                not null,
    created_at    timestamp     default CURRENT_TIMESTAMP not null,
    updated_at    timestamp                               null on update CURRENT_TIMESTAMP,
    remark_score  decimal(2, 1) default 0.0               not null,
    disabled_flag int           default 0                 not null
);

INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (1, '江苏和府餐饮管理有限公司', '2020-01-28 15:39:04', '2020-02-01 22:38:26', 3.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (2, '北京烤鸭有限公司', '2020-01-28 15:39:05', '2020-01-28 15:39:05', 4.7, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (3, '合肥食品制造有限公司', '2020-01-28 15:39:05', '2020-01-28 15:39:05', 1.1, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (4, '青岛啤酒厂', '2020-01-28 15:39:06', '2020-01-28 15:39:06', 3.3, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (5, '杭州轻食有限公司', '2020-01-28 15:39:06', '2020-01-28 15:39:06', 1.1, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (6, '九竹食品加工公司', '2020-01-28 15:39:07', '2020-01-28 15:39:07', 1.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (7, '奔潮食品加工公司', '2020-01-28 15:39:07', '2020-01-28 15:39:07', 4.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (8, '百沐食品加工公司', '2020-01-28 15:39:08', '2020-01-28 15:39:08', 5.9, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (9, '韩蒂衣食品加工公司', '2020-01-28 15:39:08', '2020-01-28 15:39:08', 4.1, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (10, '城外食品加工公司', '2020-01-28 15:39:09', '2020-01-28 15:39:09', 2.9, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (11, '雪兔食品加工公司', '2020-01-28 15:39:10', '2020-01-28 15:39:10', 2.1, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (12, '琳德食品公司', '2020-01-28 15:39:10', '2020-01-28 15:39:10', 1.9, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (13, '深圳市盛华莲蓉食品厂', '2020-01-28 15:39:11', '2020-01-28 15:39:11', 3.2, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (14, '桂林聚德苑食品有限公司', '2020-01-28 15:39:11', '2020-01-28 15:39:11', 4.0, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (15, '天津达瑞仿真蛋糕模型厂', '2020-01-28 15:39:12', '2020-01-28 15:39:12', 4.7, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (16, '上海镭德杰喷码技术有限公司', '2020-01-28 15:39:12', '2020-01-28 15:39:12', 5.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (17, '凯悦饭店集团', '2020-01-28 15:39:13', '2020-01-28 15:39:13', 1.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (18, '卡尔森环球酒店公司', '2020-01-28 15:39:13', '2020-01-28 15:39:13', 2.8, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (19, '喜达屋酒店集团', '2020-01-28 15:39:14', '2020-01-28 15:39:14', 3.7, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (20, '最佳西方国际集团', '2020-01-28 15:39:14', '2020-01-28 15:39:14', 4.2, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (21, '精品国际饭店公司', '2020-01-28 15:39:15', '2020-01-28 15:39:15', 3.7, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (22, '希尔顿集团', '2020-01-28 15:39:16', '2020-01-28 15:39:16', 5.9, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (23, '雅高集团', '2020-01-28 15:39:16', '2020-01-28 15:39:16', 0.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (24, '万豪国际集团', '2020-01-28 15:39:17', '2020-01-28 15:39:17', 2.6, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (25, '胜腾酒店集团', '2020-01-28 15:39:17', '2020-01-28 15:39:17', 5.5, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (26, '洲际酒店集团', '2020-01-28 15:39:18', '2020-01-28 15:39:18', 1.6, 0);
INSERT INTO dianpingdb.seller (id, name, created_at, updated_at, remark_score, disabled_flag) VALUES (29, 'sean', '2020-01-28 16:18:37', '2020-01-28 17:38:43', 0.0, 0);
create table shop
(
    id            int auto_increment
        primary key,
    created_at    timestamp      default CURRENT_TIMESTAMP not null,
    updated_at    timestamp                                null on update CURRENT_TIMESTAMP,
    name          varchar(80)    default ''                not null,
    remark_score  decimal(2, 1)  default 0.0               not null,
    price_per_man int            default 0                 not null,
    latitude      decimal(10, 6) default 0.000000          not null,
    longitude     decimal(10, 6) default 0.000000          not null,
    category_id   int            default 0                 not null,
    tags          varchar(2000)  default ''                not null,
    start_time    varchar(200)   default ''                not null,
    end_time      varchar(200)   default ''                not null,
    address       varchar(200)   default ''                not null,
    seller_id     int            default 0                 not null,
    icon_url      varchar(100)   default ''                not null
);

INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (1, '2020-01-28 15:39:49', '2020-01-28 15:39:49', '和府捞面(正大乐城店)', 3.8, 104, 31.195341, 120.915855, 1, '新开业 人气爆棚', '10:00', '22:00', '船厂路36号', 1, '/static/image/shopcover/xchg.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (2, '2020-01-28 15:39:49', '2020-01-28 15:39:49', '和府捞面(飞洲国际店)', 5.4, 107, 31.189323, 121.443550, 1, '强烈推荐要点小食', '10:00', '22:00', '零陵路899号', 1, '/static/image/shopcover/zoocoffee.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (3, '2020-01-28 15:39:50', '2020-01-28 15:39:50', '和府捞面(百脑汇店)', 1.4, 57, 31.189323, 121.443550, 1, '有大桌 有WIFI', '10:00', '22:00', '漕溪北路339号', 1, '/static/image/shopcover/six.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (4, '2020-01-28 15:39:51', '2020-01-28 15:39:51', '花悦庭果木烤鸭', 3.2, 126, 31.306419, 121.524878, 1, '落地大窗 有WIFI', '11:00', '21:00', '翔殷路1099号', 2, '/static/image/shopcover/yjbf.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (5, '2020-01-28 15:39:51', '2020-01-28 15:39:51', '德泰丰北京烤鸭', 5.6, 73, 31.305236, 121.519875, 1, '五花肉味道', '11:00', '21:00', '邯郸路国宾路路口', 2, '/static/image/shopcover/jbw.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (6, '2020-01-28 15:39:52', '2020-01-28 15:39:52', '烧肉居酒屋', 5.9, 119, 31.306419, 121.524878, 1, '有包厢', '11:00', '21:00', '翔殷路1099号', 4, '/static/image/shopcover/mwsk.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (7, '2020-01-28 15:39:52', '2020-01-28 15:39:52', '西界', 2.1, 99, 31.309411, 121.515074, 1, '帅哥多', '11:00', '21:00', '大学路246号', 4, '/static/image/shopcover/lsy.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (8, '2020-01-28 15:39:53', '2020-01-28 15:39:53', 'LAVA酒吧', 3.7, 65, 31.308370, 121.521360, 1, '帅哥多', '11:00', '21:00', '淞沪路98号', 4, '/static/image/shopcover/jtyjj.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (9, '2020-01-28 15:39:53', '2020-01-28 15:39:53', '凯悦酒店', 3.9, 191, 31.306172, 121.525843, 2, '落地大窗', '11:00', '21:00', '国定东路88号', 17, '/static/image/shopcover/dfjzw.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (10, '2020-01-28 15:39:54', '2020-01-28 15:39:54', '凯悦嘉轩酒店', 4.5, 192, 31.196742, 121.322846, 2, '自助餐', '11:00', '21:00', '申虹路9号', 17, '/static/image/shopcover/secretroom09.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (11, '2020-01-28 15:39:54', '2020-01-28 15:39:54', '新虹桥凯悦酒店', 2.7, 117, 31.156899, 121.238362, 2, '自助餐', '11:00', '21:00', '沪青平公路2799弄', 17, '/static/image/shopcover/secretroom08.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (12, '2020-01-28 15:39:55', '2020-01-28 15:39:55', '凯悦咖啡(新建西路店)', 5.3, 58, 30.679819, 121.651921, 1, '有包厢', '11:00', '21:00', '南桥环城西路665号', 17, '/static/image/shopcover/secretroom07.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (13, '2020-01-28 15:39:56', '2020-01-28 15:39:56', '上海虹桥元希尔顿酒店', 3.8, 50, 31.193517, 121.401270, 2, '2019年上海必住酒店', '11:00', '21:00', '红松东路1116号', 22, '/static/image/shopcover/secretroom06.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (14, '2020-01-28 15:39:56', '2020-01-28 15:39:56', '国家会展中心希尔顿欢朋酒店', 0.8, 142, 30.953049, 121.053774, 2, '高档', '11:00', '21:00', '华漕镇盘阳路59弄', 22, '/static/image/shopcover/secretroom05.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (15, '2020-01-28 15:39:57', '2020-01-28 15:39:57', '上海绿地万豪酒店', 4.1, 132, 31.197688, 121.479098, 2, '高档', '11:00', '21:00', '江滨路99号', 23, '/static/image/shopcover/secretroom04.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (16, '2020-01-28 15:39:57', '2020-01-28 15:39:57', '上海宝华万豪酒店', 4.3, 191, 31.285934, 121.452481, 2, '高档', '11:00', '21:00', '广中西路333号', 23, '/static/image/shopcover/secretroom03.jpg');
INSERT INTO dianpingdb.shop (id, created_at, updated_at, name, remark_score, price_per_man, latitude, longitude, category_id, tags, start_time, end_time, address, seller_id, icon_url) VALUES (17, '2020-02-02 13:20:45', null, '测试门店', 0.0, 100, 25.892232, 107.752961, 1, '', '08:00', '22:00', '盈都江悦城', 1, '/static/image/firstpage/jiehun.png');
create table user
(
    id         int auto_increment
        primary key,
    created_at timestamp    default CURRENT_TIMESTAMP not null,
    updated_at timestamp                              null on update CURRENT_TIMESTAMP,
    telphone   varchar(40)  default ''                not null,
    password   varchar(200) default ''                not null,
    nick_name  varchar(40)  default ''                not null,
    gender     int          default 0                 not null,
    constraint telphone_unique_index
        unique (telphone)
);

INSERT INTO dianpingdb.user (id, created_at, updated_at, telphone, password, nick_name, gender) VALUES (12, '2020-01-27 14:20:34', null, '123', 'ICy5YqxZB1uWSwcVLSNLcA==', 'sean', 1);