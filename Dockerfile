# Utilise l'image de base adoptopenjdk avec OpenJDK 17
FROM adoptopenjdk:17-jdk-hotspot

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier JAR de l'application dans le conteneur
COPY target/medhead-0.0.1-SNAPSHOT.jar app.jar

# Expose le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Démarre l'application lorsque le conteneur est lancé
CMD ["java", "-jar", "app.jar"]
