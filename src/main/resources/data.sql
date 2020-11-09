--Fill label table
INSERT INTO label (libelle) VALUES ('Label Rouge') ON DUPLICATE KEY UPDATE libelle = 'Label Rouge';
INSERT INTO label (libelle) VALUES ('Appellation d\'Origine Contrôlée AOC') ON DUPLICATE KEY UPDATE libelle = 'Appellation d\'Origine Contrôlée AOC';
INSERT INTO label (libelle) VALUES ('Appellation \'Origine Protégée AOP') ON DUPLICATE KEY UPDATE libelle = 'Appellation \'Origine Protégée AOP';
INSERT INTO label (libelle) VALUES ('Indication Géographique Protégée IGP') ON DUPLICATE KEY UPDATE libelle = 'Indication Géographique Protégée IGP';
INSERT INTO label (libelle) VALUES ('Spécialité Traditionnelle Garantie STG') ON DUPLICATE KEY UPDATE libelle = 'Spécialité Traditionnelle Garantie STG';
INSERT INTO label (libelle) VALUES ('Agriculture Biologique AB') ON DUPLICATE KEY UPDATE libelle = 'Agriculture Biologique AB';

--Fill certification table
INSERT INTO certification (libelle) VALUES ('Certification ISO 22000') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 22000';
INSERT INTO certification (libelle) VALUES ('Certification ISO 14001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 14001';
INSERT INTO certification (libelle) VALUES ('Certification ISO 18001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 18001';
INSERT INTO certification (libelle) VALUES ('Certification ISO 50001') ON DUPLICATE KEY UPDATE libelle = 'Certification ISO 50001';


--Fill type_transformateur table
INSERT INTO type_transformateur (libelle) VALUES ('Industriel') ON DUPLICATE KEY UPDATE libelle = 'Industriel';
INSERT INTO type_transformateur (libelle) VALUES ('Artisan') ON DUPLICATE KEY UPDATE libelle = 'Artisan';
INSERT INTO type_transformateur (libelle) VALUES ('Transformateur') ON DUPLICATE KEY UPDATE libelle = 'Transformateur';