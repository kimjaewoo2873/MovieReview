INSERT INTO member(name, password) VALUES('JAEWOO123', 'JWASD123@');
INSERT INTO member(name, password) VALUES('YURI1022', 'LALA332@!');

ALTER TABLE movie ALTER COLUMN info_text VARCHAR(2000);

INSERT INTO movie(member_id, title, score, image_url, info_text, open_day, limit_age, genre, country, running_time, company)
VALUES (1,'F1','9.9','/images/f1.png','최고가 되지 못한 전설 VS 최고가 되고 싶은 루키! 한때 주목받는 유망주였지만 끔찍한 사고로 F1®에서 우승하지 못하고 한순간에 추락한 드라이버 ''소니 헤이스''(브래드 피트). 그의 오랜 동료인 ''루벤 세르반테스''(하비에르 바르뎀)에게 레이싱 복귀를 제안받으며 최하위 팀인 APXGP에 합류한다. 그러나 팀 내 떠오르는 천재 드라이버 ''조슈아 피어스''(댐슨 이드리스)와 ''소니 헤이스''의 갈등은 날이 갈수록 심해지고. 설상가상 우승을 향한 APXGP 팀의 전략 또한 번번이 실패하며 최하위권을 벗어나지 못하고 고전하는데··· 빨간 불이 꺼지고 운명을 건 레이스가 시작된다!'
, '2025.06.25', '12세 이상 관람가', '드라마, 액션', '미국', '155분', '워너 브러더스 코리아(주)');
INSERT INTO movie(member_id, title, score, image_url, info_text, open_day, limit_age, genre, country, running_time, company)
VALUES(2, 'Jurassic World', '6.3', '/images/jurassicworld.png', '“가장 위험한 놈들만 여기 남겨진 거야“ 지구 최상위 포식자가 된 공룡들이 인간 세상으로 나온 5년 후, 인간과 공룡의 위태로운 공존이 이어지는 가운데 인류를 구할 신약 개발을 위해 육지, 하늘, 바다를 지배하는 가장 거대한 공룡들의 DNA가 필요하게 된다. 불가능한 미션 수행을 위해 ''조라''(스칼렛 요한슨)와 ''헨리 박사''(조나단 베일리) 그리고 ''던컨''(마허샬라 알리)은 공룡들을 추적하며 지구상에서 가장 위험한 섬에 도착하고 폐쇄된 쥬라기 공원의 연구소가 감추어 온 충격적인 진실을 마주하게 되는데... 새로운 캐스트, 새로운 미션, 새로운 공룡, 지상 최대 블록버스터의 새로운 시작!'
,'2025.07.02', '12세 이상 관람가', '모험, 액션, 스릴러, 공포', '미국', '133분', '유니버설 픽쳐스');
INSERT INTO movie(member_id, title, score, image_url, info_text, open_day, limit_age, genre, country, running_time, company)
VALUES(1, 'SuperMan', '8.7', '/images/superman.png', '세상의 희망인가, 위협인가? ''슈퍼맨''은 오늘도 세계 곳곳의 위협에 맞서 싸우지만, 시민들의 반응은 극과 극으로 갈린다. 한편, ''렉스 루터''는 ''슈퍼맨''을 무너뜨릴 비밀을 손에 넣고 역대 최강의 슈퍼-빌런들과 함께 총 공격에 나선다. ''슈퍼맨''은 첫 패배와 함께 이들의 계속된 공세에 직면하고 모든 것을 바로잡기 위해 슈퍼독 ''크립토''와 함께 맞서게 되는데... 과연 그는 이 전례 없는 위기에서 다시 날아오를 수 있을까? 올여름, 가장 강력한 슈퍼히어로 블록버스터가 온다!'
,'2025.07.09', '12세 이상 관람가', '액션, 모험', '미국', '129분', '워너 브러더스 코리아(주)');

