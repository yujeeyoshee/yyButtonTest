pipeline {
    agent any
//    environment {
//        // Here's an example of global parameter
//        ANDROID_HOME = '/Users/yyoshiie/Library/Android/sdk'
//    }
    stages {
        stage('Build App') {
            steps {
                sh './gradlew --refresh-dependencies clean assembleDebug assembleAndroidTest'
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
        stage('AWS device farm unit test') {
            steps {
                sh 'ls app/build/outputs/apk/'
                step([$class: 'AWSDeviceFarmRecorder',
                        projectName: 'SimpleButton',
                        devicePoolName: 'test2-pool',
                        runName: 'jenkins-functional-tests-${BUILD_ID}',
                        appArtifact: 'app/build/outputs/apk/simpleButton-debug.apk',
                        testToRun: 'INSTRUMENTATION',
                        appiumJavaJUnitTest: '',
                        junitArtifact: 'app/build/outputs/apk/yySimpleButton-debug-androidTest.apk',
                        junitFilter: '', 
                        ignoreRunError: false,
                        isRunUnmetered: false,
                        storeResults: true,
                    ])
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
