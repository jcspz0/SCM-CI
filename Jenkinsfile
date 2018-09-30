pipeline {
  agent any
  stages {
    stage('build stage'){
      steps {
        bat 'cd person-service'
		bat 'mvn clean test' 
      }
    }
  }
}