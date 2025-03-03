pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AlexisZnu/GoogleDriver.git'
            }
        }

        stage('Tarea de compilacion') {
            steps {
                bat './gradlew build'
            }
        }
    }
}
