# Utilise l'image de base adoptopenjdk avec OpenJDK 17
FROM eclipse-temurin:17

WORK /tmp

# Copie le fichier JAR de l'application dans le conteneur
#ADD target/*.jar medhead-0.0.1-SNAPSHOT.jar

# Expose le port sur lequel l'application Spring Boot écoute
EXPOSE 9000

# Démarre l'application lorsque le conteneur est lancé
CMD ["java", "-jar", "medhead-0.0.1-SNAPSHOT.jar"]

