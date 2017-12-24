#!/bin/bash

# create mysqltest container if not already exists
function createMYSQLTestDockerContainer
{
	docker ps -a | grep -q $MYSQL_CONTAINER_NAME
	if [[ $? -ne 0 ]]; then
		echo "Creating MYSQLTest Container"
		docker-compose -f createmysqltest-container-docker-compose.yml up -d --build
		if [[ $? -eq 0 ]]; then
			echo "MYSQLTest Container Created Successfully..."
	    else
			echo "MYSQLTest Container Creation Failed. Exiting..."
			exit 1;
		fi
     else
		echo "MYSQLTest Container already created..."
     fi
}

# check mysqltest container is running.
function checkMYSQLTestDockerContainerRunning
{
	docker ps | grep -q $MYSQL_CONTAINER_NAME
	if [[ $? -ne 0 ]]; then
		echo "Starting MYSQLTest Container"
		docker start $MYSQL_CONTAINER_NAME
		sleep 10s;
		docker ps | grep -q $MYSQL_CONTAINER_NAME
		if [[ $? -eq 0 ]]; then
			echo "MYSQLTest Container Started Successfully..."
	    else
			echo "MYSQLTest Container Failed to Start. Exiting..."
			exit 1;
		fi	
     else
		echo "MYSQLTest Container Already Running..."
     fi
}

# get the network mode of mysqltest container and use the same for maven node in JenkinsFile
function getMYSQlTestContainerNetwork
{
	rm -f network_mode.txt
	local NETWORK_MODE=$(docker inspect $MYSQL_CONTAINER_NAME | grep "NetworkMode")
	NETWORK_MODE=${NETWORK_MODE#*: }
    NETWORK_MODE=${NETWORK_MODE%,*}
    echo "$NETWORK_MODE" | cut -d '"' -f2 >> network_mode.txt
    chmod 550 network_mode.txt
}

# mysqltest container name
MYSQL_CONTAINER_NAME="mysqltest"

# create mysqltest container if not exists.
createMYSQLTestDockerContainer

# check mysqltest container is running.
checkMYSQLTestDockerContainerRunning

# get the network of mysqltest container
getMYSQlTestContainerNetwork

exit 0;


