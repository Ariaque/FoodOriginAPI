CREATE TABLE IF NOT EXISTS foodOrigin_label (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_certification (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_typeTransformateur (
    id SERIAL NOT NULL,
    libelle VARCHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_infosTransformateur (
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
    PRIMARY KEY (id),
    FOREIGN KEY (fk_transformateur) REFERENCES foodOrigin_transformateur (id),
    FOREIGN KEY (fk_groupe) REFERENCES foodOrigin_transformateur (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_infosTransformateur_label (
    fk_infos BIGINT UNSIGNED NOT NULL,
    fk_label BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_infos, fk_label),
    FOREIGN KEY (fk_infos) REFERENCES foodOrigin_infosTransformateur (id),
    FOREIGN KEY (fk_label) REFERENCES foodOrigin_label (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_transformateur (
   id SERIAL NOT NULL,
   num_agrement VARCHAR(255) NOT NULL,
   siret VARCHAR (255) NOT NULL,
   raison_sociale VARCHAR (255) NOT NULL,
   adresse VARCHAR (255) NOT NULL,
   code_postal VARCHAR (255) NOT NULL,
   commune VARCHAR (255) NOT NULL,
   categorie VARCHAR (255),
   act_associees VARCHAR (255),
   espece VARCHAR (255),
   latitude VARCHAR (255),
   longitude VARCHAR (255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_role (
    role_id SERIAL NOT NULL,
    name VARCHAR (255) NOT NULL,
    PRIMARY KEY (role_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS foodOrigin_user (
    user_id SERIAL NOT NULL,
    username VARCHAR (250) NOT NULL UNIQUE,
    password VARCHAR (250) NOT NULL,
    fk_transformateur BIGINT UNSIGNED,
    fk_typeT BIGINT UNSIGNED,
    fk_role BIGINT UNSIGNED NOT NULL,
    is_activated TINYINT (1) NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (fk_transformateur) REFERENCES foodOrigin_transformateur (id),
    FOREIGN KEY (fk_typeT) REFERENCES foodOrigin_typeTransformateur (id),
    FOREIGN KEY (fk_role) REFERENCES foodOrigin_role (role_id)
) ENGINE=InnoDB;



