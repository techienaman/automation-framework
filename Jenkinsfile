pipeline{
    agent any

    stages{
        stage("Build Jar"){
            steps{
                sh "mvn clean package -DskipTests"
            }
        }

        stage ("Build Image){
            steps{
               sh "docker build -t=-kummayan/selenium ."
            }
        }
        stage('Push Image'){
            steps{
                sh "docker push kummayan/selenium"
            }
        }
    }
}