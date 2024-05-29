# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/go/dockerfile-reference/

# Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7

################################################################################

# Create a stage for resolving and downloading dependencies.
ARG tomcat_version=10.1.24
FROM tomcat:${tomcat_version}-jre21

WORKDIR /usr/local/tomcat/webapps/mywebbapp

ADD . .
USER root

EXPOSE 8080
