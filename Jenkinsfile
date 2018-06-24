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
                    sh 'ssh visakh@localhost uname -a'
                    sh 'ansible-playbook /ansible_docker_app/ansible-playbook.yml -vvv'
                }
             }
         }
    }  
}
