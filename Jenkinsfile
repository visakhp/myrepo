pipeline {
    agent {
        docker {
            image 'maven' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn clean install' 
            }
        }
       stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
       stage('Create Docker Image') {
            steps {
                sh 'docker build -f SpringBootDockerfile -t springbootjenkinsapp .'
                sh 'docker run -it -d --name=springbootapp:${env.BUILD_NUMBER} springbootjenkinsapp'
                sh 'sleep 10s'
                sh 'docker inspect springbootapp:${env.BUILD_NUMBER}'
            }
        }
    }  
}
