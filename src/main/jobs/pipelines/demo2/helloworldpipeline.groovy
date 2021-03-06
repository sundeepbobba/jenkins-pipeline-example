#!/usr/bin/env groovy

def scmUrl = 'https://github.com/bpmericle/jenkins-meetup-2017-09-05.git'
def scmBranch = 'master'
def pathToScript = 'src/main/jobs/pipelines/demo2/Jenkinsfile'

pipelineJob('hello-world-pipeline-with-libs') {
    displayName('Hello World Pipeline with Libs')
    description('This Hello World pipeline with libs job was created by using the Job DSL/Plugin.')

    logRotator(-1,5,-1,-1)

    parameters {
        stringParam('NAME', '', 'Enter your name.')
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url(scmUrl)
                    }
                    branch(scmBranch)
                }
            }
            scriptPath(pathToScript)
        }
    }
}
