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

* Login into jenkins http://localhost:9080 or try http://192.168.99.100:9080
* Admin credentials are username: andy, password: admin
* Run the seed job, the pipelines will be built, and integrations will start.
* Browse to all builds and watch the jobs fire, stages run, and work occur on the nodes... http://192.168.99.100:9080/view/All/builds

# Interesting things to do...

## Fork the repositories to your own account (needed to push new commits/branches)

* Run the test script, located in tests/hello_job_tests.sh
  NOTE: you will need to fix up the repo locations in seed.groovy, the Jenkinsfiles, and the test script.

## Push releases to hello, branch refs/heads/releases/rel_2
```
#!bash
git push origin HEAD:refs/heads/releases/rel_2
```

# What is all happening during the Demo.

1. The jenkins docker container is pulled from the docker registry.
2. The container is built with three startup scripts to deploy Jenkins correctly.
   *  Sets the Jenkins admin information.
   *  Creates the admin account, and sets up the security model.
   *  Sets up the git username and email address.
   NOTE: Look at the init_scripts for more information.
3. The plugins for Jenkins are deployed from the internet, along with their dependencies.
4. The seed job is copied over and is ready to run as soon as Jenkins is ready.
5. The necessary ssh configuration is done to insure git clones will work with bitbucket.
6. Once Jenkins is ready, build the seed job.
7. The seed job creates 8 pipeline jobs.
8. Run to the Build History and watch the pipelines build.  In the next 5 minutes, all 8 jobs will execute, roughly 100+ stages/nodes will be executed.
9. At this point, clone all four repos, modify the repo URLs to the new repos and play...  A couple of things to do, check out the multibranch pipeline, goto the benchtest and release folders and read how to create a new pipeline using multibranch pipeline.
10. Modify the seed.groovy file and add in your own jobs.
11. Modify the Jenkinsfile_XXX jobs and add your own logic, your own git repos and start building your own CICD pipelines.
12. Remember that the DSLs are just groovy, if you need a "if" statement, you have it...  If you need a method, an object, a call out to a rest service, etc... You can do it.  

More information on the Job-DSL  https://jenkinsci.github.io/job-dsl-plugin/

More information on the pipeline https://github.com/jenkinsci/pipeline-plugin/blob/master/TUTORIAL.md