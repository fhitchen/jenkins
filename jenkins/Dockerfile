FROM jenkinsci/jenkins:2.8
MAINTAINER greg@thuron.net

COPY install_jenkins_plugins.sh /tmp/
COPY p4 /usr/local/bin/
# plugins to be installed
USER root
RUN chmod 755 /tmp/install_jenkins_plugins.sh 
RUN /tmp/install_jenkins_plugins.sh ldap workflow-aggregator job-dsl git matrix-auth p4 docker-plugin docker-workflow ant
USER jenkins
# scripts to be run on every start of jenkins
COPY init_scripts/ /usr/share/jenkins/ref/init.groovy.d/

# seed job to start everything off.
COPY seed_config.xml /usr/share/jenkins/ref/jobs/seed/config.xml

# do some ssh magic...
RUN mkdir -p /usr/share/jenkins/ref/.ssh
COPY ssh-config /usr/share/jenkins/ref/.ssh/config
COPY gitconfig /usr/share/jenkins/ref/.gitconfig
USER root
# set the timezone correctly
ENV TZ=Americas/Chicago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# scan bitbucket to get the fingerprints
#RUN ssh-keyscan bitbucket.org >> /usr/share/jenkins/ref/.ssh/known_hosts
RUN chmod  700 /usr/share/jenkins/ref/.ssh && chmod 600 /usr/share/jenkins/ref/.ssh/* && chown -R jenkins:jenkins /usr/share/jenkins/ref/.ssh

# lower user level to jenkins
#USER jenkins
