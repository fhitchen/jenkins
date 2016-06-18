# **Boise Devops 2016: Jenkins CICD demostration**

# The Demo

* Shows how to provision CICD pipelines automatically using a programatical form.
* Plugins used:  job-dsl and pipeline (was workflow)

# Demo Steps

## Start up Jenkins

### Mac/Windows Steps

* (windows/mac) Download/Install docker toolbox

[https://www.docker.com/products/docker-toolbox](Link URL)

### Linux Steps

* Install docker and docker-compose

### Mac/Windows/Linux Steps
* git clone https://bitbucket.org/boise_devops_2016/jenkins.git
```
#!bash
git clone https://bitbucket.org/boise_devops_2016/jenkins.git
```
* Build and run jenkins, use the Docker Quickstart Terminal, note the IP address if running on Windows/Mac
```
#!bash
docker-compose up
```

## Run the seed job.

* Login into jenkins http://localhost:9080 or try http://192.168.99.100:8080
* Admin credentials are username: andy, password: admin
* Run the seed job, the pipelines will be built, and integrations will start.

# Interesting things to do...

## Fork the repositories to your own account (needed to push new commits/branches)

* Run the test script, located in tests/hello_job_tests.sh
  NOTE: you will need to fix up the repo locations in seed.groovy, the Jenkinsfiles, and the test script.

## Push releases to hello, branch refs/heads/releases/rel_2
```
#!bash
git push origin HEAD:refs/heads/releases/rel_2
```