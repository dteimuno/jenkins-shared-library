#!/user/bin/env groovy
//new work
def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockercredentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh 'echo "$PASSWORD"| docker login -u $USERNAME --password-stdin '
        sh "docker push $imageName"

    }
}
