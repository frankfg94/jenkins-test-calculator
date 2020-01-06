pipeline {
     environment {
     app = null
     registry = 'dockwebphotos/devops-prj-m1'
     image = "${registry}:version-${env.BUILD_ID}"
    }
    agent any
    stages {
        
        stage('Git-Checkout')  {
            steps{
                script{
                last_started = env.STAGE_NAME
                }
                echo "Checking out from Git Repo"
                //git 'https://github.com/BenAzlay/jee-project-Version2.git'
                git 'https://github.com/frankfg94/jenkins-test-calculator'
            }
        }
        
        stage ('Compile Stage') {
            steps {
                script{
                     last_started = env.STAGE_NAME
                }
                bat 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {
            // The tests currently include : 
            // Unit Tests
            // Selenium Tests
            steps {
                script {
                    last_started = env.STAGE_NAME
                }
                bat 'mvn test' 
            }
        }
        
        stage ('Jmeter Stage'){
            steps{
                script {
                    last_started = env.STAGE_NAME
                }
                
                // Jmeter needs to be downloaded and dropped to the folder indicated below
                bat 'c:/jmeter/bin/jmeter.bat -n -t c:/jmeter/extras/Test.jmx -l test.jtl'
                
                // The result will be saved to the base directory of this job
                step([$class: 'ArtifactArchiver', artifacts: '**/*.jtl'])
                }
        }
        
        stage ('Sonarqube Stage'){
            steps{
                script {
                    last_started = env.STAGE_NAME
                }
                
                // A sonar server must be running locally (here on localhost:9000) for this to work
              withSonarQubeEnv('Sonar'){
             bat 'mvn clean install  org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'

              }
        }
    }
        
        stage("Sonar Quality Gate") {
            steps {
                script{
          last_started = env.STAGE_NAME
          Integer waitSeconds = 6
          Integer timeOutMinutes = 10
          Integer maxRetry = (timeOutMinutes * 60) / waitSeconds as Integer
          for (Integer i = 0; i < maxRetry; i++) {
            try {
              timeout(time: waitSeconds, unit: 'SECONDS') {
                 echo "trying to fetch sonarqube response"
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                  error "Sonar quality gate status: ${qg.status}"
                  return
                } else {
                  i = maxRetry
                }
              }
            } catch (Throwable e) {
              if (i == maxRetry - 1) {
                throw e
              }
            }
          }
                }
    
                }
            }
                


        stage ('Deployment Stage') {
            steps {
                bat 'mvn deploy'
                script {   
                last_started = env.STAGE_NAME
                // Docker needs to be running locally for this to work
                app = docker.build(image,'.')
                }
            }
        }
        
        stage ('Deploy to DockerHub') {
              steps {
                     script { 
                     last_started = env.STAGE_NAME
                     docker.withRegistry('', "reg1") {
                      app.push "latest"
                        }
                   }
              }
        }
    }
    post{
            success{
                script{
                        last_started = env.STAGE_NAME
                        def attachments = [
                     
                      [
                        text: 'Pipeline execution is successful',
                        color: '#ff0000'
                      ]
                      ,
                       [
                        text: "Pushed to Docker Hub : " + image,
                      ]
                    ]
                    
                    slackSend(channel: '#devops-prj', attachments: attachments)
                }
            }
            failure{
                slackSend(channel: '#devops-prj', color: "#ff0000", message: "build result : ${currentBuild.result} for ${image}, (Stage : ${last_started})")
            }
        }
}
