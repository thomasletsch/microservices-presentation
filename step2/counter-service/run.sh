#!/usr/bin/env bash
docker run --name counter-service -P --net=host -d step1/counter-service
