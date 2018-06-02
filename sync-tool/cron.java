/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archibook;

import java.util.Timer;
import java.util.TimerTask;
import com.unboundid.ldap.sdk.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class cron  {
 
   public cron()  {
       
}
   
   public static void task() {
       Timer minuteur = new Timer();
        TimerTask tache = new TimerTask () {
            public void run (){
                try {
                    synConfig.sync();
                } catch (LDAPException ex) {
                    Logger.getLogger(cron.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        minuteur.schedule(tache, 0, 1000*60*5);
   }
   
   public static void main(String[] args) {
        //setup the program as Javafx application
        task(); //
    }
}
