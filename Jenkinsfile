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
        def remote = [:]
            remote.name = 'test'
            remote.host = '192.168.31.20'
            remote.user = 'root'
            remote.password = 'root'
            remote.allowAnyHosts = true
        stage('启动应用') {
            sshPut remote: remote, from: 'target/jenkins-app.jar', into: '/root/app'
            sshCommand remote: remote, command: "nohup java -jar target/jenkins-app.jar&"
        }
    }
}
