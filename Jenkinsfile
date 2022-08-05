pipeline {
    agent any
    stages {
        stage("Clean Up") {
            steps {
                deleteDir()
            }
        }
        stage("Clone Repo") {
            steps {
                sh "git clone https://github.com/OlegKrupenia/questionnaire.git"
            }
        }
        stage("Build") {
            steps {
                dir("app") {
                    sh "mvn clean install"
                }
            }
        }
        stage("Test") {
            steps {
                dir("app") {
                    sh "mvn test"
                }
            }
        }
    }
}