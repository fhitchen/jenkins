import jenkins.model.*
import com.cloudbees.plugins.credentials.CredentialsProvider
import org.jenkinsci.plugins.p4.credentials.P4PasswordImpl
import org.jenkinsci.plugins.p4.credentials.TrustImpl
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.domains.Domain

def username = ''
def password = ''
def instance = Jenkins.getInstance()

def p4creds = new P4PasswordImpl(CredentialsScope.GLOBAL, 
                                'p4_credentials', 
                                'mine', 
                                'cmildev57:1661',
                                new TrustImpl(''),
                                username, 
                                '0', 
                                '0',
                                password)

CredentialsProvider.lookupStores(instance).iterator().next().addCredentials(Domain.global(), p4creds)
