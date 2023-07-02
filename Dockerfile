# Utilise l'image de base adoptopenjdk avec OpenJDK 17
FROM eclipse-temurin:17

# Définit le répertoire de travail dans le conteneur
RUN mkdir /opt/app

# Copie le fichier JAR de l'application dans le conteneur
COPY target/medhead-0.0.1-SNAPSHOT.jar /opt/app/app.jar

# Expose le port sur lequel l'application Spring Boot écoute
EXPOSE 9000

# Démarre l'application lorsque le conteneur est lancé
CMD ["java", "-jar", "/opt/app/app.jar"]