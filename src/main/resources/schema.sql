CREATE TABLE IF NOT EXISTS label (
    id SERIAL NOT NULL,
    libelle CHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS certification (
    id SERIAL NOT NULL,
    libelle CHAR (255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);


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
