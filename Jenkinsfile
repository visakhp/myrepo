pipeline {
    agent any
    stages {
       stage('Copy Ansible File') {       
            steps {
                sh 'cp playbooks/docker-playbook/ansible-playbook.yml /ansible_docker_app'
            }
         }
        stage('Deploy Ansible Applications') {       
            steps {
                sshagent(['ansible-key']) {
                    ansiblePlaybook(
                       colorized: true,
                       credentialsId: 'ansible-key',
                       extras: '-vvv',
                       inventory: '/etc/ansible/hosts',
                       playbook: '/ansible_docker_app/ansible-playbook.yml')
                  }
             }
         }
    }  
}
