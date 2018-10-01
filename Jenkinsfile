pipeline {
  agent any
  stages {
    stage('compile'){
      steps {
        bat 'mvn -f ./person-service clean compile' 
      }
    }
	stage('test'){
      steps {
        bat 'mvn -f ./person-service test' 
      }
    }
	stage('make artifact'){
      steps {
        bat 'mvn -f ./person-service package -Dmaven.test.skip=true' 
      }
    }
  }
}