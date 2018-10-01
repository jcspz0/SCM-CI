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
    withSonarQubeEnv('My SonarQube Server') {
      // requires SonarQube Scanner for Maven 3.2+
      bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
  }
}