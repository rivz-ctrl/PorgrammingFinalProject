Final Project

Student file management system allowing the creation of said file and assigning to it:  a student name, a studentId, a gender, a course, said course's department, assignments and their scores. 
Also, allows the creation, storage and display of academic records (scores) of registered students.

- "Department" class: represents the area of studies of the student(Computer Science, Mathematics, etc.)
- "Student" class: represents a student with Identification(studentId),
- "Course" class: represents a course part of a department and manages registered students, assignments, and student averages
- "Assignment" class: represents graded assignments within a course and stores the student(s)'s scores
- "Address" class: represents a student's address and verifies the validity of his postal code
- Enums: Gender - restricts valid options to MALE and FEMALE
         Province - restricts valid options to Canadian provinces
- "Util" class: Contains a string formatting helper method (converts words in strings to title case)