create table tcharge
(
    Charge_Code char          not null
        primary key,
    Charge_Name varchar(10)   not null,
    Charge      decimal(6, 2) not null
);

create table tcharge_rule
(
    Func_ID     char        not null,
    Charge_Code char        not null,
    Func_Name   varchar(10) not null,
    primary key (Func_ID, Charge_Code),
    constraint FK_TCHARGE_RELATIONS_TCHARGE
        foreign key (Charge_Code) references tcharge (Charge_Code)
);

create table tcustomer
(
    Customer_ID       int(8)      not null
        primary key,
    ID_Type           char        not null,
    ID_Number         varchar(20) not null,
    Customer_Name     varchar(20) not null,
    Customer_Birthday date        not null,
    Customer_Sex      char(2)     not null,
    Customer_Address  varchar(50) not null
);

create table tmobile
(
    Mobile_Number varchar(11) not null
        primary key,
    Mobile_Type   char(3)     not null,
    Card_Number   varchar(13) not null,
    Is_Available  char        not null
);

create table toperator
(
    Operator_ID   char(10)    not null
        primary key,
    Operator_Name varchar(20) not null,
    Operator_Pwd  varchar(20) not null,
    Is_Admin      char        not null
);

create table tuser
(
    User_ID        int(8)      not null
        primary key,
    Account_ID     int(8)      not null,
    Mobile_Number  varchar(11) not null,
    Customer_ID    int(8)      not null,
    Roaming_Status char        not null,
    Com_Level      char        not null,
    constraint FK_TUSER_RELATIONS_TCUSTOMER
        foreign key (Customer_ID) references tcustomer (Customer_ID),
    constraint FK_TUSER_RELATIONS_TMOBILES
        foreign key (Mobile_Number) references tmobile (Mobile_Number)
);

create table taccount
(
    Account_ID      int(8)         not null
        primary key,
    Contact_Person  varchar(10)    not null,
    Contact_Address varchar(50)    not null,
    Account_Balance decimal(10, 2) null,
    constraint FK_TACCOUNT_RELATIONS_TUSER
        foreign key (Account_ID) references tuser (Account_ID)
);

create index FK_TACCOUNT_RELATIONS_TUSER
    on tuser (Account_ID);
