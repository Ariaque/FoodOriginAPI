CREATE TABLE IF NOT EXISTS label (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS certification (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS type_transformateur (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS infos_transformateur (
    id SERIAL NOT NULL,
  --  fk_compte BIGINT UNSIGNED, Compte ou transformateur ?
    description VARCHAR (255),
    nombre_employes VARCHAR (255),
    url_site VARCHAR (255),
    url_facebook VARCHAR (255),
    url_twitter VARCHAR (255),
    url_instagram VARCHAR (255),
    appartient_groupe TINYINT (1),
    fk_groupe BIGINT UNSIGNED,
    PRIMARY KEY (id)
   -- CONSTRAINT constraintFkCompte FOREIGN KEY (fk_compte) REFERENCES compte (id)
    --ON DELETE CASCADE ON UPDATE RESTRICT
   -- CONSTRAINT fkGroupe FOREIGN KEY (fk_groupe) REFERENCES transformateur (id)
   -- ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS infos_transformateur_label (
    fk_infos BIGINT UNSIGNED,
    fk_label  BIGINT UNSIGNED,
    PRIMARY KEY (fk_infos, fk_label)
);

ALTER TABLE infos_transformateur_label ADD FOREIGN KEY (fk_infos) REFERENCES infos_transformateur (id);
ALTER TABLE infos_transformateur_label ADD FOREIGN KEY (fk_label) REFERENCES label (id);

--CREATE TABLE IF NOT EXISTS compte (
  --  id SERIAL NOT NULL,
    --username VARCHAR (255) NOT NULL UNIQUE,
    --password VARCHAR (255) NOT NULL,
    --fk_transformateur INT UNSIGNED,
    --fk_typeT BIGINT UNSIGNED,
    --estAdmin TINYINT (1),
    --estActif TINYINT (1),
  --  CONSTRAINT fkTrans FOREIGN KEY (fk_transformateur) REFERENCES transformateur (id)
 --   ON DELETE CASCADE ON UPDATE RESTRICT,
   -- CONSTRAINT fkType FOREIGN KEY (fk_typeT) REFERENCES type_transformateur (id)
   -- ON DELETE CASCADE ON UPDATE RESTRICT,
   -- PRIMARY KEY (id)
--);


--CREATE TABLE IF NOT EXISTS transformateur (
   -- id SERIAL NOT NULL,
   -- num_agrement VARCHAR(255) NOT NULL,
    --siret VARCHAR (255) NOT NULL,
   -- raison_sociale VARCHAR (255) NOT NULL,
   -- adresse VARCHAR (255) NOT NULL,
   -- code_postal VARCHAR (255) NOT NULL,
  --  commune VARCHAR (255) NOT NULL,
   -- categorie VARCHAR (255),
   -- act_associees VARCHAR (255),
   -- espece VARCHAR (255),
   -- latitude VARCHAR (255),
  --  longitude VARCHAR (255)
--);
