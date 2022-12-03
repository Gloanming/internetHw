create table usersinformation
(
    userName varchar(45),
    userPwd varchar(45),
    userID varchar(45) PRIMARY KEY,
    avatarUrl varchar(45),
    userCreditIndex int default 100,
    userSex varchar(45) default 'man'
)