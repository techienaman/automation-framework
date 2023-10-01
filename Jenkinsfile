pipeline{
    agent any

    stages{
        stage("Build Jar"){
            steps{
                sh "mvn clean package -DskipTests"
            }
        }

        stage ("Build Image"){
            steps{
               sh "docker build -t=kummayan/selenium ."
            }
        }
        stage('Push Image'){
        environment{
        DOCKER_HUB=credentials("docker_hub_creds")
        }
            steps{
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh "docker push kummayan/selenium"
            }
        }
    }
}