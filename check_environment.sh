#!/bin/bash

function checkDockerMysqlRunning
{
	local mysqlContainerName="mysqltest"
	docker ps | grep -q $mysqlContainerName
	if [[ $? -ne 0 ]]; then
		echo "Starting MYSQLTest Container"
		docker start $mysqlContainerName
		sleep 10s;
		docker ps | grep -q $mysqlContainerName
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

# check whether mysql docker container is running
checkDockerMysqlRunning