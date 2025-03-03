pipeline{
      agent any

      tools{
      gradle 'gradle-6.7.1'
      }

    stages{
        stage('Tarea de limpiezas) {
            steps{
                git 'https://github.com/AlexisZnu/GoogleDriver.git'
                sh 'gradle clean'
               }
    }

    stage('Tarea de compilacion') {
        steps{
            sh 'gradle build'
        }
    }
