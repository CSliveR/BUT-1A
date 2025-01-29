CREATE TABLE PORT(
    PortID char(1) primary key CHECK(PortID IN ('C','Q','S')),
    PortName varchar NOT NULL,
    Country varchar NOT NULL
);

CREATE TABLE PASSENGER(
    PassengerId int primary key,
    Name varchar NOT NULL,
    Sex varchar NOT NULL,
    Age int,
    Survived int CHECK (Survived IN (0,1)),
    Pclass int NOT NULL CHECK (Pclass IN (1,2,3)),
    PortId char(1) references PORT(PortID)
);

CREATE TABLE OCCUPATION(
    PassengerId int references PASSENGER(PassengerId),
    CabinCode varchar,
    primary key(PassengerId,CabinCode)
);

CREATE TABLE SERVICE(
    PassengerId_Dom int primary key references PASSENGER(PassengerId),
    PassengerId_Emp int NOT NULL references PASSENGER(PassengerId),
    Role varchar NOT NULL
);

CREATE TABLE CATEGORY(
    LifeBoatCat varchar primary key CHECK (LifeBoatCat IN ('standard','secours','radeau')),
    Structure varchar NOT NULL CHECK (Structure IN ('bois','bois et toile')),
    Places int NOT NULL 
);

CREATE TABLE LIFEBOAT(
    LifeBoatId varchar primary key,
    LifeBoatCat varchar references CATEGORY(LifeBoatCat),
    Side varchar NOT NULL CHECK (Side IN ('babord','tribord')) ,
    Position varchar NOT NULL CHECK (Position IN ('avant','arriere')),
    Location varchar NOT NULL DEFAULT 'pont',
    Lauching_Time TIME NOT NULL
);

CREATE TABLE RECOVERY(
    LifeBoatId varchar primary key references LIFEBOAT(LifeBoatId),
    Recovery_Time time NOT NULL
);

CREATE TABLE RESCUE(
    PassengerId int primary key references PASSENGER(PassengerId),
    LifeBoatId varchar NOT NULL references LIFEBOAT(LifeBoatId)
);