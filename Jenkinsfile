pipeline {
  agent {
    docker {
      image 'maven:3-jdk-8-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Start') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }

  }
}