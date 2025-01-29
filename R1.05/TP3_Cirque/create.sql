CREATE TABLE ARTISTE(
    Surnom varchar(20) primary key,
    Specialite varchar NOT NULL,
    constraint c_specialite CHECK(Specialite IN ('jongleur','clown','acrobate','équilibriste'))
);

CREATE TABLE NUMERO(
    Titre varchar primary key,
    Responsable varchar(20) NOT NULL references ARTISTE(Surnom)
);

CREATE TABLE INTERPRETE(
    Surnom varchar(20) references ARTISTE(Surnom),
    Titre varchar references NUMERO(Titre),
    primary key(Surnom, Titre)
);

CREATE TABLE ACCESSOIRE(
    CodeAcc numeric(3) primary key,
    Type varchar(20) NOT NULL CHECK (Type IN ('ballon','cerceau', 'foulard', 'quilles', 'trapèze', 'corde', 'autre')) DEFAULT 'autre',
    Couleur varchar CHECK (Couleur IN ('blanc', 'noir', 'rouge', 'bleu', 'vert', 'jaune', 'orange', 'violet')),
    ImmatCamion char(9) NOT NULL CHECK(ImmatCamion LIKE '__-___-__')
);

CREATE TABLE UTILISATION(
    CodeAcc numeric(3) references ACCESSOIRE(CodeAcc),
    Surnom varchar(20),
    Titre varchar,
    foreign key(Surnom, Titre) references INTERPRETE(Surnom, Titre),
    primary key(CodeAcc, Surnom, Titre)
);