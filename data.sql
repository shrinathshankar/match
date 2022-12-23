SET DB_CLOSE_DELAY -1;        
;             
CREATE USER IF NOT EXISTS "SA" SALT '258f73464d826b82' HASH '437cc715e6ddf99440c6c7976181fd793aef4c759799355f60559237f9b14b47' ADMIN;         
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_88E25CB3_6677_46A5_B2A9_E5E73DC99453" START WITH 2 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_45B4E41D_C7E9_45AA_BF2A_59FBFF29E36A" START WITH 2 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_D93A6A2A_9459_498F_88E5_B329D63FC8E3" START WITH 85 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3ECAC4DD_67DD_474F_BF28_010E1C4C1996" START WITH 20 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9ACFBD94_FCB9_416D_9CF5_BD76AC278474" START WITH 43 BELONGS_TO_TABLE;               
CREATE MEMORY TABLE "PUBLIC"."LADDERS"(
    "LADDER_ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_45B4E41D_C7E9_45AA_BF2A_59FBFF29E36A" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_45B4E41D_C7E9_45AA_BF2A_59FBFF29E36A",
    "NAME" VARCHAR(255),
    "OWNER_USER_ID" BIGINT
);           
ALTER TABLE "PUBLIC"."LADDERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("LADDER_ID");               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.LADDERS; 
INSERT INTO "PUBLIC"."LADDERS"("LADDER_ID", "NAME", "OWNER_USER_ID") VALUES
(1, 'Hand and Foot', 1);         
CREATE MEMORY TABLE "PUBLIC"."LADDERS_MATCHES"(
    "LADDER_LADDER_ID" BIGINT NOT NULL,
    "MATCHES_MATCH_ID" BIGINT NOT NULL
);          
-- 84 +/- SELECT COUNT(*) FROM PUBLIC.LADDERS_MATCHES;        
INSERT INTO "PUBLIC"."LADDERS_MATCHES"("LADDER_LADDER_ID", "MATCHES_MATCH_ID") VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(1, 37),
(1, 38),
(1, 39),
(1, 40),
(1, 41),
(1, 42),
(1, 43),
(1, 44),
(1, 45),
(1, 46),
(1, 47),
(1, 48),
(1, 49),
(1, 50),
(1, 51),
(1, 52),
(1, 53),
(1, 54),
(1, 55),
(1, 56),
(1, 57),
(1, 58),
(1, 59),
(1, 60),
(1, 61),
(1, 62),
(1, 63),
(1, 64),
(1, 65),
(1, 66),
(1, 67),
(1, 68),
(1, 69),
(1, 70),
(1, 71),
(1, 72),
(1, 73),
(1, 74),
(1, 75),
(1, 76),
(1, 77),
(1, 78),
(1, 79),
(1, 80),
(1, 81),
(1, 82),
(1, 83),
(1, 84);          
CREATE MEMORY TABLE "PUBLIC"."LADDERS_PLAYERS"(
    "LADDER_LADDER_ID" BIGINT NOT NULL,
    "PLAYERS_PLAYER_ID" BIGINT NOT NULL
);         
-- 19 +/- SELECT COUNT(*) FROM PUBLIC.LADDERS_PLAYERS;        
INSERT INTO "PUBLIC"."LADDERS_PLAYERS"("LADDER_LADDER_ID", "PLAYERS_PLAYER_ID") VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19);   
CREATE MEMORY TABLE "PUBLIC"."MATCHES"(
    "MATCH_ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_D93A6A2A_9459_498F_88E5_B329D63FC8E3" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_D93A6A2A_9459_498F_88E5_B329D63FC8E3",
    "TIMESTAMP" VARCHAR(255),
    "TEAM1_TEAM_ID" BIGINT,
    "TEAM2_TEAM_ID" BIGINT,
    "TEAM3_TEAM_ID" BIGINT,
    "WINNER_TEAM_ID" BIGINT
);               
ALTER TABLE "PUBLIC"."MATCHES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("MATCH_ID");
-- 84 +/- SELECT COUNT(*) FROM PUBLIC.MATCHES;
INSERT INTO "PUBLIC"."MATCHES"("MATCH_ID", "TIMESTAMP", "TEAM1_TEAM_ID", "TEAM2_TEAM_ID", "TEAM3_TEAM_ID", "WINNER_TEAM_ID") VALUES
(1, '5/9/2022 21:03:51', 1, 2, NULL, 1),
(2, '5/9/2022 22:33:34', 3, 4, NULL, 3),
(3, '5/12/2022 23:24:34', 5, 6, NULL, 5),
(4, '5/27/2022 17:50:43', 7, 8, NULL, 7),
(5, '5/27/2022 19:00:04', 9, 10, NULL, 9),
(6, '5/28/2022 22:17:36', 6, 5, NULL, 6),
(7, '5/28/2022 23:48:19', 1, 11, NULL, 11),
(8, '5/29/2022 1:12:43', 12, 13, NULL, 12),
(9, '5/29/2022 2:09:05', 13, 12, NULL, 13),
(10, '5/29/2022 18:12:51', 14, 12, NULL, 14),
(11, '5/29/2022 20:29:52', 3, 1, 15, 3),
(12, '5/29/2022 21:45:54', 6, 5, NULL, 5),
(13, '6/4/2022 15:45:43', 4, 6, NULL, 4),
(14, '6/4/2022 16:23:24', 6, 4, NULL, 6),
(15, '6/4/2022 17:09:11', 6, 4, NULL, 6),
(16, '6/4/2022 17:46:04', 6, 4, NULL, 4),
(17, '6/9/2022 20:41:06', 16, 17, NULL, 16),
(18, '6/9/2022 22:32:21', 18, 19, NULL, 18),
(19, '6/10/2022 0:53:02', 20, 21, NULL, 20),
(20, '6/10/2022 17:23:10', 8, 7, NULL, 8),
(21, '6/10/2022 20:52:08', 13, 22, NULL, 13),
(22, '6/10/2022 21:52:15', 7, 8, NULL, 8),
(23, '6/10/2022 22:56:08', 13, 22, NULL, 22),
(24, '7/4/2022 21:55:11', 5, 2, NULL, 2),
(25, '7/4/2022 23:19:19', 5, 2, NULL, 5),
(26, '7/6/2022 19:35:29', 13, 22, NULL, 22),
(27, '7/10/2022 1:34:06', 5, 2, NULL, 5),
(28, '7/17/2022 1:07:06', 13, 23, NULL, 13),
(29, '7/17/2022 2:20:08', 3, 5, NULL, 3),
(30, '7/17/2022 3:11:01', 13, 23, NULL, 23),
(31, '7/17/2022 20:26:43', 6, 5, NULL, 6),
(32, '7/17/2022 21:36:31', 13, 12, NULL, 12),
(33, '7/17/2022 22:31:57', 13, 12, NULL, 12),
(34, '8/1/2022 20:28:07', 13, 2, NULL, 13),
(35, '8/13/2022 19:51:57', 13, 15, 24, 15),
(36, '8/13/2022 20:42:49', 13, 12, NULL, 13),
(37, '8/13/2022 21:43:38', 13, 12, NULL, 13),
(38, '8/13/2022 23:02:43', 5, 6, NULL, 6),
(39, '8/14/2022 0:18:17', 12, 13, NULL, 13),
(40, '8/16/2022 22:47:58', 25, 6, NULL, 6),
(41, '8/16/2022 23:42:40', 13, 24, NULL, 13),
(42, '8/17/2022 0:52:08', 25, 6, NULL, 25),
(43, '8/20/2022 16:01:30', 4, 12, NULL, 4),
(44, '8/20/2022 17:29:46', 4, 12, NULL, 4),
(45, '8/20/2022 19:12:09', 5, 6, 26, 26),
(46, '8/21/2022 21:15:49', 27, 6, NULL, 6),
(47, '8/22/2022 18:51:44', 13, 22, NULL, 22),
(48, '8/22/2022 20:38:25', 13, 22, NULL, 22),
(49, '8/28/2022 20:49:16', 5, 6, NULL, 6),
(50, '8/28/2022 22:15:39', 5, 6, NULL, 5),
(51, '9/1/2022 19:59:57', 2, 13, NULL, 13),
(52, '9/1/2022 21:10:37', 13, 2, NULL, 2),
(53, '9/1/2022 22:37:51', 13, 2, NULL, 2),
(54, '9/9/2022 21:39:24', 13, 28, NULL, 28),
(55, '9/21/2022 21:24:31', 13, 22, NULL, 13),
(56, '9/22/2022 21:21:50', 13, 2, NULL, 13),
(57, '9/23/2022 20:26:10', 4, 6, NULL, 6),
(58, '9/23/2022 21:21:38', 4, 6, NULL, 4),
(59, '9/23/2022 22:24:04', 6, 4, NULL, 4),
(60, '9/23/2022 23:18:28', 4, 6, NULL, 6),
(61, '9/24/2022 0:41:11', 4, 6, NULL, 4),
(62, '10/10/2022 20:40:16', 6, 5, NULL, 6),
(63, '10/14/2022 23:37:02', 29, 13, 30, 30),
(64, '10/20/2022 20:08:52', 13, 15, NULL, 15),
(65, '10/23/2022 22:01:47', 7, 31, NULL, 31),
(66, '10/23/2022 22:23:39', 32, 33, NULL, 32),
(67, '10/23/2022 23:33:30', 10, 34, NULL, 10),
(68, '10/24/2022 0:04:24', 33, 32, NULL, 32),
(69, '10/25/2022 22:49:30', 4, 6, 35, 4),
(70, '10/26/2022 0:00:11', 35, 6, NULL, 6),
(71, '11/5/2022 23:57:47', 13, 22, NULL, 13),
(72, '11/8/2022 19:47:17', 4, 6, 36, 6),
(73, '11/19/2022 21:46:59', 13, 22, NULL, 13),
(74, '11/25/2022 15:37:36', 37, 38, NULL, 37),
(75, '11/25/2022 16:31:47', 6, 4, NULL, 6),
(76, '11/25/2022 18:29:39', 6, 2, NULL, 6),
(77, '11/26/2022 21:39:23', 39, 6, NULL, 39),
(78, '11/26/2022 22:42:59', 39, 6, NULL, 6),
(79, '11/26/2022 23:44:36', 39, 6, NULL, 6),
(80, '11/27/2022 0:43:39', 39, 6, NULL, 39),
(81, '11/27/2022 1:26:30', 39, 6, NULL, 39),
(82, '11/27/2022 22:07:36', 13, 40, NULL, 40),
(83, '11/27/2022 23:02:31', 13, 40, NULL, 13),
(84, NULL, 41, 42, NULL, 42);          
CREATE MEMORY TABLE "PUBLIC"."PLAYERS"(
    "PLAYER_ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_3ECAC4DD_67DD_474F_BF28_010E1C4C1996" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3ECAC4DD_67DD_474F_BF28_010E1C4C1996",
    "LOSSES" INTEGER,
    "NAME" VARCHAR(255),
    "RATING" DOUBLE,
    "WINS" INTEGER,
    "USER_USER_ID" BIGINT
);          
ALTER TABLE "PUBLIC"."PLAYERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("PLAYER_ID");               
-- 19 +/- SELECT COUNT(*) FROM PUBLIC.PLAYERS;
INSERT INTO "PUBLIC"."PLAYERS"("PLAYER_ID", "LOSSES", "NAME", "RATING", "WINS", "USER_USER_ID") VALUES
(1, 30, 'Jimmy', 410.19, 43, NULL),
(2, 15, 'Shrinath', 349.25, 17, NULL),
(3, 6, 'Taylor', 324.58, 8, NULL),
(4, 13, 'Thomas', 316.4, 12, NULL),
(5, 1, 'Amie', 313.36, 2, NULL),
(6, 0, 'Johnny', 312.11, 1, NULL),
(7, 0, 'Frank', 310.28, 1, NULL),
(8, 3, 'Leia', 307.76, 2, NULL),
(9, 1, 'Sangyop', 301.2, 1, NULL),
(10, 1, 'Freddy', 301.09, 0, NULL),
(11, 2, 'Alex', 293.66, 1, NULL),
(12, 1, 'ThuyMi', 289.72, 0, NULL),
(13, 1, 'Tai', 287.89, 0, NULL),
(14, 8, 'Nicolette', 285.48, 6, NULL),
(15, 20, 'Brittney', 283.87, 14, NULL),
(16, 3, 'Jordan', 275.45, 1, NULL),
(17, 2, 'Emily', 274.91, 0, NULL),
(18, 43, 'Ashley', 243.54, 34, NULL),
(19, 28, 'Jessica', 225.43, 22, NULL);           
CREATE MEMORY TABLE "PUBLIC"."TEAM"(
    "TEAM_ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_9ACFBD94_FCB9_416D_9CF5_BD76AC278474" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9ACFBD94_FCB9_416D_9CF5_BD76AC278474",
    "PLAYER_ONE_PLAYER_ID" BIGINT,
    "PLAYER_TWO_PLAYER_ID" BIGINT
);               
ALTER TABLE "PUBLIC"."TEAM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_27" PRIMARY KEY("TEAM_ID");   
-- 42 +/- SELECT COUNT(*) FROM PUBLIC.TEAM;   
INSERT INTO "PUBLIC"."TEAM"("TEAM_ID", "PLAYER_ONE_PLAYER_ID", "PLAYER_TWO_PLAYER_ID") VALUES
(1, 18, 19),
(2, 4, 2),
(3, 1, 4),
(4, 18, 2),
(5, 18, 15),
(6, 1, 19),
(7, 14, 18),
(8, 1, 3),
(9, 1, 14),
(10, 18, 3),
(11, 15, 1),
(12, 15, 19),
(13, 18, 1),
(14, 1, 2),
(15, 15, 2),
(16, 5, 18),
(17, 19, 17),
(18, 5, 19),
(19, 18, 17),
(20, 6, 1),
(21, 5, 13),
(22, 3, 14),
(23, 15, 4),
(24, 19, 16),
(25, 18, 16),
(26, 4, 2),
(27, 18, 9),
(28, 9, 2),
(29, 10, 4),
(30, 2, 15),
(31, 15, 3),
(32, 1, 8),
(33, 11, 19),
(34, 15, 14),
(35, 15, 8),
(36, 8, 4),
(37, 7, 1),
(38, 18, 12),
(39, 18, 4),
(40, 11, 4),
(41, 18, 2),
(42, 19, 1);             
CREATE MEMORY TABLE "PUBLIC"."USER"(
    "USER_ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_88E25CB3_6677_46A5_B2A9_E5E73DC99453" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_88E25CB3_6677_46A5_B2A9_E5E73DC99453",
    "EMAIL" VARCHAR(255),
    "PASSWORD" VARCHAR(255),
    "USERNAME" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."USER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_27E" PRIMARY KEY("USER_ID");  
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.USER;    
INSERT INTO "PUBLIC"."USER"("USER_ID", "EMAIL", "PASSWORD", "USERNAME") VALUES
(1, 'default', 'password', 'Jimmy');          
CREATE MEMORY TABLE "PUBLIC"."USER_LADDER_LIST"(
    "USER_USER_ID" BIGINT NOT NULL,
    "LADDER_LIST_LADDER_ID" BIGINT NOT NULL
);        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.USER_LADDER_LIST;        
ALTER TABLE "PUBLIC"."USER" ADD CONSTRAINT "PUBLIC"."UK_SB8BBOUER5WAK8VYIIY4PF2BX" UNIQUE("USERNAME");        
ALTER TABLE "PUBLIC"."USER" ADD CONSTRAINT "PUBLIC"."UK_OB8KQYQQGMEFL0ACO34AKDTPE" UNIQUE("EMAIL");           
ALTER TABLE "PUBLIC"."USER_LADDER_LIST" ADD CONSTRAINT "PUBLIC"."UK_MTQT975CV6XXYAST83QAXO9K6" UNIQUE("LADDER_LIST_LADDER_ID");               
ALTER TABLE "PUBLIC"."LADDERS_MATCHES" ADD CONSTRAINT "PUBLIC"."UK_IG20UDS77NS77CB4DIBM06YOW" UNIQUE("MATCHES_MATCH_ID");     
ALTER TABLE "PUBLIC"."MATCHES" ADD CONSTRAINT "PUBLIC"."FKQVSBJU6NDYN7JXD7SA02MBM4T" FOREIGN KEY("WINNER_TEAM_ID") REFERENCES "PUBLIC"."TEAM"("TEAM_ID") NOCHECK;             
ALTER TABLE "PUBLIC"."LADDERS_MATCHES" ADD CONSTRAINT "PUBLIC"."FKMATPY499EH17B95GR8MJCXWV2" FOREIGN KEY("MATCHES_MATCH_ID") REFERENCES "PUBLIC"."MATCHES"("MATCH_ID") NOCHECK;               
ALTER TABLE "PUBLIC"."PLAYERS" ADD CONSTRAINT "PUBLIC"."FKMY2MIFAG66UP9GF8XP2J1GWQP" FOREIGN KEY("USER_USER_ID") REFERENCES "PUBLIC"."USER"("USER_ID") NOCHECK;               
ALTER TABLE "PUBLIC"."USER_LADDER_LIST" ADD CONSTRAINT "PUBLIC"."FK7M03M8JBTP366I0U6FTS7P8RD" FOREIGN KEY("USER_USER_ID") REFERENCES "PUBLIC"."USER"("USER_ID") NOCHECK;      
ALTER TABLE "PUBLIC"."LADDERS" ADD CONSTRAINT "PUBLIC"."FK8LAH7SSXLU4BS56YF8RCITUV9" FOREIGN KEY("OWNER_USER_ID") REFERENCES "PUBLIC"."USER"("USER_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."USER_LADDER_LIST" ADD CONSTRAINT "PUBLIC"."FKHE02F25SMRSO5N3Y6D1VW8K7V" FOREIGN KEY("LADDER_LIST_LADDER_ID") REFERENCES "PUBLIC"."LADDERS"("LADDER_ID") NOCHECK;        
ALTER TABLE "PUBLIC"."MATCHES" ADD CONSTRAINT "PUBLIC"."FKSX3TVL28S995CY3DA1G9S6RBT" FOREIGN KEY("TEAM2_TEAM_ID") REFERENCES "PUBLIC"."TEAM"("TEAM_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."TEAM" ADD CONSTRAINT "PUBLIC"."FKCFFC2VOFLFIP73HR6YLLO19C9" FOREIGN KEY("PLAYER_TWO_PLAYER_ID") REFERENCES "PUBLIC"."PLAYERS"("PLAYER_ID") NOCHECK;     
ALTER TABLE "PUBLIC"."LADDERS_PLAYERS" ADD CONSTRAINT "PUBLIC"."FKNXKT9MJKPJ7A7FKTONO1UVRHN" FOREIGN KEY("LADDER_LADDER_ID") REFERENCES "PUBLIC"."LADDERS"("LADDER_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."LADDERS_MATCHES" ADD CONSTRAINT "PUBLIC"."FKHF08I7TR3WQV3UTOMVTOTV3KW" FOREIGN KEY("LADDER_LADDER_ID") REFERENCES "PUBLIC"."LADDERS"("LADDER_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."TEAM" ADD CONSTRAINT "PUBLIC"."FKER2YJF8VSRV3GSN139J5LX2RC" FOREIGN KEY("PLAYER_ONE_PLAYER_ID") REFERENCES "PUBLIC"."PLAYERS"("PLAYER_ID") NOCHECK;     
ALTER TABLE "PUBLIC"."MATCHES" ADD CONSTRAINT "PUBLIC"."FKI1S41WVGEPTN5TPKPG4LEISVC" FOREIGN KEY("TEAM3_TEAM_ID") REFERENCES "PUBLIC"."TEAM"("TEAM_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."MATCHES" ADD CONSTRAINT "PUBLIC"."FK1RU13LI2GHKPQY9KDAWY78GS5" FOREIGN KEY("TEAM1_TEAM_ID") REFERENCES "PUBLIC"."TEAM"("TEAM_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."LADDERS_PLAYERS" ADD CONSTRAINT "PUBLIC"."FKFS1V0OT7R3PCOIJMT29TDCTD5" FOREIGN KEY("PLAYERS_PLAYER_ID") REFERENCES "PUBLIC"."PLAYERS"("PLAYER_ID") NOCHECK;             
