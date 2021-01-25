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
INSERT INTO foodOrigin_role (role_id, name) VALUES (1, 'ROLE_ADMIN') ON DUPLICATE KEY UPDATE role_id = 1;
INSERT INTO foodOrigin_role (role_id, name) VALUES (2, 'ROLE_USER') ON DUPLICATE KEY UPDATE role_id = 2;

--Fill foodOrigin_user table
---INSERT INTO foodOrigin_user (username, password, is_activated, fk_role) VALUES ('admin', 'admin', true, 1) ON DUPLICATE KEY UPDATE username = 'admin'; --Encrypt le mot de passe

--Fill foodOrigin_origineDenree table
--Monde
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (1, 'Monde', 'Amérique du Nord') ON DUPLICATE KEY UPDATE id = 1;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (2, 'Monde', 'Amérique du Sud') ON DUPLICATE KEY UPDATE id = 2;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (3, 'Monde', 'Afrique') ON DUPLICATE KEY UPDATE id = 3;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (4, 'Monde', 'Asie') ON DUPLICATE KEY UPDATE id = 4;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (5, 'Monde', 'Océanie') ON DUPLICATE KEY UPDATE id = 5;
--Europe
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (6, 'Europe', 'Albanie') ON DUPLICATE KEY UPDATE id = 6;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (7, 'Europe', 'Allemagne') ON DUPLICATE KEY UPDATE id = 7;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (8, 'Europe', 'Autriche') ON DUPLICATE KEY UPDATE id = 8;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (9, 'Europe', 'Belgique') ON DUPLICATE KEY UPDATE id = 9;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (10, 'Europe', 'Biélorussie') ON DUPLICATE KEY UPDATE id = 10;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (11, 'Europe', 'Bosnie-Herzégovine') ON DUPLICATE KEY UPDATE id = 11;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (12, 'Europe', 'Bulgarie') ON DUPLICATE KEY UPDATE id = 12;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (13, 'Europe', 'Croatie') ON DUPLICATE KEY UPDATE id = 13;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (14, 'Europe', 'Danemark') ON DUPLICATE KEY UPDATE id = 14;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (15, 'Europe', 'Espagne') ON DUPLICATE KEY UPDATE id = 15;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (16, 'Europe', 'Estonie') ON DUPLICATE KEY UPDATE id = 16;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (17, 'Europe', 'Finlande') ON DUPLICATE KEY UPDATE id = 17;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (18, 'Europe', 'Grèce') ON DUPLICATE KEY UPDATE id = 18;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (19, 'Europe', 'Hongrie') ON DUPLICATE KEY UPDATE id = 19;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (20, 'Europe', 'Irlande') ON DUPLICATE KEY UPDATE id = 20;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (21, 'Europe', 'Islande') ON DUPLICATE KEY UPDATE id = 21;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (22, 'Europe', 'Italie') ON DUPLICATE KEY UPDATE id = 22;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (23, 'Europe', 'Kosovo') ON DUPLICATE KEY UPDATE id = 23;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (24, 'Europe', 'Lettonie') ON DUPLICATE KEY UPDATE id = 24;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (25, 'Europe', 'Lituanie') ON DUPLICATE KEY UPDATE id = 25;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (26, 'Europe', 'Macédoine') ON DUPLICATE KEY UPDATE id = 26;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (27, 'Europe', 'Malte') ON DUPLICATE KEY UPDATE id = 27;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (28, 'Europe', 'Moldavie') ON DUPLICATE KEY UPDATE id = 28;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (29, 'Europe', 'Monténégro') ON DUPLICATE KEY UPDATE id = 29;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (30, 'Europe', 'Norvège') ON DUPLICATE KEY UPDATE id = 30;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (31, 'Europe', 'Pays-Bas') ON DUPLICATE KEY UPDATE id = 31;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (32, 'Europe', 'Pologne') ON DUPLICATE KEY UPDATE id = 32;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (33, 'Europe', 'Portugal') ON DUPLICATE KEY UPDATE id = 33;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (34, 'Europe', 'République tchèque') ON DUPLICATE KEY UPDATE id = 34;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (35, 'Europe', 'Roumanie') ON DUPLICATE KEY UPDATE id = 35;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (36, 'Europe', 'Royaume-Uni') ON DUPLICATE KEY UPDATE id = 36;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (37, 'Europe', 'Russie') ON DUPLICATE KEY UPDATE id = 37;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (38, 'Europe', 'Serbie') ON DUPLICATE KEY UPDATE id = 38;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (39, 'Europe', 'Slovaquie') ON DUPLICATE KEY UPDATE id = 39;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (40, 'Europe', 'Slovénie') ON DUPLICATE KEY UPDATE id = 40;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (41, 'Europe', 'Suède') ON DUPLICATE KEY UPDATE id = 41;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (42, 'Europe', 'Suisse') ON DUPLICATE KEY UPDATE id = 42;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (43, 'Europe', 'Ukraine') ON DUPLICATE KEY UPDATE id = 43;

--France
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (44, 'France', 'Auvergne-Rhône-Alpes') ON DUPLICATE KEY UPDATE id = 44;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (45, 'France', 'Bourgogne-Franche-Comté') ON DUPLICATE KEY UPDATE id = 45;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (46, 'France', 'Bretagne') ON DUPLICATE KEY UPDATE id = 46;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (47, 'France', 'Centre-Val de Loire') ON DUPLICATE KEY UPDATE id = 47;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (48, 'France', 'Corse') ON DUPLICATE KEY UPDATE id = 48;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (49, 'France', 'Grand Est') ON DUPLICATE KEY UPDATE id = 49;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (50, 'France', 'Hauts-de-France') ON DUPLICATE KEY UPDATE id = 50;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (51, 'France', 'Ile de France') ON DUPLICATE KEY UPDATE id = 51;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (52, 'France', 'Normandie') ON DUPLICATE KEY UPDATE id = 52;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (53, 'France', 'Nouvelle-Aquitaine') ON DUPLICATE KEY UPDATE id = 53;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (54, 'France', 'Occitanie') ON DUPLICATE KEY UPDATE id = 54;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (55, 'France', 'Pays de la Loire') ON DUPLICATE KEY UPDATE id = 55;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (56, 'France', 'Provence-Alpes-Côte d\'Azur') ON DUPLICATE KEY UPDATE id = 56;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (57, 'France', 'Guadeloupe') ON DUPLICATE KEY UPDATE id = 57;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (58, 'France', 'Martinique') ON DUPLICATE KEY UPDATE id = 58;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (59, 'France', 'Guyane') ON DUPLICATE KEY UPDATE id = 59;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (60, 'France', 'La Réunion') ON DUPLICATE KEY UPDATE id = 60;
INSERT INTO foodOrigin_origineDenree (id, pays, region) VALUES (61, 'France', 'Mayotte') ON DUPLICATE KEY UPDATE id = 61;

--Fill foodOrigin_typeDenree
--Viande
--Bovins
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (1, 'Viande', 'Bovins', 'Boeuf') ON DUPLICATE KEY UPDATE id = 1;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (2, 'Viande', 'Bovins', 'Taureau') ON DUPLICATE KEY UPDATE id = 2;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (3, 'Viande', 'Bovins', 'Vache') ON DUPLICATE KEY UPDATE id = 3;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (4, 'Viande', 'Bovins', 'Genisse') ON DUPLICATE KEY UPDATE id = 4;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (5, 'Viande', 'Bovins', 'Veau') ON DUPLICATE KEY UPDATE id = 5;
--Ovins
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (6, 'Viande', 'Ovins', 'Mouton') ON DUPLICATE KEY UPDATE id = 6;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (7, 'Viande', 'Ovins', 'Agneau') ON DUPLICATE KEY UPDATE id = 7;
--Porcins
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (8, 'Viande', 'Porcins', 'Cochon') ON DUPLICATE KEY UPDATE id = 8;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (9, 'Viande', 'Porcins', 'Porcelet') ON DUPLICATE KEY UPDATE id = 9;
--Caprins
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (10, 'Viande', 'Caprins', 'Chèvre') ON DUPLICATE KEY UPDATE id = 10;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (11, 'Viande', 'Caprins', 'Chevreaux') ON DUPLICATE KEY UPDATE id = 11;
--Gibiers
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (12, 'Viande', 'Gibiers', 'Elevage') ON DUPLICATE KEY UPDATE id = 12;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (13, 'Viande', 'Gibiers', 'Sauvage') ON DUPLICATE KEY UPDATE id = 13;
--Volailles
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (14, 'Viande', 'Volaille', 'Poulet') ON DUPLICATE KEY UPDATE id = 14;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (15, 'Viande', 'Volaille', 'Oie') ON DUPLICATE KEY UPDATE id = 15;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (16, 'Viande', 'Volaille', 'Dinde') ON DUPLICATE KEY UPDATE id = 16;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (17, 'Viande', 'Volaille', 'Canard') ON DUPLICATE KEY UPDATE id = 17;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (18, 'Viande', 'Volaille', 'Pintade') ON DUPLICATE KEY UPDATE id = 18;
--Bovins
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (19, 'Viande', 'Autre', 'Lapin') ON DUPLICATE KEY UPDATE id = 19;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (20, 'Viande', 'Autre', 'Cheval') ON DUPLICATE KEY UPDATE id = 20;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (21, 'Viande', 'Autre', 'Grenouille') ON DUPLICATE KEY UPDATE id = 21;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (22, 'Viande', 'Autre', 'Escargot') ON DUPLICATE KEY UPDATE id = 22;
--Produits de la mer
--Poisson
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (23, 'Produit de la mer', 'Poisson', 'Sauvage') ON DUPLICATE KEY UPDATE id = 23;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (24, 'Produit de la mer', 'Poisson', 'Elevage') ON DUPLICATE KEY UPDATE id = 24;
--Fruit de mer
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (25, 'Produit de la mer', 'Fruit de mer', 'Crustacé') ON DUPLICATE KEY UPDATE id = 25;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (26, 'Produit de la mer', 'Fruit de mer', 'Mollusque') ON DUPLICATE KEY UPDATE id = 26;
--Produit laitier
--Lait
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (27, 'Produit laitier', 'Lait', 'Lait cru') ON DUPLICATE KEY UPDATE id = 27;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (28, 'Produit laitier', 'Lait', 'Lait pasteurisé') ON DUPLICATE KEY UPDATE id = 28;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (29, 'Produit laitier', 'Lait', 'Lait stérilisé') ON DUPLICATE KEY UPDATE id = 29;
--Fromage
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (30, 'Produit laitier', 'Fromage', 'Lait de vache') ON DUPLICATE KEY UPDATE id = 30;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (31, 'Produit laitier', 'Fromage', 'Lait de brebis') ON DUPLICATE KEY UPDATE id = 31;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (32, 'Produit laitier', 'Fromage', 'Lait de chèvre') ON DUPLICATE KEY UPDATE id = 32;
--Oeuf
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (33, 'Oeuf', 'Oeuf', 'Poule en cage') ON DUPLICATE KEY UPDATE id = 33;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (34, 'Oeuf', 'Oeuf', 'Poule au sol') ON DUPLICATE KEY UPDATE id = 34;
INSERT INTO foodOrigin_typeDenree (id, nom, espece, animal) VALUES (35, 'Oeuf', 'Oeuf', 'Poule en plein air') ON DUPLICATE KEY UPDATE id = 35;