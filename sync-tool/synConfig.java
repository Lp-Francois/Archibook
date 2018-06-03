/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archibook;

import java.util.ResourceBundle;
import com.unboundid.ldap.sdk.*;

/**
 *
 * @author eleve
 */
public class synConfig {
    
    public synConfig(){
    }
    
    public static String getAPI(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String apiKey = bundle.getString("c.apiKey");
        return apiKey;
    }
    
    public static String getURL(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String url = bundle.getString("c.url");
        return url;
    }
    
    public static Integer getPORT(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String port = bundle.getString("c.port");
        int portInt = Integer.parseInt(port);
        return portInt;
    }
    
    public static String getDN(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String domainName = bundle.getString("c.domainName");
        return domainName;
    }
    
    public static String getPW(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String password = bundle.getString ("c.password");
        return password;
    }
    
    public static String getSEARCH(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String rootSearch = bundle.getString ("c.rootSearch");
        return rootSearch;
    }
    
     public static Long getMINUTES(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String minutes = bundle.getString ("c.minutes");
        Long min = Long.parseLong(minutes);
        return min;
    }
     
     public static Long getSECONDES(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String secondes = bundle.getString ("c.secondes");
        Long secs = Long.parseLong(secondes);
        return secs;
    }
     
     public static Long getMILLISECS(){
        ResourceBundle bundle = ResourceBundle.getBundle("archibook.properties.config");
        String milli = bundle.getString ("c.millisecs");
        Long millisecs = Long.parseLong(milli);
        return millisecs;
    }
    
    public static void sync () throws LDAPException{
        //"localhost.localdomain", 1389, "cn=Directory Manager","password"
        //"dc=isep,dc=fr"
        //LDAPclient ldapCo = new LDAPclient(cf.getAPI(), cf.getURL(), cf.getPORT(), cf.getDN(), cf.getPW(), cf.getSEARCH());
        
        synConfig cf = new synConfig();
        LDAPclient.connect(cf.getAPI(), cf.getURL(), cf.getPORT(), cf.getDN(), cf.getPW(), cf.getSEARCH());

        
    }
    
    
        

        
       
        
    }
    
