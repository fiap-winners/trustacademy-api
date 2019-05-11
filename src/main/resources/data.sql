INSERT INTO institutes(id, name, code, created_at, modified_at) VALUES
  (1001, 'Faculdade de Informática e Administração Paulista', 'FIAP', GETDATE(), GETDATE());

INSERT INTO departments(id, name, code, institute_id, created_at, modified_at) VALUES
  (1001, 'FIAP ON', 'FIAPON', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1002, 'FIAP OFF', 'FIAPOFF', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO courses(id, name, department_id, created_at, modified_at) VALUES
  (1001, 'Análise e Desenvolvimento de sistemas', 1001, GETDATE(), GETDATE()),
  (1002, 'Marketing Digital', 1001, GETDATE(), GETDATE()),
  (1003, 'Engenharia da Computação', 1002, GETDATE(), GETDATE()),
  (1004, 'Engenharia de Produção', 1002, GETDATE(), GETDATE());

INSERT INTO students(id, name, institute_id, created_at, modified_at) VALUES
  (1001, 'Henrique Lopes', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1002, 'Leonardo Cristofani', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1003, 'Mauricio Carvalho', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1004, 'Pedro Silva', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1005, 'Tiago Silvino', 1001, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO document_types(id, name, institute_id, created_at, modified_at) VALUES
  (1001, 'Histórico Escolar', 1001, GETDATE(), GETDATE()),
  (1002, 'Comprovante de Matrícula', 1001, GETDATE(), GETDATE()),
  (1003, 'Certificado de Conclusão', 1001, GETDATE(), GETDATE());

INSERT INTO documents(id, student_id, institute_id, department_id, course_id, document_type_id, content, created_at, modified_at) VALUES
  (1001, 1001, 1001, 1001, 1001, 1001, 'Conteúdo a v1', GETDATE(), GETDATE()),
  (1002, 1001, 1001, 1001, 1001, 1001, 'Conteúdo a v2', GETDATE(), GETDATE()),
  (1003, 1002, 1001, 1001, 1001, 1002, 'Conteúdo b v1', GETDATE(), GETDATE()),
  (1004, 1002, 1001, 1001, 1001, 1002, 'Conteúdo b v2', GETDATE(), GETDATE()),
  (1005, 1002, 1001, 1001, 1001, 1002, 'Conteúdo b v3', GETDATE(), GETDATE());
