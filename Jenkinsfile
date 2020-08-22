pipeline {
    agent any
    
    stages {
        

        stage ('Build') {
            steps {
                sh 'mvn clean package' 
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
}