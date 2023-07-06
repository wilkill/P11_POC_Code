--DROP TABLE IF EXISTS hospital;

CREATE TABLE hospital (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  beds_available INT NOT NULL DEFAULT 0,
  specializations INTEGER ARRAY[20] NOT NULL,
  longitude DOUBLE NOT NULL,
  latitude DOUBLE NOT NULL
  
);

--DROP TABLE IF EXISTS specialization_group;

CREATE TABLE specialization_group (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);  

--DROP TABLE IF EXISTS specialization;

CREATE TABLE specialization (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  specialization_group_id bigint NOT NULL,
  name VARCHAR(255) NOT NULL,
  foreign key (specialization_group_id) references specialization_group(id)
);  

INSERT INTO hospital(name,beds_available,specializations,longitude,latitude) VALUES
  ('Clinique Sainte-Clotilde',22,ARRAY[45],55.478886, -20.902539),
  ('C.H.U NORD BELLEPIERRE',582,ARRAY[45],55.444959, -20.890919),
  ('C.H.U SUD ST PIERRE',582,ARRAY[45],55.493370, -21.346510),
  ('C.H.O ST PAUL',582,ARRAY[45],55.299531, -20.977047),
  ('GHER ST BENOIT',22,ARRAY[45],55.710549, -21.058580);

INSERT INTO specialization_group (id,name) VALUES
  (1,'Anesthésie'),
  (2,'Oncologie clinique'),
  (3,'Groupe dentaire'),
  (4,'Médecine d''urgence'),
  (5,'Groupe de médecine générale'),
  (6,'Obstétrique et gynécologie'),
  (7,'Groupe pédiatrique'),
  (8,'Groupe de pathologie'),
  (9,'Groupe Pronostics et gestion de la santé/Santé communautaire'),
  (10,'Groupe de psychiatrie '),
  (11,'Groupe de radiologie'),
  (12,'Groupe chirurgical');
  
 INSERT INTO specialization (id,specialization_group_id,name) VALUES
 (1,1,'Anesthésie'),
(2,1,'Soins intensifs'),
(3,2,'Oncologie clinique'),
(4,3,'Spécialités dentaires supplémentaires'),
(5,3,'Radiologie dentaire et maxillo-faciale'),
(6,3,'Endodontie'),
(7,3,'Chirurgie buccale et maxillo-faciale'),
(8,3,'Pathologie buccale et maxillo-faciale'),
(9,3,'Médecine buccale'),
(10,3,'Chirurgie buccale'),
(11,3,'Orthodontie'),
(12,3,'Dentisterie pédiatrique'),
(13,3,'Parodontie'),
(14,3,'Prosthodontie'),
(15,3,'Dentisterie restauratrice'),
(16,3,'Dentisterie de soins spéciaux'),
(17,4,'Médecine d''urgence'),
(18,5,'Médecine interne de soins aigus'),
(19,5,'Allergie'),
(20,5,'Médecine audiovestibulaire'),
(21,5,'Cardiologie'),
(22,5,'Génétique clinique'),
(23,5,'Neurophysiologie clinique'),
(24,5,'Pharmacologie clinique et thérapeutique'),
(25,5,'Dermatologie'),
(26,5,'Endocrinologie et diabète sucré'),
(27,5,'Gastroentérologie'),
(28,5,'Médecine générale (interne)'),
(29,5,'Médecine générale'),
(30,5,'Médecine générale (GP) 6 mois'),
(31,5,'Médecine génito-urinaire'),
(32,5,'Médecine gériatrique'),
(33,5,'Maladies infectieuses'),
(34,5,'Oncologie médicale'),
(35,5,'Ophtalmologie médicale'),
(36,5,'Neurologie'),
(37,5,'Médecine du travail'),
(38,5,'Autre'),
(39,5,'Médecine palliative'),
(40,5,'Médecine de réadaptation'),
(41,5,'Médecine rénale'),
(42,5,'Médecine respiratoire'),
(43,5,'Rhumatologie'),
(44,5,'Médecine du sport et de l''exercice'),
(45,6,'Santé publique sexuelle et procréative'),
(46,7,'Cardiologie pédiatrique'),
(47,7,'Pédiatrie'),
(48,8,'Pathologie chimique'),
(49,8,'Neuropathologie diagnostique'),
(50,8,'Histopathologie médico-légale'),
(51,8,'Pathologie générale'),
(52,8,'Hématologie'),
(53,8,'Histopathologie'),
(54,8,'Immunologie'),
(55,8,'Microbiologie médicale'),
(56,8,'Pathologie pédiatrique et périnatale'),
(57,8,'Virologie'),
(58,9,'Service de santé communautaire dentaire'),
(59,9,'Service de santé communautaire médicale'),
(60,9,'Santé publique dentaire'),
(61,9,'Pratique de l’art dentaire'),
(62,9,'Santé publique'),
(63,10,'Psychiatrie infantile et adolescente'),
(64,10,'Psychiatrie légale'),
(65,10,'Psychiatrie générale'),
(66,10,'Psychiatrie de la vieillesse'),
(67,10,'Psychiatrie des troubles d''apprentissage'),
(68,10,'Psychothérapie'),
(69,11,'Radiologie clinique'),
(70,11,'Médecine nucléaire'),
(71,12,'Chirurgie cardiothoracique'),
(72,12,'Chirurgie générale'),
(73,12,'Neurochirurgie'),
(74,12,'Ophtalmologie'),
(75,12,'Otolaryngologie'),
(76,12,'Chirurgie pédiatrique'),
(77,12,'Chirurgie plastique'),
(78,12,'Traumatologie et chirurgie orthopédique'),
(79,12,'Urologie'),
(80,12,'Chirurgie vasculaire');
