pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }
    stages {
        stage('pull') {
            steps {
                git 'https://github.com/abcqdsdchina/jenkins-app.git'
            }
        }
        stage('package') {
            steps {
                sh 'mvn -B clean package'
            }
        }
        stage('publish') {
            steps {
                script {
                    def remote = [:]
                        remote.name = '192.168.31.21'
                        remote.host = '192.168.31.21'
                        remote.user = 'root'
                        remote.password = 'root'
                        remote.allowAnyHosts = true
                    sshPut remote: remote, from: "target/jenkins-app.jar", into: "/root/app/"
                }
            }
        }
    }
}
