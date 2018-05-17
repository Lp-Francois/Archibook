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

        Label urlLabel = new Label("Server address");
        GridPane.setConstraints(urlLabel, 0, 0);

        TextField urlInput = new TextField("ldap://my.ldap.server:1389");
        GridPane.setConstraints(urlInput, 1, 0);

        Label loginLabel = new Label("DN of Directory Manager");
        GridPane.setConstraints(loginLabel, 0, 1);

        TextField loginInput = new TextField();
        GridPane.setConstraints(loginInput, 1, 1);


        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 2);

        TextField passwordInput = new TextField();
        GridPane.setConstraints(passwordInput, 1, 2);


        Button sendButton = new Button("Sync");
        sendButton.setOnAction(e -> connect(urlInput.getText(),loginInput.getText(),passwordInput.getText()));
        GridPane.setConstraints(sendButton, 1, 3);

        grid.getChildren().addAll(urlLabel, urlInput, loginLabel, loginInput, passwordLabel, passwordInput, sendButton);
        Scene scene = new Scene(grid, 350,200);

        window.setScene(scene);

        window.show();
    }

    private void connect(String url, String login, String password){
        System.out.println(url);
        System.out.println(login);
        System.out.println(password);
    }
}