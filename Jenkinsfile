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
	stage('SonarQube analysis') {
		// requires SonarQube Scanner 2.8+
		def scannerHome = tool 'sonar runner';
		withSonarQubeEnv('My SonarQube Server') {
		  bat "${scannerHome}/bin/sonar-scanner"
		}
	  }
  }
}