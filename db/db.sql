# DB 생성
DROP DATABASE IF EXISTS text_board;
CREATE DATABASE text_board;

# DB 선택
USE text_board;

# 게시물 테이블 생성
CREATE TABLE article (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

# 게시물 테이블 테스트 데이터
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = CONCAT('제목', RAND()),
`body` = CONCAT('내용', RAND());

# 게시물 수정 테스트 데이터
UPDATE article
SET updateDate = NOW(),
title = '제목2';,
`body` = '내용2',
WHERE id = 1;

# 멤버 테이블 생성
CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(20) NOT NULL,
	loginPw CHAR(100) NOT NULL,
	`name` CHAR(100) NOT NULL
);

# 멤버 테이블 테스트 데이터
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = CONCAT('user', RAND()),
loginPw = CONCAT('user', RAND()),
`name` = CONCAT('name', RAND());

# 아이디 존재 여부 확인
SELECT COUNT(*) > 0
FROM `member`
WHERE loginId = loginId;

# 게시물 테이블에 멤버 ID Column 추가
ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;

# 게시물 테이블과 멤버 테이블 조인
SELECT A.*, M.name AS extra__writerName
FROM article AS A
INNER JOIN MEMBER AS M
ON A.memberId = M.id
ORDER BY id DESC;

# 게시물 테이블에 조회수 Column 추가
ALTER TABLE article ADD COLUMN hit INT(10) UNSIGNED NOT NULL AFTER memberId;