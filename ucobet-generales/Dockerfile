FROM openjdk:23-jdk-slim

# Instalar utilidades necesarias para crear usuarios
RUN apt-get update && apt-get install -y \
    sudo curl \
    && rm -rf /var/lib/apt/lists/*

# Crear un grupo y un usuario no privilegiado
RUN groupadd appgroup && useradd -ms /bin/bash -g appgroup appuser

# Crear un volumen y exponer el puerto
VOLUME /tmp
EXPOSE 8443

# Copiar los archivos necesarios
COPY target/ucobet-generales-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/keystore.jks /keystore.jks

# Cambiar el propietario de los archivos a 'appuser'
RUN chown appuser:appgroup app.jar /keystore.jks

# Cambiar al nuevo usuario
USER appuser

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]


