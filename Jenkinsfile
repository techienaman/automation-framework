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
               sh "docker build -t=-kummayan/selenium ."
            }
        }
        stage('Push Image'){
            steps{
                DOCKER_HUB=credentials("docker_hub_creds")
                sh "docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}"
                sh "docker push kummayan/selenium:latest"
                sh "docker tag kummayank/selenium:latest kummayan/selenium:${BUILD_NUMBER}"
                sh "docker push kummayan/selenium:${BUILD_NUMBER}"
            }
        }
    }
}