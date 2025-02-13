pipeline {
    agent any 
    stages{
        stage('Pull'){
            steps{
                git branch: 'dev', url: 'https://github.com/mayurmwagh/CDEC-B21-Frontend.git'
            }
        }
        stage('Build'){
            steps{
                sh '''
                    npm install 
                    ng build
                '''
            }
        }
        stage(''){
            steps{
                sh '''
                    aws s3 cp --recursive dist/angular-frontend/ s3://cdec21-frontend-thcbz-frontend-project-bux/
                '''
            }
        }
    }
}