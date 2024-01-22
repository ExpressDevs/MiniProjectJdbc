-- 테이블 삭제
DROP TABLE IF EXISTS tbl_goods CASCADE;
DROP TABLE IF EXISTS tbl_order CASCADE;
DROP TABLE IF EXISTS tbl_payment_method CASCADE;
DROP TABLE IF EXISTS tbl_member CASCADE;

-- 테이블 생성
-- 1. 회원 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_member
(
    id VARCHAR(30) NOT NULL COMMENT '아이디',
    member_name VARCHAR(30) COMMENT '회원이름',
    member_age INT COMMENT '회원나이',
    password VARCHAR(30) COMMENT '비밀번호',
    member_mileage INT COMMENT '마일리지',
    member_login INT COMMENT '회원여부',
    CONSTRAINT pk_member_id PRIMARY KEY (id)
) ENGINE=INNODB COMMENT '회원';

-- 2. 결제수단 테이블 생성
CREATE TABLE tbl_payment_method (
    payment_method VARCHAR(30) NOT NULL COMMENT '결제수단',
    discount_rate DOUBLE COMMENT '할인율',
    CONSTRAINT pk_payment_method PRIMARY KEY (payment_method)
) ENGINE=INNODB COMMENT '결제수단방법';

-- 3. 주문 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_order
(
    order_number    		VARCHAR(30) COMMENT '주문번호',
    id    				VARCHAR(30) NOT NULL COMMENT '아이디',
    departure_station 	VARCHAR(30) NOT NULL COMMENT '출발역',
    arrival_station 		VARCHAR(30) NOT NULL COMMENT '도착역',
    departure_time 		VARCHAR(30) NOT NULL COMMENT '출발시간',
    billing_amount 		INT NOT NULL COMMENT '청구금액',
    payment_method 		VARCHAR(30) NOT NULL COMMENT '결제방법',
    total_amount 	INT NOT NULL COMMENT '결제금액',
    CONSTRAINT pk_order_order_number PRIMARY KEY (order_number),
    CONSTRAINT fk_order_id FOREIGN KEY (id) REFERENCES tbl_member (id)
) ENGINE=INNODB COMMENT '주문';

-- 4. 상품 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_goods
(
    order_number VARCHAR(12) NOT NULL COMMENT '주문번호',
    goods VARCHAR(6) NOT NULL COMMENT '상품', 
    goods_count INT NOT NULL COMMENT '수량',
    CONSTRAINT pk_goods_order_number PRIMARY KEY (order_number, goods),
    CONSTRAINT fk_goods_order_number FOREIGN KEY (order_number) REFERENCES tbl_order (order_number)
) ENGINE=INNODB COMMENT '상품';

-- 데이터 삽입
INSERT INTO tbl_member VALUES ('ehdghks', '김동환', 26, 'ehdghks123', 20000, 1);
INSERT INTO tbl_member VALUES ('wlsdn', '이진우', 26, 'wlsdn123', 15000, 1);
INSERT INTO tbl_member VALUES ('tjfls', '이서린', 21, 'tjfls123', 5000, 1);

INSERT INTO tbl_payment_method VALUES ('삼성', 0.05);
INSERT INTO tbl_payment_method VALUES ('국민', 0.07);
INSERT INTO tbl_payment_method VALUES ('농협', 0.03);
INSERT INTO tbl_payment_method VALUES ('신한', 0.01);
INSERT INTO tbl_payment_method VALUES ('현금', 0);





commit;