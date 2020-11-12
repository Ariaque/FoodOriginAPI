--Fill foodOrigin_label table
INSERT INTO foodOrigin_label (libelle) VALUES ('Label Rouge') ON DUPLICATE KEY UPDATE libelle = 'Label Rouge';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Contrôlée AOC') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Contrôlée AOC';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Protégée AOP') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Protégée AOP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Indication Géographique Protégée IGP') ON DUPLICATE KEY UPDATE libelle = 'Indication Géographique Protégée IGP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Spécialité Traditionnelle Garantie STG') ON DUPLICATE KEY UPDATE libelle = 'Spécialité Traditionnelle Garantie STG';
INSERT INTO foodOrigin_label (libelle) VALUES ('Agriculture Biologique AB') ON DUPLICATE KEY UPDATE libelle = 'Agriculture Biologique AB';
INSERT INTO foodOrigin_label (libelle) VALUES ('Bio Cohérence') ON DUPLICATE KEY UPDATE libelle = 'Bio Cohérence';
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

--Fille foodOrigin_user table
---INSERT INTO foodOrigin_user (username, password, is_activated, fk_role) VALUES ('admin', 'admin', true, 1) ON DUPLICATE KEY UPDATE username = 'admin'; --Encrypt le mot de passe