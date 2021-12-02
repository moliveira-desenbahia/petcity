USE petcity;

INSERT INTO `porte` (`nome`) VALUES ("Pequeno");
INSERT INTO `porte` (`nome`) VALUES ("Medio");
INSERT INTO `porte` (`nome`) VALUES ("Grande");

INSERT INTO `especie` (`nome`) VALUES ("Gato");
INSERT INTO `especie` (`nome`) VALUES ("Cao");
INSERT INTO `especie` (`nome`) VALUES ("Passaro");

INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Vira-lata",1);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Golden Retriever",1);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Pastor Alemao",1);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Pitbull",1);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Rottweiler",1);

INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("vira-lata",2);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Persa",2);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Siames",2);
INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Munchkin",2);

INSERT INTO `raca` (`nome`,`especie_id`) VALUES ("Bem-te-vi",3);

INSERT INTO `pelagem` (`nome`) VALUES ("Branca");
INSERT INTO `pelagem` (`nome`) VALUES ("Preta");
INSERT INTO `pelagem` (`nome`) VALUES ("Preta e branca");
INSERT INTO `pelagem` (`nome`) VALUES ("Marrom");
INSERT INTO `pelagem` (`nome`) VALUES ("Caramelo");

INSERT INTO `pet` (`nome`, `raca_id`,`pelagem_id`,`porte_id`) VALUES ("Tintim",1,5,2);
INSERT INTO `pet` (`nome`, `raca_id`,`pelagem_id`,`porte_id`) VALUES ("Thor",4,2,3);
INSERT INTO `pet` (`nome`, `raca_id`,`pelagem_id`,`porte_id`) VALUES ("Tom",7,3,1);

INSERT INTO `caracteristicas_adicionais` (`pet_id`,`descricao`,`confirmada`) VALUES (1,"O melhor",0);
INSERT INTO `caracteristicas_adicionais` (`pet_id`,`descricao`,`confirmada`) VALUES (2,"Fofo",0);
INSERT INTO `caracteristicas_adicionais` (`pet_id`,`descricao`,`confirmada`) VALUES (3,"Antisocial",0);

INSERT INTO `usuario` (`email`,`senha`) VALUES ("admin@admin.com","senhadificil");
INSERT INTO `usuario` (`email`,`senha`) VALUES ("cidadao@cidadao.com","senhadificil");

INSERT INTO `pessoa` (`nome`, `usuario_id`) VALUES ("Admin",1);
INSERT INTO `pessoa` (`nome`, `usuario_id`) VALUES ("Cidadao",2);

INSERT INTO `tipoocorrencia` (`nome`) VALUES ("Excesso de amor");
INSERT INTO `tipoocorrencia` (`nome`) VALUES ("Animal Perdido");

INSERT INTO `alerta` (`descricao`, `usuario_id`,`tipoocorrencia_id`) VALUES ("Descricao do animal perdido",2,2);

INSERT INTO `ocorrencia` (`descricao`, `pet_id`,`usuario_id`,`tipoocorrencia_id`) VALUES ("Descricao do animal perdido",1,1,1);



