# Usa una imagen base con Java (por ejemplo, OpenJDK 17)
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR "repaqueteado" que Maven creó en el paso anterior
# El nombre del JAR debe coincidir con el que produce tu build de Maven (users-0.0.1-SNAPSHOT.jar)
COPY target/users-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación Spring Boot escuchará (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java","-jar","app.jar"]
