pipeline {
	agent any


	stages {
       stage('Pull repo')
       {
       steps

	    {
	        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '777a796a-0b7c-4807-aee3-fa451018abc5', url: 'https://github.com/akshunn-singhal/mongodb.git']])
	    }
       }
		stage('Build project'){
			steps
			{
			bat 'D:\\Tools\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin\\mvn clean install -DskipTests'


			}
		}

		 stage('Show docker container') {
        			steps {
        			  echo "show docker"
        			  script
        			  {
        			      bat 'docker ps'
        			  }
        			}
        		}

	    stage('Build docker image') {
			steps {
			  echo "Build image"
			  script
			  {
			      bat 'docker build -t akshunn/mongodb .'
			  }
			}
		}
		stage('Run docker containers') {
            steps {
                // Run Docker Compose to build and start containers
                script {
                   // bat 'docker compose up -d'
                }


            }
        }
        stage('Push image to Hub'){
            steps{

            // withCredentials([string(credentialsId: 'dockerid', variable: 'dockerhubpwd')]) {
               bat 'docker login -u akshunn -p @kshunN@321'
           // }
            // withCredentials([string(credentialsId: 'dockerhubid', variable: 'dockerpwd')]) {
    // some block
    //bat 'docker login -u parmv -p ${dockerpwd}'

//}


                   bat 'docker push akshunn/mongodb'
                }
            }
        }
	}