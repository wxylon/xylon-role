/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2010-9-7 16:12:20                            */
/*==============================================================*/



-- Type package declaration
create or replace package PDTypes  
as
    TYPE ref_cursor IS REF CURSOR;
end;

-- Integrity package declaration
create or replace package IntegrityPackage AS
 procedure InitNestLevel;
 function GetNestLevel return number;
 procedure NextNestLevel;
 procedure PreviousNestLevel;
 end IntegrityPackage;
/

-- Integrity package definition
create or replace package body IntegrityPackage AS
 NestLevel number;

-- Procedure to initialize the trigger nest level
 procedure InitNestLevel is
 begin
 NestLevel := 0;
 end;


-- Function to return the trigger nest level
 function GetNestLevel return number is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 return(NestLevel);
 end;

-- Procedure to increase the trigger nest level
 procedure NextNestLevel is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 NestLevel := NestLevel + 1;
 end;

-- Procedure to decrease the trigger nest level
 procedure PreviousNestLevel is
 begin
 NestLevel := NestLevel - 1;
 end;

 end IntegrityPackage;
/


drop trigger "tib_student"
/

drop table STUDENT cascade constraints
/

drop sequence STUDENT_SEQ
/

create sequence STUDENT_SEQ
/

/*==============================================================*/
/* Table: STUDENT                                               */
/*==============================================================*/
create table STUDENT  (
   ID                   number(10)                      not null,
   NAME                 VARCHAR2(32)                    not null,
   C_DATE               DATE                            not null,
   SPECIALITY           VARCHAR2(64)                    not null,
   SEX                  VARCHAR2(1)                     not null,
   AGE                  NUMBER(3)                       not null,
   constraint PK_STUDENT primary key (ID)
)
/

comment on table STUDENT is
'ѧ����'
/

comment on column STUDENT.ID is
'ѧ��'
/

comment on column STUDENT.NAME is
'����'
/

comment on column STUDENT.C_DATE is
'��ѧʱ��'
/

comment on column STUDENT.SPECIALITY is
'רҵ'
/

comment on column STUDENT.SEX is
'�Ա�'
/

comment on column STUDENT.AGE is
'����'
/


create trigger "tib_student" before insert
on STUDENT for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "ID" uses sequence STUDENT_SEQ
    select STUDENT_SEQ.NEXTVAL INTO :new.ID from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/

