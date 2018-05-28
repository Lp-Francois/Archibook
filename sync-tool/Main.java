package archibook;

import com.unboundid.ldap.sdk.LDAPException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        //setup the program as Javafx application
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //stage : fenetre
        //scene : Ce que contient la fenetre
        //layout : ce qu'il y a dans la scene
        window = primaryStage;
        window.setTitle("Sync Tool");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,1));
        grid.setVgap(8);
        grid.setHgap(8);

        //url
        Label urlLabel = new Label("Server address - URL");
        GridPane.setConstraints(urlLabel, 0, 0);

        TextField urlInput = new TextField("localhost.localdomain");
        GridPane.setConstraints(urlInput, 1, 0);

        //port
        Label portLabel = new Label("Port");
        GridPane.setConstraints(portLabel, 0, 1);

        TextField portInput = new TextField("1389");
        GridPane.setConstraints(portInput, 1, 1);

        //dn
        Label loginLabel = new Label("domain name");
        GridPane.setConstraints(loginLabel, 0, 2);

        TextField loginInput = new TextField("cn=Directory Manager");
        GridPane.setConstraints(loginInput, 1, 2);

        //password
        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 3);

        TextField passwordInput = new TextField();
        GridPane.setConstraints(passwordInput, 1, 3);

        //domain component dnCo
        Label dcLabel = new Label("root ldap");
        GridPane.setConstraints(dcLabel, 0, 4);

        TextField dcInput = new TextField("dc=isep,dc=fr");
        GridPane.setConstraints(dcInput, 1, 4);

        //button
        Button sendButton = new Button("Sync");
        sendButton.setOnAction(e -> {
            try {
                String text = portInput.getText();
                int portInt = Integer.parseInt(text);
                connect(urlInput.getText(), portInt, loginInput.getText(),passwordInput.getText(), dcInput.getText());
            } catch (LDAPException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        GridPane.setConstraints(sendButton, 1, 5);

        grid.getChildren().addAll(urlLabel, urlInput, portLabel, portInput, loginLabel, loginInput, passwordLabel, passwordInput, dcLabel, dcInput, sendButton);
        Scene scene = new Scene(grid, 400,300);

        window.setScene(scene);

        window.show();
    }

    private void connect(String url, Integer port, String login, String password, String dc) throws LDAPException{
        //"localhost.localdomain", 1389, "cn=Directory Manager","password"
        //"dc=isep,dc=fr"

        Archibook ldapCo = new archibook.LDAPclient(url, port, login, password, dc);
        ldapCo.startConnection();

        /*
        System.out.println(url);
        System.out.println(port);
        System.out.println(login);
        System.out.println(password);
        System.out.println(dc);
        */
    }
}