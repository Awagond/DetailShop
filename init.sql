use 4isip182_ejournal;

-- insert into Roles(idRoles, Name) values(0, 'administrator');
-- insert into Roles(idRoles, Name) values(1, 'teacher');
-- insert into Roles(idRoles, Name) values(2, 'student');

insert into `Groups`(idGroups, Name) values(0, 'administrators');
insert into Users_has_Groups(Users_idUsers, Groups_idGroups) values(0, 0);


-- insert into Users(idUsers, Login, Password, Name, RoleId) values (0, 'administrator', '123', 'System Administrator', 0);
