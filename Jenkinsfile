pipeline {
    agent any

    stages {
        stage('Tarea de limpiezas') {
            steps {
                git 'https://github.com/AlexisZnu/GoogleDriver.git'
                sh './gradlew clean'
            }
        }

        stage('Tarea de compilacion') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
