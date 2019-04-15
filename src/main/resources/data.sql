INSERT INTO institutes(id, name, code, created_at, modified_at) VALUES
  (1, 'Faculdade de Informática e Administração Paulista', 'FIAP', GETDATE(), GETDATE());

INSERT INTO departments(id, name, code, institute_id, created_at, modified_at) VALUES
  (1, 'FIAP ON', 'FIAPON', 1, GETDATE(), GETDATE()),
  (2, 'FIAP OFF', 'FIAPOFF', 1, GETDATE(), GETDATE());

INSERT INTO courses(id, name, department_id, created_at, modified_at) VALUES
  (1, 'Análise e Desenvolvimento de sistemas', 1, GETDATE(), GETDATE()),
  (2, 'Marketing Digital', 1, GETDATE(), GETDATE()),
  (3, 'Engenharia da Computação', 2, GETDATE(), GETDATE()),
  (4, 'Engenharia de Produção', 2, GETDATE(), GETDATE());

INSERT INTO students(id, name, institute_id, created_at, modified_at) VALUES
  (1, 'Henrique Lopes', 1, GETDATE(), GETDATE()),
  (2, 'Leonardo Cristofani', 1, GETDATE(), GETDATE()),
  (3, 'Mauricio Carvalho', 1, GETDATE(), GETDATE()),
  (4, 'Pedro Silva', 1, GETDATE(), GETDATE()),
  (5, 'Tiago Silvino', 1, GETDATE(), GETDATE());

INSERT INTO document_types(id, name, institute_id, created_at, modified_at) VALUES
  (1, 'Histórico Escolar', 1, GETDATE(), GETDATE()),
  (2, 'Comprovante de Matrícula', 1, GETDATE(), GETDATE()),
  (3, 'Certificado de Conclusão', 1, GETDATE(), GETDATE());

INSERT INTO documents(id, student_id, institute_id, department_id, course_id, document_type_id, content, created_at, modified_at) VALUES
  (1, 1, 1, 1, 1, 1, 'Conteúdo a v1', GETDATE(), GETDATE()),
  (2, 1, 1, 1, 1, 1, 'Conteúdo a v2', GETDATE(), GETDATE()),
  (3, 2, 1, 1, 1, 2, 'Conteúdo b v1', GETDATE(), GETDATE()),
  (4, 2, 1, 1, 1, 2, 'Conteúdo b v2', GETDATE(), GETDATE()),
  (5, 2, 1, 1, 1, 2, 'Conteúdo b v3', GETDATE(), GETDATE());
