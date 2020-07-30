pipeline {

    agent any

    environment {
        PATH = "/usr/local/bin:/usr/local/lib/ruby/gems/2.7.0/bin:/usr/local/opt/ruby/bin:$PATH"
    }

    stages {
        stage('Clean') {
            steps {
                echo '$BROWSERSTACK_USERNAME'
                echo '$BROWSERSTACK_ACCESS_KEY'
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -P ${params.TEST_TYPE}'
            }
        }
    }
}