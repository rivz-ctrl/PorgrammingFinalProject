Final Project

Description:
Student file management system allowing the creation of said file and assigning to it:  a student name, a studentId, a gender, a course, said course's department, assignments and their scores. 
Also, allows the creation, storage and display of academic records (scores) of registered students.

Classes:
- "Department" class: represents the area of studies of the student(Computer Science, Mathematics, etc.)
- "Student" class: represents a student and allows them to register to or drop courses
- "Course" class: represents a course part of a department and manages registered students, course assignments, student scores
- "Assignment" class: represents the assignments within a course and stores the students' scores 
- "Address" class: represents a student's address and verifies the validity of his postal code
- Enums: Gender - restricts gender options to MALE and FEMALE
         Province - restricts province options to Canadian provinces
- "Util" class: handles string formatting