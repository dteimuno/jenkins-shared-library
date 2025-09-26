#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockercredentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t dteimuno/demo-app:v2.0 .'
        sh 'echo "$PASSWORD"| docker login -u $USERNAME --password-stdin '
        sh 'docker push dteimuno/demo-app:v2.0'

    }
}