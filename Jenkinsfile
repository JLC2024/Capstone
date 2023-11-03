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
       
        
     stage('Docker Login') {
    steps {
        script {
            def DOCKER_USERNAME = 'jencren81'
            def DOCKER_PASSWORD = 'ThisIsMakingMyHeadHurt23!'
            
            sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
        }
    }
}

        
	stage ('Dock Deploy') {
    steps {
        dir('/var/lib/jenkins/workspace/ehealth-app/E-Health-App/') {
            sh "docker-compose up --build -d"
        }
    }
}



	
	stage ('Archiving'){
            steps{
                
                archiveArtifcacts "**/target/*.jar"

            }
        }
            
        
    }
}
