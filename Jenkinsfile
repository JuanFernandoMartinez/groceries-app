pipeline{
    agent any 
    stages{
        stage("Clean Up"){
            steps {
                deleteDir()
            }
        }
        stage("Clone Repo"){
            steps{
                sh "git clone https://github.com/JuanFernandoMartinez/groceries-app.git"
            }
        }
        stage("Build"){
            steps{
                dir("groceries-app"){
                    sh "docker compose up -d"
                    sh "mvn clean install"
                }
            }
        }

        stage("Test"){
            steps{
                dir("groceries-app"){
                    sh "mvn test"
                }
            }
        }

    }

}