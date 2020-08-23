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
             emailext (
		     to: "shoubhikghosh83@gmail.com",
		     from: "jenkins@jenkinsadmin.com",
    subject: "Failed: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
    body: "Failed: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':\nCheck console output at '${env.BUILD_URL}' ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
    recipientProviders: [[$class: 'DevelopersRecipientProvider']]
)  
         } 
        }
}
