FROM bellsoft/liberica-openjdk-alpine:11
#Workspace
WORKDIR /home/selenium-docker
#Add the required files
ADD target/docker-resources/ /home/selenium-docker




