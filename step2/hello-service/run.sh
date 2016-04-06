#!/usr/bin/env bash
docker run --name hello-service -P --net=host -d step1/hello-service
