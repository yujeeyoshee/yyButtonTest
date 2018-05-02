pipeline {
    agent any
    environment {
        // Here's an example of global parameter
        ANDROID_HOME = '/Users/yyoshiie/Library/Android/sdk'
    }
    stages {
        stage('Build') {
            steps {
                sh 'pwd'
                sh './gradlew --refresh-dependencies clean assemble'
            }
            post {
                success {
                    echo "Build success! Let's archive the APK"
                    archive '**/*-debug.apk'
                }
                failure {
                    echo 'Build failure :('
                }
            }
        }
    }
    post {
        always {
            echo 'Delete files under workspace dir'
            deleteDir()
        }
        success {
            echo 'All stages successful :)'
        }
        failure {
            echo 'Failed and stopped at one point :('
        }
    }
}
