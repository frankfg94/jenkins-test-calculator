# we are extending everything from glassfish ...

FROM glassfish:latest

MAINTAINER François "francoisgillioen@live.fr"

ADD target/jee-project-Version2-1.0-SNAPSHOT.war jee-project-Version2-1.0-SNAPSHOT.war


# tell docker what port to expose
EXPOSE 8000

# doesn't work and i don't know why
#CMD ["java", "-jar", "/jee-project-Version2-1.0-SNAPSHOT.war"]
