SET FOREIGN_KEY_CHECKS = 0;
DROP Table if exists Users;
Drop Table if exists Squads;
Drop Table if exists Characters;
Drop Table if exists Weapons;
Drop Table if exists squad_chars;
SET FOREIGN_KEY_CHECKS = 1;

create table weapons (
	weapon_id int unsigned not null auto_increment,
    weapon_name varchar(20) not null,
    weapon_rank char not null,
    weapon_wt int unsigned not null,
    weapon_dam int unsigned not null,
    weapon_hit int unsigned not null,
    weapon_crit int unsigned not null,
    primary key (weapon_id)    
    );
    
    create table characters (
	char_pk int unsigned not null auto_increment,
    char_name varchar(40) not null,
    char_hp int unsigned not null,
    char_mgt int unsigned not null,
    char_skl int unsigned not null,
    char_spd int unsigned not null,
    char_lck int unsigned not null,
    char_def int unsigned not null,
    char_res int unsigned not null,
    char_class varchar(20),
    char_con int not null,
    char_weapon_id int unsigned,
    PRIMARY KEY (char_pk),
    FOREIGN KEY (char_weapon_id) references weapons (weapon_id) on delete cascade
	);
   
    Create table Users (
	user_pk int unsigned not null auto_increment,
	user_id varchar(50) not null,
    Primary Key (user_pk)
);

        Create table Squads (
	squad_pk int unsigned not null auto_increment,
    squad_user int unsigned not null,
    squad_name varchar(50) not null,
    PRIMARY KEY (squad_pk),
    FOREIGN KEY (squad_user) REFERENCES users(user_pk)
);
    
     

Create table squad_chars (
	squad_id int unsigned not null,
	char_id int unsigned not null,
    foreign key (squad_id) references squads (squad_pk) on delete cascade,
    foreign key (char_id) references characters (char_pk) on delete cascade
    );
