import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def user = 'andy'
def password = 'admin'

// create the user andy:admin
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(user,password)
instance.setSecurityRealm(hudsonRealm)
instance.save()

// turn on security
def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, user)
instance.setAuthorizationStrategy(strategy)
