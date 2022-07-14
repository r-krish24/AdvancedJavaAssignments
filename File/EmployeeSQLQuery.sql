
CREATE TABLE EmployeeDetails (
    employee_Id NVARCHAR(10) NULL,
    employee_Name NVARCHAR(150)  NULL,
    email NVARCHAR(150)  NULL,
    phone_number NVARCHAR(15)  NULL,
    hire_Date NVARCHAR(20)  NULL,
    job_Id NVARCHAR(15)  NULL,
    salary NVARCHAR(15)  NULL,
	commission_Pct NVARCHAR(10)  NULL,
	manager_Id NVARCHAR(10)  NULL,
	department_Id NVARCHAR(10)  NULL,
	record_insDate date  NULL,
)
;


select * from EmployeeDetails
select * from EmployeeDetails_Failed

delete from EmployeeDetails
delete from EmployeeDetails_Failed


select * from Employee_Job

select * from Employee_Department

SELECT  emp.employee_Id,emp.employee_Name,emp.email,empj.job_description,[dbo].[get_manager_name](emp.manager_Id) as ManagerName,
--(select employee_Name from EmployeeDetails where emp.employee_Id=emp.manager_Id) managername,
dept.department_desc
   FROM EmployeeDetails emp
   LEFT JOIN Employee_Job empj ON emp.job_Id = empj.job_Id
   Left Join Employee_Department dept on emp.department_Id=dept.department_Id

SELECT  emp.employee_Id,emp.employee_Name,emp.email,empj.job_description,[dbo].[get_manager_name](emp.manager_Id) as ManagerName,
--(select employee_Name from EmployeeDetails where emp.employee_Id=emp.manager_Id) managername,
dept.department_desc
   FROM EmployeeDetails_Failed emp
   left join EmployeeDetails empf on emp.employee_Id=empf.employee_Id
   LEFT JOIN Employee_Job empj ON emp.job_Id = empj.job_Id
   Left Join Employee_Department dept on emp.department_Id=dept.department_Id



USE mavdb

GO
/****** Object:  UserDefinedFunction [dbo].[get_manager_name]    Script Date: 08-07-2022 14:20:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE function [dbo].[get_manager_name](
@mid integer
)
returns varchar(100)
as
begin

   return (select employee_Name from EmployeeDetails where employee_Id=@mid);
end

----------------------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function get_emp_name(
@eid integer
)
returns varchar(100)
as
begin
   return (select employee_Name from EmployeeDetails where employee_Id=@eid);
end







