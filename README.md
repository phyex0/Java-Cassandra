# Java-Cassandra
<br>In this project I've tried to implement Apache Cassandra into a Spring Boot application.</br>

<br>Steps to follow:</br>
<br>1-) Install docker into your computer and be sure docker-compose files can be runnable</br>
<br>2-) Run cassandra.yaml file under the docker directory</br>
<br>3-)Connect to Cassandra and create "keyspace-name" named "phyex0". You can use the following command on a database tool:
<br> ==create keyspace phyex0 with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};== </br> </br>
<br>4-) Run the application.</br>
<br>5-) Go to "localhost:8080/swagger-ui.html" and test the application</br>
