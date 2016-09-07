import jenkins.model.*

def instance = Jenkins.getInstance()

final String name = "genproxy"
final int port = 8080
final String userName = ""
final String password = ""
final String noProxyHost = "localhost, *.amdocs.com, *.corp.amdocs.com"

final def pc = new hudson.ProxyConfiguration(name, port, userName, password, noProxyHost)
instance.proxy = pc
instance.save()
println "Proxy settings updated!"

