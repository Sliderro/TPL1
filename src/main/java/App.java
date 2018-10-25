import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Hello World");
        primaryStage.setResizable(false);
        GridPane root=new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);
        Label[] gracz=new Label[10];
        final TextField[] nazwaGracza=new TextField[10];
        for(int i=0;i<10;i++){
            String label="Gracz " + (i+1) + ":";
            gracz[i]=new Label(label);
            root.add(gracz[i], 2*(i/5), i%5);
            nazwaGracza[i] = new TextField();
            root.add(nazwaGracza[i], 2*(i/5)+1,i%5);
        }
        Button losuj= new Button("Losuj");
        HBox hbox=new HBox(20);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.getChildren().add(losuj);
        root.add(hbox,3,5);
        losuj.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Losowanko losowanko=new Losowanko();
                String wynik;
                wynik=losowanko.wylosuj();
                int[] parse=new int[10];
                Label[] tf=new Label[10];
                Label[] role=new Label[10];
                role[0]=new Label("Top Lane:");
                role[5]=new Label("Top Lane:");
                role[1]=new Label("Jungle:");
                role[6]=new Label("Jungle:");
                role[2]=new Label("Mid Lane:");
                role[7]=new Label("Mid Lane:");
                role[3]=new Label("Bot Lane:");
                role[8]=new Label("Bot Lane:");
                role[4]=new Label("Support:");
                role[9]=new Label("Support:");
                Label blue=new Label("BLUE SIDE:");
                Label red=new Label("RED SIDE:");
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wyniki Losowania");
                alert.setHeaderText("Oto sklady druzyn:");
                alert.setContentText(null);
                GridPane alertGrid=new GridPane();
                alertGrid.setVgap(20);
                alertGrid.setHgap(20);
                alertGrid.setAlignment(Pos.CENTER);
                alertGrid.add(blue,0,0);
                alertGrid.add(red,2,0);
                for(int i=0; i<10; i++){
                    parse[i]=Character.getNumericValue(wynik.charAt(i));
                    tf[i]=new Label(nazwaGracza[parse[i]].getText());
                    alertGrid.add(role[i],2*(i/5),i%5+1);
                    alertGrid.add(tf[i],2*(i/5)+1,i%5+1);
                }
                alertGrid.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setContent(alertGrid);
                alert.showAndWait();
            }
        });
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
