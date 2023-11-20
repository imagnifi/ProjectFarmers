create index IX_D65DCF0B on farmer_imagnifi_mapping_shown_district (districtId);
create index IX_BD4ECC60 on farmer_imagnifi_mapping_shown_district (farmerId);

create index IX_F4560D51 on imagnifi_district (status);

create index IX_59084144 on imagnifi_farmer (archiveStatus);
create index IX_236DD5EB on imagnifi_farmer (districtNumber);
create index IX_128AFA19 on imagnifi_farmer (inn);
create index IX_F0F18427 on imagnifi_farmer (organization);
create index IX_F6891C12 on imagnifi_farmer (organization, inn);
create index IX_F66F68FB on imagnifi_farmer (registrationDate);