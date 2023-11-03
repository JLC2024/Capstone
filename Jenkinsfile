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
             
              

                sh "./mvnw compile"
                
                echo 'Building project with maven compile'

               
            }
        }
        stage ('Test') {
            steps {
                
                sh "mvn test"
                
                echo "Testing the project with maven test"
            }
        }
        stage ('Deloy'){
            steps{
                
                sh "mvn package"
                
                echo "Deloying project with maven package"
            }
        }
        
       
        
        stage ('Docker Login'){
            steps{
               withCredentials([string(credentialsId: 'DockerId', variable: 'DPWD')]) {
                sh "docker login -u jencren81 -p ${DPWD}"
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
