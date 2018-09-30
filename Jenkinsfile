pipeline {
  agent any
  stages {
    stage('build stage'){
      steps {
        bat 'mvn -f ./person-service clean test' 
      }
    }
  }
}