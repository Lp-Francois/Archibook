import com.unboundid.ldap.sdk.*;

public class LDAPclient {

    /**
     * @param args
     * @throws LDAPException
     */
    public static void main(String[] args) throws LDAPException {


        LDAPConnection connection = new LDAPConnection("localhost.localdomain", 1389, "cn=Directory Manager","password");

        Filter filter = Filter.create("(objectClass=*)");
        SearchRequest searchRequest = new SearchRequest("ou=Professors,ou=People,dc=isep,dc=fr", SearchScope.SUB, filter,"mail","telephoneNumber","cn");
        SearchResult searchResult;
        try
        {
            searchResult = connection.search(searchRequest);

            for (SearchResultEntry entry : searchResult.getSearchEntries())
            {
                String name = entry.getAttributeValue ("cn");
                String mail = entry.getAttributeValue("mail");
                String phone = entry.getAttributeValue("telephoneNumber");
                System.out.println(name + "\n" + mail + "\n" + phone);
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

