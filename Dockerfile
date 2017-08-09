FROM java:jdk
MAINTAINER Remigijus Kutkaitis <achmudass@gmail.com>
ADD target/readit-1.0-SNAPSHOT.jar /usr/readit/readit-1.0-SNAPSHOT.jar
WORKDIR /usr/readit
EXPOSE 34230
CMD java -jar /usr/readit/readit-1.0-SNAPSHOT.jar server configuration.yml