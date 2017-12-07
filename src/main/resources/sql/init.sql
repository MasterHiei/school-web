USE SCHOOL_RESTAURANT_DB;

SET time_zone = '+8:00';

-- initialization --

INSERT INTO tbl_identity(
        tiName,
        tiDetail
) VALUE(
        '管理员',
        '管理员测试'
);

INSERT INTO tbl_identity(
        tiName,
        tiDetail
) VALUE(
        '餐厅',
        '餐厅测试'
);

INSERT INTO tbl_identity(
        tiName,
        tiDetail
) VALUE(
        '学生',
        '学生'
);

INSERT INTO tbl_user(
        tuName,
        tuPwd,
        tuAddress,
        tuDate,
        tiId,
        tuDetail
) VALUE(
        'guanliyuan1',
        MD5('123456'),
        '管理员地址测试',
        NOW(),
        1001,
        '管理员测试1'
);

INSERT INTO tbl_user(
        tuName,
        tuPwd,
        tuAddress,
        tuDate,
        tiId,
        tuDetail
) VALUE(
        'canting1',
        MD5('123456'),
        '餐厅地址测试',
        NOW(),
        1002,
        '餐厅测试1'
);

INSERT INTO tbl_user(
        tuName,
        tuPwd,
        tuAddress,
        tuDate,
        tiId,
        tuDetail
) VALUE(
        'xuesheng1',
        MD5('123456'),
        '学生地址测试',
        NOW(),
        1003,
        '学生测试1'
);

INSERT INTO tbl_dish(
        tdName,
        tdImg,
        tuId,
        tdPrice,
        tdDate,
        tdDetail
) VALUE(
        '辣子鸡丁',
        '../data/img/lazijiding20171121002',
        1002,
        '6.00',
        NOW(),
        '菜单测试1'
);

INSERT INTO tbl_dish(
        tdName,
        tdImg,
        tuId,
        tdPrice,
        tdDate,
        tdDetail
) VALUE(
        '宫保鸡丁',
        '../data/img/gongbaojiding20171121001',
        1002,
        '7.00',
        NOW(),
        '菜单测试2'
);
