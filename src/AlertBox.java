import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        label.setLayoutX(50);
        label.setLayoutY(50);
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());
        closeButton.setLayoutX(300);
        closeButton.setLayoutY(100);

        Pane layout = new Pane();
        layout.getChildren().addAll(label, closeButton);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout,450,150);
        window.setScene(scene);
        window.showAndWait();
    }

}