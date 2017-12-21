pipeline {
    agent none
    stages {
        stage('Maven Build') {
            agent {
              docker {
                image 'maven' 
                args '-v /root/.m2:/root/.m2' 
                }
            }            
            steps {
                sh 'mvn clean install'
            }
         }
        stage('Maven package') {
            agent {
              docker {
                image 'maven' 
                args '-v /root/.m2:/root/.m2' 
                }
            }            
            steps {
                sh 'mvn package'
            }
        }
       stage('Create Docker Image') {
           agent any
            steps {
                sh 'pwd'
                sh 'docker cp jenkins01:/jbos/jboss-eap-7.0.0.zip /var/jenkins_home/workspace/SpringBootIntegration-APP'
                sh 'docker-compose -f docker-jenkins-compose.yml up -d --build'
                sh 'sleep 10s'
                sh 'docker inspect springbootmysql | grep "IPAddress"'
                sh 'docker inspect springbootmongorest | grep "IPAddress"'
            }
        }
    }  
}
