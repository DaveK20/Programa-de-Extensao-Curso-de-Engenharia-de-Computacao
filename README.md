# Programa-de-Extensao-Curso-de-Engenharia-de-Computacao
## Equipe

- **Gabi** - Palavra-chave
- **Aline** - Procedência
- **Lucas Picanço Figueiredo** - Material ✅
- **Yan Nascimento Balbi** - Técnica, Unidade Administrativa e Classificação Genérica ✅
- **Rafael da Silva Rodrigues** - Tipo de patrimônio
- **Edivan** - Tipo de imagem ✅
- **Ayrton** - Formas de aquisição e Aquisição ✅
- **Árlisson** - Autor ✅
- **João Pedro Silveira da Silva** - Nome alternativo✅
- **Davi** - Imagem
- **Halisson José Soares da Rocha** - Patrimônio ✅

## Exemplo de SQL insertion
```sql
-- Inserindo em `tipo_patrimonio`
INSERT INTO `patrimonio`.`tipo_patrimonio` (`nome_tipo_patrimonio`) VALUES ('Livro');

-- Inserindo em `unidade_administrativa`
INSERT INTO `patrimonio`.`unidade_administrativa` (`sigla`, `nome`) VALUES ('SIGLA', 'Nome Unidade Administrativa');

-- Inserindo em `classificacao_generica`
INSERT INTO `patrimonio`.`classificacao_generica` (`nome`, `descricao`) VALUES ('Classificação Generica', 'Descrição Generica');

-- Inserindo em `patrimonio`
INSERT INTO `patrimonio`.`patrimonio` (`observacoes`, `numero_de_identificacao`, `pesquisa_museologica`, `tema`, `catalogacao`, `tombo`, `movimento`, `inventario_museologico`, `inventario_patrimonial`, `informacao_data`, `pais`, `estado`, `cidade`, `cep`, `local_guardado`, `assinatura`, `titulo`, `tipo_patrimonio_id`, `unidade_administrativa_id`, `classificacao_generica_id`) VALUES ('Observações', 123456, 'Pesquisa Museológica', 'Tema', 123, 123456, 'Movimento', 123, 123456, 'Informação Data', 'Brasil', 'Estado', 'Cidade', 123456, 'Local Guardado', 'Assinatura', 'Titulo', 1, 1, 1);

-- Inserindo em `pais`
INSERT INTO `patrimonio`.`pais` (`nome`) VALUES ('Brasil');

-- Inserindo em `estado`
INSERT INTO `patrimonio`.`estado` (`nome`, `sigla`) VALUES ('Estado', 'EST');

-- Inserindo em `cidade`
INSERT INTO `patrimonio`.`cidade` (`nome`) VALUES ('Cidade');

-- Inserindo em `procedencia`
INSERT INTO `patrimonio`.`procedencia` (`data`, `patrimonio_id`, `pais_id`, `estado_id`, `cidade_id`) VALUES ('2023-07-16', 1, 1, 1, 1);

-- Inserindo em `autor`
INSERT INTO `patrimonio`.`autor` (`nome`, `biografia`) VALUES ('Autor', 'Biografia');

-- Inserindo em `forma_aquisicao`
INSERT INTO `patrimonio`.`forma_aquisicao` (`tipo`) VALUES ('Tipo Aquisição');

-- Inserindo em `aquisicao`
INSERT INTO `patrimonio`.`aquisicao` (`data`, `patrimonio_id`, `forma_aquisicao_id`) VALUES ('2023-07-16', 1, 1);

-- Inserindo em `tipo_imagem`
INSERT INTO `patrimonio`.`tipo_imagem` (`largura`, `altura`, `descricao`) VALUES (800, 600, 'Descrição Imagem');

-- Inserindo em `imagem`
INSERT INTO `patrimonio`.`imagem` (`nome`, `data`, `arquivo`, `tipo_imagem_id`, `patrimonio_id`) VALUES ('Imagem', '2023-07-16', '0xFFD8FFE0', 1, 1);

-- Inserindo em `material`
INSERT INTO `patrimonio`.`material` (`nome`) VALUES ('Material');

-- Inserindo em `nome_alternativo`
INSERT INTO `patrimonio`.`nome_alternativo` (`nome_alternativo`, `autor_id`) VALUES ('Nome Alternativo', 1);

-- Inserindo em `palavra_chave`
INSERT INTO `patrimonio`.`palavra_chave` (`palavra_chave`, `patrimonio_id`) VALUES ('Palavra Chave', 1);

-- Inserindo em `patrimonio_has_autor`
INSERT INTO `patrimonio`.`patrimonio_has_autor` (`patrimonio_id`, `autor_id`) VALUES (1, 1);

-- Inserindo em `patrimonio_has_material`
INSERT INTO `patrimonio`.`patrimonio_has_material` (`patrimonio_id_patrimonio`, `material_id_material`) VALUES (1, 1);
```
