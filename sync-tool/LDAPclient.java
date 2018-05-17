import javax.naming.*;
import java.util.*;
import javax.naming.ldap.*;
import javax.naming.directory.*;


public class LDAPclient {

    public static void main(String args[]) throws NamingException
    {
        try {
            Hashtable<String, String> env = new Hashtable<String, String>();
            String domain = "DOMAIN0\\"; //domain name of AD server (ex: domain.com.sg), not domain name of website
            String username = "bvincent"; //user domain to login PC
            String password = "password";
            String securityPrincipal = "cn=Directory Manager"; // or username + "@" + "domain.com.sg";

            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost.localdomain:1389"); //IP and port of LDAP
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, securityPrincipal); // replace with user DN
            env.put(Context.SECURITY_CREDENTIALS, password);

            /*DirContext dcx = new InitialDirContext(env);*/
            //InitialLdapContext ctx = new InitialLdapContext(env, null);
            LdapContext ctx = new InitialLdapContext(env, null);
            System.out.println("Authentication Success!");
            //return true;

        } catch (NamingException ex) {
            System.out.println("Authentication failed: " + ex.toString());
            //return false;
        } catch (Exception ex) {
            System.out.println("Authentication failed ! Exception: " + ex.toString());
            //return false;
        }
    }
}
