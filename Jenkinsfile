pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }
    stages {
        stage('拉取代码') {
            steps {
                git 'https://github.com/abcqdsdchina/jenkins-app.git'
            }
        }
        stage('打包代码') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('启动应用') {
            steps {
                sh 'java -jar target/jenkins-app.jar'
            }
        }
    }
}
