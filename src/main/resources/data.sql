--Fill label table
INSERT INTO foodOrigin_label (libelle) VALUES ('Label Rouge') ON DUPLICATE KEY UPDATE libelle = 'Label Rouge';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Contrôlée AOC') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Contrôlée AOC';
INSERT INTO foodOrigin_label (libelle) VALUES ('Appellation d\'Origine Protégée AOP') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Protégée AOP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Indication Géographique Protégée IGP') ON DUPLICATE KEY UPDATE libelle = 'Indication Géographique Protégée IGP';
INSERT INTO foodOrigin_label (libelle) VALUES ('Spécialité Traditionnelle Garantie STG') ON DUPLICATE KEY UPDATE libelle = 'Spécialité Traditionnelle Garantie STG';
INSERT INTO foodOrigin_label (libelle) VALUES ('Agriculture Biologique AB') ON DUPLICATE KEY UPDATE libelle = 'Agriculture Biologique AB';

--Fill certification table
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 22000') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 22000';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 14001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 14001';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 18001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 18001';
INSERT INTO foodOrigin_certification (libelle) VALUES ('Certification ISO 50001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 50001';


--Fill type_transformateur table
INSERT INTO foodOrigin_typeTransformateur (libelle) VALUES ('Industriel') ON DUPLICATE KEY UPDATE libelle = 'Industriel';
INSERT INTO foodOrigin_typeTransformateur (libelle) VALUES ('Artisan') ON DUPLICATE KEY UPDATE libelle = 'Artisan';