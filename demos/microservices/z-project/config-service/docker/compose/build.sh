#!/bin/bash

docker-compose -f docker/compose/configservicecompose/docker-compose.yml down

# Clean and package the Maven project
mvn clean
mvn package -Dmaven.test.skip

# Build the Docker image
docker build -f docker/dockerfile/Dockerfile.staged -t img/config-service-1-0-0-staged .

# Start the Docker Compose service
docker-compose -f docker/compose/configservicecompose/docker-compose.yml up -d