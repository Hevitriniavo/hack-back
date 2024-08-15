# Utiliser une image de base officielle avec Java
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le wrapper Gradle et les fichiers du projet
COPY gradlew /app/
COPY gradle /app/gradle
COPY build.gradle /app/
COPY settings.gradle /app/
COPY src /app/src

# Donner les permissions d'exécution au wrapper Gradle
RUN chmod +x gradlew

# Construire le projet
RUN ./gradlew clean build -x check -x test --info

# Exposer le port sur lequel l'application fonctionne
EXPOSE 8080

# Définir la commande par défaut pour exécuter l'application
CMD ["java", "-jar", "build/libs/hack-back-0.0.1-SNAPSHOT.jar"]