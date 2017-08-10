FROM java:jdk
MAINTAINER Remigijus Kutkaitis <achmudass@gmail.com>
ADD target/readit-1.0-SNAPSHOT.jar /usr/readit/readit-1.0-SNAPSHOT.jar
COPY configuration.yml /usr/readit/
WORKDIR /usr/readit
EXPOSE 34230
CMD java -jar /usr/readit/readit-1.0-SNAPSHOT.jar server configuration.yml