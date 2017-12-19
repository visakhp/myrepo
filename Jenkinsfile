pipeline {
  agent {
    docker {
      image 'jenkinstest'
    }
    
  }
  stages {
    stage('build') {
      steps {
        sh 'mvn --version'
      }
    }
  }
}