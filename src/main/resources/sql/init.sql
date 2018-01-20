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
        'canting2',
        MD5('123456'),
        '餐厅地址测试',
        NOW(),
        1002,
        '餐厅测试2'
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

INSERT INTO tbl_exhibition(
        teName,
        tuId
) VALUE(
        '第一食堂',
        1002
);

INSERT INTO tbl_exhibition(
        teName,
        tuId
) VALUE(
        '第五食堂',
        1003
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
        '/img/1002/lazijiding20171101.jpeg',
        1002,
        '6.00',
        NOW(),
        '辣子鸡丁，特色传统菜肴，属川菜系，是四川川东一道著名的江湖风味菜，因缘于歌乐山而故名。'
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
        '/img/1002/gongbaojiding20171101.jpeg',
        1002,
        '7.00',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
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
        '/img/1003/lazijiding20171102.jpeg',
        1003,
        '5.80',
        NOW(),
        '辣子鸡丁，特色传统菜肴，属川菜系，是四川川东一道著名的江湖风味菜，因缘于歌乐山而故名。'
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
        '/img/1003/gongbaojiding20171102.jpeg',
        1003,
        '7.50',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
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
        '/img/1003/gongbaojiding20171102.jpeg',
        1003,
        '7.50',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
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
        '/img/1003/gongbaojiding20171102.jpeg',
        1002,
        '7.50',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
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
        '/img/1003/gongbaojiding20171102.jpeg',
        1003,
        '7.50',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
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
        '/img/1003/gongbaojiding20171102.jpeg',
        1002,
        '7.50',
        NOW(),
        '宫保鸡丁，是一道闻名中外的特色传统名菜。选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。
        红而不辣、辣而不猛、香辣味浓、肉质滑脆。'
);INSERT INTO tbl_dish(
        tdName,
        tdImg,
        tuId,
        tdPrice,
        tdDate,
        tdDetail
) VALUE(
        '辣子鸡丁',
        '/img/1002/lazijiding20171101.jpeg',
        1002,
        '6.00',
        NOW(),
        '辣子鸡丁，特色传统菜肴，属川菜系，是四川川东一道著名的江湖风味菜，因缘于歌乐山而故名。'
);INSERT INTO tbl_dish(
        tdName,
        tdImg,
        tuId,
        tdPrice,
        tdDate,
        tdDetail
) VALUE(
        '辣子鸡丁',
        '/img/1002/lazijiding20171101.jpeg',
        1003,
        '6.00',
        NOW(),
        '辣子鸡丁，特色传统菜肴，属川菜系，是四川川东一道著名的江湖风味菜，因缘于歌乐山而故名。'
);