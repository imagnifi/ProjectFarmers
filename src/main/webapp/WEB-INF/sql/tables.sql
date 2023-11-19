create table farmer_imagnifi_mapping_shown_district (
	districtId LONG not null,
	farmerId LONG not null,
	primary key (districtId, farmerId)
);

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
	districtNumber LONG,
	registrationDate VARCHAR(75) null,
	archiveStatus BOOLEAN
);