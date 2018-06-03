package archibook;

import com.unboundid.ldap.sdk.*;

public class LDAPclient {

    public String url;
    public Integer port;
    public String dn;
    public String password;
    public String dnCo;

    public LDAPclient(String url2, Integer port2, String dn2, String password2, String dnCo2){
        url = url2;
        port = port2;
        dn = dn2;
        password = password2;
        dnCo = dnCo2;

        //System.out.println("[+] Constructeur");
    }

    public String startConnection() throws LDAPException {

        //System.out.println("[+] startConnection init");

        //LDAPConnection connection = new LDAPConnection("localhost.localdomain", 1389, "cn=Directory Manager","password");
        LDAPConnection connection = new LDAPConnection(url, port, dn, password);

        Filter filter = Filter.create("objectClass=person");
        //SearchRequest searchRequest = new SearchRequest("dc=isep,dc=fr", SearchScope.SUB,filter,"cn","mail","telephoneNumber","userpassword");
        SearchRequest searchRequest = new SearchRequest(dnCo, SearchScope.SUB,filter,"cn","mail","telephoneNumber","userpassword");
        SearchResult searchResult;
        try
        {
            //System.out.println("[+] Init try");
            searchResult = connection.search(searchRequest);

            System.out.println("[+] Successfull connection");
            
             int i = 1;
             String JSONString = new String();
             JSONString += "{";
                
            for (SearchResultEntry entry : searchResult.getSearchEntries())
            {
                
                String name = entry.getAttributeValue ("cn");
                String mail = entry.getAttributeValue("mail");
                String mdp = entry.getAttributeValue("userpassword");
                
                
                JSONString += "\"" + i + "\":{";
                JSONString = JSONString + "\"name\":\"" + name + "\",\"password\":\"" + mdp + "\",\"mail\":\"" + mail + "\"},";
                i++;
        
                
            }
            
            JSONString = JSONString.substring(0,JSONString.length()-1);
            JSONString += "}";
            System.out.println(JSONString);
            return JSONString;

        }
        catch (LDAPSearchException lse)
        {
            System.out.println("[!] Failed");
            // The search failed for some reason.
            searchResult = lse.getSearchResult();
            ResultCode resultCode = lse.getResultCode();
            String errorMessageFromServer = lse.getDiagnosticMessage();
            return errorMessageFromServer;
        }
        
        

    }
    
    public static void connect(String apiKey, String url, Integer port, String login, String password, String dc) throws LDAPException{
        //"localhost.localdomain", 1389, "cn=Directory Manager","password"
        //"dc=isep,dc=fr"
        LDAPclient ldapCo = new LDAPclient(url, port, login, password, dc);
        String JSONString = ldapCo.startConnection();
        HttpPostReq post = new HttpPostReq(JSONString,apiKey);
        post.send();
        
        

        /*
        System.out.println(url);
        System.out.println(port);
        System.out.println(login);
        System.out.println(password);
        System.out.println(dc);
        */
    }


}