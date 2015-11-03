SELECT MeetingEmployee.MeetingID AS ID,
       Meeting.name AS Name, 
       Meeting.time AS Time, 
       Meeting.duration AS Duration, 
       GROUP_CONCAT(
       Employee.name, '(', IF(Depart.name IS NULL, 'NULL', Depart.name), ')') AS Party

FROM Employee LEFT JOIN Depart ON Employee.DepartID = Depart.ID 
JOIN MeetingEmployee ON MeetingEmployee.EmployeeID = Employee.ID
JOIN Meeting ON MeetingEmployee.MeetingID = Meeting.ID
GROUP BY MeetingEmployee.MeetingID;
