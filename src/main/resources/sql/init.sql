USE SCHOOL_RESTAURANT_DB;

SET time_zone = '+8:00';

-- initialization --

INSERT INTO tbl_identity(
        TI_NAME,
        TI_DETAIL
) VALUE(
        '管理员',
        '管理员测试'
);

INSERT INTO tbl_identity(
        TI_NAME,
        TI_DETAIL
) VALUE(
        '餐厅',
        '餐厅测试'
);

INSERT INTO tbl_identity(
        TI_NAME,
        TI_DETAIL
) VALUE(
        '学生',
        '学生'
);

----

INSERT INTO tbl_user(
        TU_NAME,
        TU_PWD,
        TU_ADDRESS,
        TU_DATE,
        TI_ID,
        TU_DETAIL
) VALUE(
        'guanliyuan1',
        MD5('123456'),
        '管理员地址测试',
        NOW(),
        1001,
        '管理员测试1'
);

INSERT INTO tbl_user(
        TU_NAME,
        TU_PWD,
        TU_ADDRESS,
        TU_DATE,
        TI_ID,
        TU_DETAIL
) VALUE(
        'canting1',
        MD5('123456'),
        '餐厅地址测试',
        NOW(),
        1002,
        '餐厅测试1'
);

INSERT INTO tbl_user(
        TU_NAME,
        TU_PWD,
        TU_ADDRESS,
        TU_DATE,
        TI_ID,
        TU_DETAIL
) VALUE(
        'xuesheng1',
        MD5('123456'),
        '学生地址测试',
        NOW(),
        1003,
        '学生测试1'
);

----

INSERT INTO tbl_dish(
        TD_NAME,
        TD_IMG,
        TU_ID,
        TD_PRICE,
        TD_DATE,
        TD_DETAIL
) VALUE(
        '辣子鸡丁',
        '../data/img/lazijiding20171121002',
        1002,
        '6.00',
        NOW(),
        '菜单测试1'
);

INSERT INTO tbl_dish(
        TD_NAME,
        TD_IMG,
        TU_ID,
        TD_PRICE,
        TD_DATE,
        TD_DETAIL
) VALUE(
        '宫保鸡丁',
        '../data/img/gongbaojiding20171121001',
        1002,
        '7.00',
        NOW(),
        '菜单测试2'
);
