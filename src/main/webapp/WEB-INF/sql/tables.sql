create table imagnifi_district (
	districtId LONG not null primary key,
	name VARCHAR(75) null,
	number_ INTEGER,
	status BOOLEAN
);

create table imagnifi_farmer (
	farmerId LONG not null primary key,
	organization VARCHAR(75) null,
	orgForm VARCHAR(75) null,
	inn LONG,
	kpp LONG,
	ogrn LONG,
	districtId LONG
);