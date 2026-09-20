pipeline {
    agent any

    triggers {
        githubPush()
    }

    tools {
        jdk 'JDK17'
        maven 'Maven3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Код получен из репозитория.'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Пайплайн успешно завершен!'
        }
        failure {
            echo 'Пайплайн завершился с ошибкой.'
        }
    }
}