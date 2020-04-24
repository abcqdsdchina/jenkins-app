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
                sh 'mvn clean package wagon:upload-single'
            }
        }
        stage('启动应用') {
            steps {
                script {
                    def remote = [:]
                        remote.name = '192.168.31.20'
                        remote.host = '192.168.31.20'
                        remote.user = 'root'
                        remote.password = 'root'
                        remote.allowAnyHosts = true
                    sshCommand remote: remote, command: "java -jar /root/app/jenkins-app.jar &"
                }
            }
        }
    }
}
