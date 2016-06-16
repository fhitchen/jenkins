import jenkins.model.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.plugins.git.GitSCM")

desc.setGlobalConfigName("Alfred Pennyworth")
desc.setGlobalConfigEmail("jenkins@thuron.net")

desc.save()
