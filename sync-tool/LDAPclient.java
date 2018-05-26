import com.unboundid.ldap.sdk.*;

public class LDAPclient {

    /**
     * @param args
     * @throws LDAPException
     */
    public static void main(String[] args) throws LDAPException {


        LDAPConnection connection = new LDAPConnection("localhost.localdomain", 1389, "cn=Directory Manager","password");

        Filter filter = Filter.create("objectClass=person");
        SearchRequest searchRequest = new SearchRequest("dc=isep,dc=fr", SearchScope.SUB,filter,"cn","mail","telephoneNumber","userpassword");
        SearchResult searchResult;
        try
        {
            searchResult = connection.search(searchRequest);

            for (SearchResultEntry entry : searchResult.getSearchEntries())
            {
                String name = entry.getAttributeValue ("cn");
                String mail = entry.getAttributeValue("mail");
                String phone = entry.getAttributeValue("telephoneNumber");
                String mdp = entry.getAttributeValue("userpassword");
                System.out.println(name + "\n" + mail + "\n" + phone + "\n" + mdp);
            }

        }
        catch (LDAPSearchException lse)
        {
            // The search failed for some reason.
            searchResult = lse.getSearchResult();
            ResultCode resultCode = lse.getResultCode();
            String errorMessageFromServer = lse.getDiagnosticMessage();

        }

    }


}


