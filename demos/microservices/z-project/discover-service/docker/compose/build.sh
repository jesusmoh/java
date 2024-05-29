#!/bin/bash

# Clean and package the Maven project
mvn clean
mvn package -Dmaven.test.skip

# Build the Docker image
docker build -f docker/dockerfile/Dockerfile.staged -t img/discover-service-0-0-1-staged .

# Start the Docker Compose service
docker-compose -f docker/compose/discoverservicecompose/docker-compose.yml up -d