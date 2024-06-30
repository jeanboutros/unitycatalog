#!/usr/bin/env bash
set -ex;

container_name="unitycatalog"
network_name="unitycatalog_network"
network_details=$(docker network ls --format '{{json .}}' | jq -r --arg NETWORK_NAME "$network_name" 'select(.Name == $NETWORK_NAME) | .Name')
container_details=$(docker container ls --format '{{json .}}' | jq -r --arg CONTAINER_NAME "$container_name" 'select(.Names == $CONTAINER_NAME) | .Names')
container_runing=$(docker ps --format '{{json .}}' | jq -r --arg CONTAINER_NAME "$container_name" 'select(.Names == $CONTAINER_NAME) | .Names')

# Create the network if it doesn't exist
if [ -z "$network_details" ]; then
    echo "Network $network_name does not exist. Creating it..."
    docker network create $network_name
    echo "Network $network_name created."
else
    echo "Network $network_name already exists, skipping."
fi

if [ -z "$container_details" ]; then
    echo "Container $container_name does not exist. Creating it..."
    
    docker run -v unitycatalog_volume:/opt/unitycatalog \
       --network unitycatalog_network -p 8080:8080 \
       -d --name unitycatalog -t unitycatalogue:0.1.0

    echo "Container $container_name created."
else
    if [ -n "$container_runing" ]; then
        echo "Container $container_name already running, skipping."
    else
        echo "Container $container_name already exists, starting it."
        docker start $container_name
    fi
fi
 
echo "The container $container_name is running with the following parameters:"
docker ps --format '{{json .}}' | jq -r --arg CONTAINER_NAME "$container_name" 'select(.Names == $CONTAINER_NAME)'