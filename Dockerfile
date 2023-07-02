# Utilise l'image de base adoptopenjdk avec OpenJDK 17
FROM eclipse-temurin:17

# Copie le fichier JAR de l'application dans le conteneur
ADD target/medhead-0.0.1-SNAPSHOT.jar app.jar

# Create folder
RUN mkdir /app

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Expose le port sur lequel l'application Spring Boot écoute
EXPOSE 9000

# Démarre l'application lorsque le conteneur est lancé
CMD ["java", "-jar", "/app/app.jar"]