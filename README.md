--Migrate DB
Windows:
java -jar rss-reader-0.1.0-all.jar db migrate ..\..\configuration.yml

*nix
java -jar rss-reader-0.1.0-all.jar db migrate ../../configuration.yml

--Launch app
java -jar readit-1.0-SNAPSHOT.jar server configuration.yml