pipeline {
    agent any

   

    stages {
         stage('Checkout'){
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
             
              	dir('/var/lib/jenkins/workspace/ehealth-app/E-Health-App/backend/E-Health-Backend (1)/E-Health-Backend') {

                sh "mvn compile"
                
                echo 'Building project with maven compile'

		}
            }
        }
        stage ('Test') {
            steps {
                dir('/var/lib/jenkins/workspace/ehealth-app/E-Health-App/backend/E-Health-Backend (1)/E-Health-Backend') {
                sh "mvn test"
                
                echo "Testing the project with maven test"
		}
		}
        }
        stage ('Deloy'){
            steps{
                dir('/var/lib/jenkins/workspace/ehealth-app/E-Health-App/backend/E-Health-Backend (1)/E-Health-Backend') {
                sh "mvn package"
                
                echo "Deloying project with maven package"
            }
        }
	}
       
        
        stage ('Docker Login'){
	    environment {
		    DOCKER_USERNAME = 'jencren81'
		    DOCKER_PASSWORD = 'ThisIsMakingMyHeadHurt23!'
            steps{
              
                sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                }
            }
        }
        
       

	stage ('Dock Deploy'){
            steps{
                
                sh "docker-compose up --build -d:${BUILD_NUMBER}"
                

            }
        }
	
	stage ('Archiving'){
            steps{
                
                archiveArtifcacts "**/target/*.jar"

            }
        }
            
        
    }
}
