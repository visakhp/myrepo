pipeline {
    agent any
    stages {
       stage('Check Maven and Java Version') {       
            steps {
                sh 'mvn -version'
                sh 'java -version'
            }
         }
        stage('Maven Build & Integration Test') {       
            steps {
                sh 'mvn clean install'
            }
         }
        stage('Maven package') {       
            steps {
                sh 'mvn package -DskipTests'
            }
        }
         stage('Copy Jar File') {       
            steps {
                sh 'pwd'
                sh 'cp springboot-consumer-service/target/*.war /springbootintegration_docker_compose'
            }
        }
    }  
}
