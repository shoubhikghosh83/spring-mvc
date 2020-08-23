pipeline {
    agent any
    
    stages {
        

        stage ('Build') {
            steps {
                sh 'mvn clean package' 
            }
            
        }
        stage ('Sonar') {
            steps {
                sh 'mvn sonar:sonar' 
            }
            
        }
        stage ('Docker Build') {
            steps {
                sh 'docker build -t shoubhikghosh83/devops:latest .' 
            }
            
        }
        stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push shoubhikghosh83/devops:latest'
        }
      }
    }
	stage ('Ansible Build') {
            steps {
                sh 'ansible-playbook -i golden-gate-ansible/ansible_hosts golden-gate-ansible/site.yml' 
            }
            
        }
        
        
    }
    post {
        failure {  
             emailext body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}",  from: 'jenkinsadmin@jenkins.com', mimeType: 'text/html',  subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "shoubhikghosh83@gmail.com";  
         } 
        }
}
