pipeline {
  agent any
  stages {
    stage('compile'){
      steps {
        bat 'mvn clean compile' 
      }
    }
	stage('test'){
      steps {
        bat 'mvn test' 
      }
    }
	stage('make artifact'){
      steps {
        bat 'mvn package -Dmaven.test.skip=true' 
      }
    }
  }
}