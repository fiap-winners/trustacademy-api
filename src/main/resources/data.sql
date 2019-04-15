INSERT INTO institutes (id, name, code, created_at, modified_at) VALUES
(1, 'Paulista Faculty of Computer Science and Business Administration', 'FIAP', GETDATE(), GETDATE()),
(2, 'University of São Paulo', 'USP', GETDATE(), GETDATE());

INSERT INTO departments (id, name, code, institute_id, created_at, modified_at) VALUES
  (1, 'FIAP ON Technology Degrees', 'FIAPON', 1, GETDATE(), GETDATE()),
  (2, 'Institute of Mathematics and Computer Sciences', 'ICMCUSP', 2, GETDATE(), GETDATE()),
  (3, 'Polytechnic School of the University of São Paulo', 'POLIUSP', 2, GETDATE(), GETDATE());

INSERT INTO courses (id, name, department_id, created_at, modified_at) VALUES
  (1, 'System Analysis and Development', 1, GETDATE(), GETDATE()),
  (2, 'Computer Science', 1, GETDATE(), GETDATE());

INSERT INTO students(id, name, institute_id, created_at, modified_at) VALUES
  (1, 'Henrique Lopes', 1, GETDATE(), GETDATE()),
  (2, 'Leonardo Cristofani', 1, GETDATE(), GETDATE()),
  (3, 'Mauricio Carvalho', 1, GETDATE(), GETDATE()),
  (4, 'Pedro Silva', 2, GETDATE(), GETDATE()),
  (5, 'Tiago Silvino', 2, GETDATE(), GETDATE());

INSERT INTO documents(id, student_id, institute_id, department_id, course_id, content, created_at, modified_at) VALUES
  (1, 1, 1, 1, 1, 'Graduate course diploma', GETDATE(), GETDATE()),
  (2, 1, 1, 1, 1, 'Course transcript file', GETDATE(), GETDATE()),
  (3, 2, 1, 1, 1, 'Certificate of regular attendance', GETDATE(), GETDATE());
