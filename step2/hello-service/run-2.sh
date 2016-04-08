#!/usr/bin/env bash
docker run --name hello-service-2 -p 8082:8080 --net=default -d step1/hello-service
