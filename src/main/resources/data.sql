--Fill foodOrigin_label table
INSERT INTO foodOrigin_label (libelle) VALUES ('Label Rouge') ON DUPLICATE KEY UPDATE libelle = 'Label Rouge';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Controlee AOC') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Controlee AOC';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Protegee AOP') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Protegee AOP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Indication Geographique Protegee IGP') ON DUPLICATE KEY UPDATE libelle = 'Indication Geographique Protegee IGP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Specialite Traditionnelle Garantie STG') ON DUPLICATE KEY UPDATE libelle = 'Specialite Traditionnelle Garantie STG';
INSERT INTO foodOrigin_label (libelle) VALUES ('Agriculture Biologique AB') ON DUPLICATE KEY UPDATE libelle = 'Agriculture Biologique AB';
INSERT INTO foodOrigin_label (libelle) VALUES ('Bio Coherence') ON DUPLICATE KEY UPDATE libelle = 'Bio Coherence';
INSERT INTO foodOrigin_label (libelle) VALUES ('Origine France Garantie') ON DUPLICATE KEY UPDATE libelle = 'Origine France Garantie';
INSERT INTO foodOrigin_label (libelle) VALUES ('Viandes de France') ON DUPLICATE KEY UPDATE libelle = 'Viandes de France';


--Fill foodOrigin_certification table
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 22000') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 22000';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 14001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 14001';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 18001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 18001';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 50001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 50001';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification GMP+') ON DUPLICATE KEY UPDATE libelle = 'Certification GMP+';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification HACCP') ON DUPLICATE KEY UPDATE libelle = 'Certification HACCP';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification IFS') ON DUPLICATE KEY UPDATE libelle = 'Certification IFS';


--Fill foodOrigin_typeTransformateur table
INSERT INTO foodOrigin_typeTransformateur (libelle) VALUES ('Industriel') ON DUPLICATE KEY UPDATE libelle = 'Industriel';
INSERT INTO foodOrigin_typeTransformateur (libelle) VALUES ('Artisan') ON DUPLICATE KEY UPDATE libelle = 'Artisan';

--Fill foodOrigin_role table
--INSERT INTO foodOrigin_role (name) VALUES ('ROLE_ADMIN') ON DUPLICATE KEY UPDATE name = 'ROLE_ADMIN';
--INSERT INTO foodOrigin_role (name) VALUES ('ROLE_USER') ON DUPLICATE KEY UPDATE name = 'ROLE_USER';

--Fill foodOrigin_user table
---INSERT INTO foodOrigin_user (username, password, is_activated, fk_role) VALUES ('admin', 'admin', true, 1) ON DUPLICATE KEY UPDATE username = 'admin'; --Encrypt le mot de passe

--Fill foodOrigin_origineDenree table
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (1, 'Monde', 'Amerique du Nord') ON DUPLICATE KEY UPDATE id = 1;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (2, 'Monde', 'Amerique du Sud') ON DUPLICATE KEY UPDATE id = 2;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (3, 'Europe', 'Italie') ON DUPLICATE KEY UPDATE id = 3;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (4, 'Europe', 'Islande') ON DUPLICATE KEY UPDATE id = 4;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (5, 'France', 'Corse') ON DUPLICATE KEY UPDATE id = 5;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (6, 'France', 'Grand Est') ON DUPLICATE KEY UPDATE id = 6;

--Fill foodOrigin_typeDenree
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (1, 'Viande', 'Bovins', 'Boeuf') ON DUPLICATE KEY UPDATE id = 1;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (2, 'Viande', 'Bovins', 'Veau') ON DUPLICATE KEY UPDATE id = 2;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (3, 'Produit de la mer', 'Poisson', 'Sauvage') ON DUPLICATE KEY UPDATE id = 3;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (4, 'Produit de la mer', 'Poisson', 'Elevage') ON DUPLICATE KEY UPDATE id = 4;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (5, 'Produit de la mer', 'Fruit de mer', 'Crustacé') ON DUPLICATE KEY UPDATE id = 5;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (6, 'Produit de la mer', 'Fruit de mer', 'Mollusque') ON DUPLICATE KEY UPDATE id = 6;