select * from student t

delete from student;

truncate table student;

insert into student values(STUDENT_SEQ.NEXTVAL, 'wang'||STUDENT_SEQ.NEXTVAL, sysdate, 'a','a',10);

declare
ndate date;
begin
     select t.c_date into ndate from student t where t.name = 'wang47' for update of t.c_date;
     if ndate < sysdate then
        update student t set t.c_date = sysdate where t.name = 'wang47';
     end if;
     commit;
     exception
              when others then
                   dbms_output.put_line('³ö´í'||sqlerrm);
end;

 
