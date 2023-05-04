FROM amazoncorreto:11-alpine-jdk //de que imagen partimos
MAINTAINER KarenD //quien es el dueño
COPY target/portfolio-0.0.1-SNAPSHOT.jar karenD-app.jar              //copia empaquetado en git hub
ENTRYPOINT ["java", "-jar","/karenD-app.jar"]                       // instruccion que se va a ejecutar primero
