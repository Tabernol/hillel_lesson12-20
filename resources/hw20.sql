create table my_library (
Id INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
author varchar2(30),
name_of_book varchar2(30));