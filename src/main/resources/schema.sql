CREATE TABLE IF NOT EXISTS label (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS certification (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS typeTransformateur (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS infosTransformateur (
    id SERIAL NOT NULL,
    fk_transformateur BIGINT UNSIGNED NOT NULL,
    description VARCHAR (255),
    nombre_employes VARCHAR (255),
    url_site VARCHAR (255),
    url_facebook VARCHAR (255),
    url_twitter VARCHAR (255),
    url_instagram VARCHAR (255),
    appartient_groupe TINYINT (1),
    fk_groupe BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS infosTransformateur_label (
    fk_infos BIGINT UNSIGNED NOT NULL,
    fk_label BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_infos, fk_label)
) ENGINE=InnoDB;

ALTER TABLE infosTransformateur_label ADD CONSTRAINT FOREIGN KEY (fk_infos) REFERENCES infosTransformateur (id);
ALTER TABLE infosTransformateur_label ADD CONSTRAINT FOREIGN KEY (fk_label) REFERENCES label (id);

--ALTER TABLE infosTransformateur ADD CONSTRAINT FOREIGN KEY (fk_transformateur) REFERENCES transformateur (id);
--ALTER TABLE infosTransformateur ADD CONSTRAINT FOREIGN KEY (fk_groupe) REFERENCES transformateur (id);

--CREATE TABLE IF NOT EXISTS users (
    -- user_id SERIAL NOT NULL,
    --username VARCHAR (250) NOT NULL UNIQUE,
    --password VARCHAR (250) NOT NULL,
    --fk_transformateur INT UNSIGNED,
    --fk_typeT BIGINT UNSIGNED,
    --estActif TINYINT (1),
   -- PRIMARY KEY (user_id)
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
