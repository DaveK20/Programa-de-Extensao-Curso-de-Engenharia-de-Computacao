-- -----------------------------------------------------
-- Referente ao Tipo de Acervo do manual de museus utilizado na pesquisa. 
-- Dados b�sicos para isnerir um patrim�nio.
-- Autor: Halisson Jos� Soares da Rocha
-- -----------------------------------------------------

INSERT INTO tipo_patrimonio ( nome_tipo_patrimonio) VALUES("Museol�gico");
INSERT INTO tipo_patrimonio ( nome_tipo_patrimonio) VALUES("Bibliogr�fico");
INSERT INTO tipo_patrimonio ( nome_tipo_patrimonio) VALUES("Pe�as Baixadas");

INSERT INTO unidade_administrativa (sigla, nome) VALUES("MIR", " Museu do Primeiro Reinado");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("MT", "Museu dos Teatros");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("MCM", "Museu Carmem Miranda");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("MAP", "Museu Ant�nio Parreiras");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("MHAERJ", "Museu de Hist�ria e Artes do Estado do Rio de Janeiro");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("COV", "Casa Oliveira Vianna");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("CCA", "Casa de Casimiro de Abreu");
INSERT INTO unidade_administrativa (sigla, nome) VALUES("CEC", "Casa Euclides da Cunha");

INSERT INTO classificacao_generica (nome, descricao) VALUES("Imagem", "Artes Visuais Cinematogr�ficas");

INSERT INTO tecnica (nome) VALUES ("Pintura a oleo");
INSERT INTO tecnica (nome) VALUES ("Cubismo");

INSERT INTO patrimonio (numero_de_identificacao, observacoes, catalogacao, tombo, inventario_museologico, inventario_patrimonial, local_guardado, tipo_patrimonio_id, unidade_administrativa_id, classificacao_generica_id ) VALUES ("123456", "Muito bom estado", "Gr0001", "00210", "80.000.069", "0171", "Exposi��o Permanente � sal�o oval, nicho 1", 1, 2, 1);



