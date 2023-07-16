
# P11_POC_Code backend

Description : Ceci est le code du backend de la POC du système d'intervention d'urgence de MedHead 

# Prérequis 

| Type | Version minimun|Commentaire|
|-----:|-----------|----|
|  JAVA| jdk 17    |running|
| Maven| 3.9.1     |compile,running|
| Eclipse|4.28.0   |developpement|

# Compilation et test du code

1 - Cloner le code via le git\
2 - Builder le project avec le goal : mvn clean compile\
3 - Pour tester si c'est le code est fonctionnel avec maven : mvn clean test\
4 - Pour lancer l'application il est possible de le faire avec maven pour une execution local avec le goal : mvn spring-boot:run \
5 - Pour executer l'application sur un autre poste, il suffit d'executer le jar générer dans le dossier target : "medhead-0.0.1-SNAPSHOT.jar" avec la commande : java -jar medhead-0.0.1-SNAPSHOT.jar\
6 - Le serveur sera disponible sur le l'ip du serveur port 9000 : soit en local : [http://localthost](http://127.0.0.1:9000/) ou remplacer localhost par l'ip de la machine\
7 - Chaque api est disponible sur l'url avec le suffix /api/\
8 - Nous utilisons l'api de google pour le calcule de trajet



# Workflow de developpement
1 - Utilisation de GitFlow pour le developpement de la solution avec le modèle suivant :
![Gitflow](https://github.com/wilkill/P11_POC_Code/tree/main/doc/gitflow.png?raw=true)\
2 - Une branche Main pour la release de chaque version\
3 - Une branche Devop pour la gestion du code en test\
4 - Des Branches spécialisées pour chaque feature ou release à publier

# Methode de test unitaire et de stress de la solution
1 - Junit pour tester le lancement du context de spring boot , base de données et lancement API de Google : Résultat disponible ici -> ![Surefire-report](https://github.com/wilkill/P11_POC_Code/tree/main/doc/Test_Application_Report/surefire-reports/)\
2 - JMeter pour tester la montée en charge avec un test de 800 requêtes en une secondes : Résultat disponible ici -> ![Surefire-report](https://github.com/wilkill/P11_POC_Code/tree/main/doc/Test_Application_Report/JMeter/)

# Pipeline Integration continue / Distribution continue (CI/CD)
1 - Utilisation du CI/CD avec GitLab\
2 - A Chaque Version commit et pusher sur le repository gitlab, le process d'integration et de distribution automatique est effectué\
3 - Dans son process, il execute les différents stage : build,test et deploy tout cela dans une instance docker\
4 - Voir le document "gitlab-ci.yml" qui liste les actions et commande pour chaque stage (build,test et deploy).

