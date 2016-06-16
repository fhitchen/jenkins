import jenkins.model.*

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

jenkinsLocationConfiguration.setAdminAddress("Alfred Pennyworth <jenkins@thuron.net>")

jenkinsLocationConfiguration.save()
