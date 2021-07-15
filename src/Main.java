import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main extends Application {

    int NumberInt = 0,runsInt = 0,boundInt = 0,strikeInt = 0;
    TextField textBoxNum,textBoxScore,textBoxBound,textBoxRate,textBoxRecord;
    ComboBox combo_box;
    static ObservableList<PlayerDetails> playerlist= FXCollections.observableArrayList();
    ArrayList score=new ArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        loadData();  //Getting Data From the Text File

//     Create Stages , windows    //

        Stage windowMainMenu = new Stage();
        windowMainMenu.setTitle("Score Analyzer");

        Stage windowSearch = new Stage();
        windowSearch.setTitle("Search Details Using Name");

        Stage windowViewAllThreeWinners = new Stage();
        windowViewAllThreeWinners.setTitle("View All Three Winners");

        Stage windowViewMatchInformation = new Stage();
        windowViewMatchInformation.setTitle("View Match Information");

        Stage windowEnterDetails = new Stage();
        windowEnterDetails.setTitle("Enter Details");

        Stage windowDetails = new Stage();
        windowDetails.setTitle("Player Details");

///          Layout 1 - Main Menu                       ///

        StackPane layoutMainMenu = new StackPane();
        layoutMainMenu.setStyle("-fx-background-color:#DC143C ;");

        Label labelCaption = new Label("ABC Cricket Tournament");
        labelCaption.setTranslateY(-300);
        labelCaption.setFont(new Font("Arial", 60));
        labelCaption.setStyle("-fx-background-color: #B22222;");
        layoutMainMenu.getChildren().add(labelCaption);

        Button buttonEnterDetails = new Button("Enter Details");
        buttonEnterDetails.setTranslateY(-180);
        buttonEnterDetails.setMaxWidth(500);
        buttonEnterDetails.setMaxHeight(60);
        buttonEnterDetails.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonEnterDetails);


        Button buttonViewPlayerDetails = new Button("View Player Details");
        buttonViewPlayerDetails.setTranslateY(-100);
        buttonViewPlayerDetails.setMaxWidth(500);
        buttonViewPlayerDetails.setMaxHeight(60);
        buttonViewPlayerDetails.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonViewPlayerDetails);

        Button buttonDisplayDataUsingName = new Button("Search Details Using Name");
        buttonDisplayDataUsingName.setTranslateY(-20);
        buttonDisplayDataUsingName.setMaxWidth(500);
        buttonDisplayDataUsingName.setMaxHeight(60);
        buttonDisplayDataUsingName.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonDisplayDataUsingName);

        Button buttonDisplayAllThreeWinners = new Button("View All Three Winners");
        buttonDisplayAllThreeWinners.setTranslateY(60);
        buttonDisplayAllThreeWinners.setMaxWidth(500);
        buttonDisplayAllThreeWinners.setMaxHeight(60);
        buttonDisplayAllThreeWinners.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonDisplayAllThreeWinners);

        Button buttonDisplayMatchInfo= new Button("View Match Information");
        buttonDisplayMatchInfo.setTranslateY(140);
        buttonDisplayMatchInfo.setMaxWidth(500);
        buttonDisplayMatchInfo.setMaxHeight(60);
        buttonDisplayMatchInfo.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonDisplayMatchInfo);

        Button buttonExit = new Button("Exit");
        buttonExit.setTranslateY(220);
        buttonExit.setMaxWidth(500);
        buttonExit.setMaxHeight(60);
        buttonExit.setFont(new Font("Arial", 25));
        layoutMainMenu.getChildren().add(buttonExit);

        Scene scene = new Scene(layoutMainMenu, 800, 750);
        windowMainMenu.setScene(scene);
        windowMainMenu.show();

//      Button Controls

        buttonEnterDetails.setOnAction(value ->{
            System.out.println();
            windowMainMenu.close();
            windowEnterDetails.showAndWait();
        });

//     Layout 2 Main Menu ->  Enter details   //

        GridPane layoutInputData = new GridPane();

        String venuesList[] = { "Pallekale", "Galle", "Colombo", "Hambanthota"};

        String TeamList[] = { "Team A", "Team B", "Team C", "Team D", "Team E", "Team F", "Team G", "Team H", "Team I", "Team J"};

        layoutInputData.setStyle("-fx-background-color:#FF6347;");

        //Labels

        Label labelTop = new Label("Select the Team");
        labelTop.setTranslateX(50);
        labelTop.setTranslateY(40);
        labelTop.setFont(new Font("Arial", 25));
        layoutInputData.getChildren().add(labelTop);

        Label labelNum = new Label("Player Number :");
        labelNum.setTranslateX(50);
        labelNum.setTranslateY(100);
        labelNum.setFont(new Font(25));
        layoutInputData.getChildren().add(labelNum);

        Label labelScore = new Label("Runs Scored :");
        labelScore.setTranslateX(50);
        labelScore.setTranslateY(160);
        labelScore.setFont(new Font(25));
        layoutInputData.getChildren().add(labelScore);

        Label labelBound = new Label("Boundaries :" );
        labelBound.setTranslateX(50);
        labelBound.setTranslateY(220);
        labelBound.setFont(new Font(25));
        layoutInputData.getChildren().add(labelBound);

        Label labelRate = new Label("Strike Rate : ");
        labelRate.setTranslateX(50);
        labelRate.setTranslateY(280);
        labelRate.setFont(new Font(25));
        layoutInputData.getChildren().add(labelRate);

        Label labelVenue = new Label("Venue :");
        labelVenue.setTranslateX(50);
        labelVenue.setTranslateY(340);
        labelVenue.setFont(new Font(25));
        layoutInputData.getChildren().add(labelVenue);

        Label labelRecords = new Label("Important Records :");
        labelRecords.setTranslateX(50);
        labelRecords.setTranslateY(400);
        labelRecords.setFont(new Font(25));
        layoutInputData.getChildren().add(labelRecords);

        //   Combo Box   //

        ComboBox dropDownTeam = new ComboBox(FXCollections.observableArrayList(TeamList));
        dropDownTeam.setValue("Team --");
        dropDownTeam.setTranslateX(400);
        dropDownTeam.setTranslateY(40);
        dropDownTeam.setMinWidth(350);
        dropDownTeam.setMinHeight(50);
        dropDownTeam.setStyle("-fx-background-color: #DC143C;");
        layoutInputData.getChildren().add(dropDownTeam);

        combo_box = new ComboBox(FXCollections.observableArrayList(venuesList));
        combo_box.setValue("Select a Venue");
        combo_box.setTranslateX(400);
        combo_box.setTranslateY(340);
        combo_box.setMaxWidth(350);
        combo_box.setMinHeight(50);
        combo_box.setStyle("-fx-background-color:#DC143C ;");
        layoutInputData.getChildren().add(combo_box);

        //    Button    //

        Button buttonBack = new Button("Back");
        buttonBack.setTranslateX(50);
        buttonBack.setTranslateY(570);
        buttonBack.setMaxWidth(300);
        buttonBack.setMinHeight(70);
        buttonBack.setFont(new Font(25));
        buttonBack.setStyle("-fx-background-color: #DC143C;");
        layoutInputData.getChildren().add(buttonBack);

        Button buttonSave = new Button("Save");
        buttonSave.setTranslateX(430);
        buttonSave.setTranslateY(570);
        buttonSave.setMaxWidth(300);
        buttonSave.setMinHeight(70);
        buttonSave.setFont(new Font(25));
        buttonSave.setStyle("-fx-background-color: #DC143C;");
        layoutInputData.getChildren().add(buttonSave);

        //Text Fields

         textBoxNum = new TextField();
        textBoxNum.setTranslateX(400);
        textBoxNum.setTranslateY(100);
        textBoxNum.setMaxWidth(350);
        textBoxNum.setFont(new Font(22));
        textBoxNum.setStyle("-fx-background-color:#DC143C ;");
        layoutInputData.getChildren().add(textBoxNum);

         textBoxScore = new TextField();
        textBoxScore.setTranslateX(400);
        textBoxScore.setTranslateY(160);
        textBoxScore.setMaxWidth(350);
        textBoxScore.setFont(new Font(22));
        textBoxScore.setStyle("-fx-background-color: #DC143C;");
        layoutInputData.getChildren().add(textBoxScore);

         textBoxBound = new TextField();
        textBoxBound.setTranslateX(400);
        textBoxBound.setTranslateY(220);
        textBoxBound.setMaxWidth(350);
        textBoxBound.setFont(new Font(22));
        textBoxBound.setStyle("-fx-background-color: #DC143C;");
        layoutInputData.getChildren().add(textBoxBound);

        textBoxRate = new TextField();
        textBoxRate.setTranslateX(400);
        textBoxRate.setTranslateY(280);
        textBoxRate.setMaxWidth(350);
        textBoxRate.setFont(new Font(22));
        textBoxRate.setStyle("-fx-background-color:#DC143C ;");
        layoutInputData.getChildren().add(textBoxRate);

         textBoxRecord = new TextField();
        textBoxRecord.setTranslateX(400);
        textBoxRecord.setTranslateY(400);
        textBoxRecord.setMaxWidth(350);
        textBoxRecord.setFont(new Font(22));
        textBoxRecord.setStyle("-fx-background-color: #dc143c;");


        layoutInputData.getChildren().addAll(textBoxRecord);

        Scene sceneInputDetails = new Scene(layoutInputData, 800, 700);

        windowEnterDetails.setScene(sceneInputDetails);

        //      Save Button Controls     //

        buttonSave.setOnAction(e ->{

            String choosenTeam = (String) dropDownTeam.getValue();

            switch (choosenTeam) {
                case "Team A":

                    validation("Team A");
                    break;

                case "Team B":

                    validation("Team B");
                    break;

                case "Team C":

                    validation("Team C");
                    break;

                case "Team D":

                    validation("Team D");
                    break;

                case "Team E":

                    validation("Team E");
                    break;

                case "Team F":

                    validation("Team F");
                    break;

                case "Team G":

                    validation("Team G");
                    break;

                case "Team H":

                    validation("Team H");
                    break;

                case "Team I":

                    validation("Team I");
                    break;

                case "Team J":

                    validation("Team J");
                    break;
            }

            System.out.println(score);

            textBoxNum.setText("");
            textBoxScore.setText("");
            textBoxBound.setText("");
            textBoxRate.setText("");
            textBoxRecord.setText("");
            combo_box.setValue("Select a Venue");
        });

//           Back Button Control   //

        buttonBack.setOnAction(value -> {
                    windowEnterDetails.close();
                   windowMainMenu.showAndWait();

                   textBoxNum.setText("");
            textBoxScore.setText("");
            textBoxBound.setText("");
            textBoxRate.setText("");
            textBoxRecord.setText("");
            combo_box.setValue("Select a Venue");
        });

//            Layout Information    //

        GridPane layoutInfo = new GridPane();

        layoutInfo.setStyle("-fx-background-color:#F08080 ;");

        Label labelTop7 = new Label();
        labelTop7.setTranslateX(50);
        labelTop7.setTranslateY(100);
        labelTop7.setFont(new Font("Arial", 16));
        layoutInfo.getChildren().add(labelTop7);

        Button buttonBack4 = new Button("Back");
        buttonBack4.setTranslateX(100);
        buttonBack4.setTranslateY(700);
        buttonBack4.setMaxWidth(1000);
        buttonBack4.setMinHeight(50);
        layoutInfo.getChildren().add(buttonBack4);

        Scene sceneInfo = new Scene(layoutInfo, 900, 800);

        windowViewMatchInformation.setScene(sceneInfo);

        buttonBack4.setOnAction(value ->{
            windowViewMatchInformation.close();
            windowMainMenu.showAndWait();
        });

        //   Layout  Search     //

        GridPane layoutSearch = new GridPane();

        layoutInputData.setStyle("-fx-background-color: #FF6347;");

        //Labels

        Label labelTop5 = new Label("Player Name     : ");
        labelTop5.setTranslateX(50);
        labelTop5.setTranslateY(100);
        labelTop5.setFont(new Font("Arial", 25));
        textBoxRecord.setStyle("-fx-background-color: #DC143C;");
        layoutSearch.getChildren().add(labelTop5);

        Label labelTop6 = new Label("");
        labelTop6.setTranslateX(350);
        labelTop6.setTranslateY(300);
        labelTop6.setFont(new Font("Arial", 25));
        layoutSearch.getChildren().add(labelTop6);

        TextField textBoxSerch = new TextField();
        textBoxSerch.setTranslateX(400);
        textBoxSerch.setTranslateY(100);
        textBoxSerch.setMaxWidth(350);
        textBoxSerch.setFont(new Font(22));
        textBoxSerch.setStyle("-fx-background-color: #A4EFDC;");
        layoutSearch.getChildren().add(textBoxSerch);

        Button buttonBack2 = new Button("Back");
        buttonBack2.setTranslateX(50);
        buttonBack2.setTranslateY(500);
        buttonBack2.setMaxWidth(300);
        buttonBack2.setMinHeight(70);
        layoutSearch.getChildren().add(buttonBack2);

        Button buttonSearch = new Button("Search");
        buttonSearch.setOnAction(event -> {
            for(PlayerDetails player:playerlist){
                if(player.getPlayerName().equals(textBoxSerch.getText())){
                    labelTop6.setText("Name:"+player.getPlayerName()+"\n"+"Age:"+player.getPlayerAge()+"\n"+"Role:"+player.getPlayerRole()+"\n"+"School:"+player.getPlayerSchool());

                }
            }
        });
        buttonSearch.setTranslateX(430);
        buttonSearch.setTranslateY(500);
        buttonSearch.setMaxWidth(300);
        buttonSearch.setMinHeight(70);
        layoutSearch.getChildren().add(buttonSearch);


        Scene sceneSearch = new Scene(layoutSearch, 800, 600);

        windowSearch.setScene(sceneSearch);

        buttonBack2.setOnAction(value ->{
            windowSearch.close();
            windowMainMenu.showAndWait();
        });

        ///////// player details   /////////

        Pane layoutDetails = new Pane();

        layoutDetails.setStyle("-fx-background-color: #1eb2a6;");

        TableView<PlayerDetails> table;

        //date column
        TableColumn<PlayerDetails,String> playerNameColumn=new TableColumn<>("playerName");
        playerNameColumn.setPrefWidth(200);
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        //age column
        TableColumn<PlayerDetails,String> playerSchoolColumn=new TableColumn<>("playerSchool");
        playerSchoolColumn.setPrefWidth(200);
        playerSchoolColumn.setCellValueFactory(new PropertyValueFactory<>("playerSchool"));

        //date column
        TableColumn<PlayerDetails,String> playerAgeColumn=new TableColumn<>("playerAge");
        playerAgeColumn.setPrefWidth(200);
        playerAgeColumn.setCellValueFactory(new PropertyValueFactory<>("playerAge"));
        //date column
        TableColumn<PlayerDetails,String> playerRoleColumn=new TableColumn<>("playerRole");
        playerRoleColumn.setPrefWidth(200);
        playerRoleColumn.setCellValueFactory(new PropertyValueFactory<>("playerRole"));

        table= new TableView<>();
        table.setItems(playerlist);
        table.getColumns().addAll(playerNameColumn,playerSchoolColumn,playerAgeColumn,playerRoleColumn);

        layoutDetails.getChildren().addAll(table);

        Button buttonBack3 = new Button("Back");
        buttonBack3.setTranslateX(50);
        buttonBack3.setTranslateY(400);
        buttonBack3.setMaxWidth(700);
        buttonBack3.setMinHeight(50);
        layoutDetails.getChildren().add(buttonBack3);

        Scene sceneDetails = new Scene(layoutDetails, 800, 500);

        windowDetails.setScene(sceneDetails);

        buttonBack3.setOnAction(value ->{
            windowDetails.close();
            windowMainMenu.showAndWait();
        });

//// LAYOUT MAIN MENU -> VIEW ALL THREE WINNERS  //

        GridPane layoutViewAllThreeWinners = new GridPane();

        layoutViewAllThreeWinners.setStyle("-fx-background-color: #FF6347;");

        Label labelHighestM = new Label("Highest Marks :");
        labelHighestM.setTranslateX(50);
        labelHighestM.setTranslateY(100);
        labelHighestM.setFont(new Font(25));
        layoutViewAllThreeWinners.getChildren().add(labelHighestM);

        Label labelHighestBound = new Label("Highest boundaries :");
        labelHighestBound.setTranslateX(50);
        labelHighestBound.setTranslateY(160);
        labelHighestBound.setFont(new Font(25));
        layoutViewAllThreeWinners.getChildren().add(labelHighestBound);

        Label labelHighestAvg = new Label("Highest Average :" );
        labelHighestAvg.setTranslateX(50);
        labelHighestAvg.setTranslateY(220);
        labelHighestAvg.setFont(new Font(25));
        layoutViewAllThreeWinners.getChildren().add(labelHighestAvg);

        TextField textBoxHighestMarks = new TextField();
        textBoxHighestMarks.setTranslateX(400);
        textBoxHighestMarks.setTranslateY(100);
        textBoxHighestMarks.setMaxWidth(350);
        textBoxHighestMarks.setFont(new Font(22));
        textBoxHighestMarks.setStyle("-fx-background-color: #A4EFDC;");
        layoutViewAllThreeWinners.getChildren().add(textBoxHighestMarks);

        TextField textBoxHighestbound = new TextField();
        textBoxHighestbound.setTranslateX(400);
        textBoxHighestbound.setTranslateY(160);
        textBoxHighestbound.setMaxWidth(350);
        textBoxHighestbound.setFont(new Font(22));
        textBoxHighestbound.setStyle("-fx-background-color: #A4EFDC;");
        layoutViewAllThreeWinners.getChildren().add(textBoxHighestbound);

        TextField textBoxHighestavg = new TextField();
        textBoxHighestavg.setTranslateX(400);
        textBoxHighestavg.setTranslateY(220);
        textBoxHighestavg.setMaxWidth(350);
        textBoxHighestavg.setFont(new Font(22));
        textBoxHighestavg.setStyle("-fx-background-color: #A4EFDC;");
        layoutViewAllThreeWinners.getChildren().add(textBoxHighestavg);

        Button buttonBack1 = new Button("Back");
        buttonBack1.setTranslateX(50);
        buttonBack1.setTranslateY(300);
        buttonBack1.setMaxWidth(100);
        buttonBack1.setMaxHeight(40);
        layoutViewAllThreeWinners.getChildren().add(buttonBack1);

        buttonBack1.setOnAction(value ->{
            windowViewAllThreeWinners.close();
            windowMainMenu.show();
        });

        Scene sceneViewAllThreeWinners = new Scene(layoutViewAllThreeWinners, 800, 500);

        windowViewAllThreeWinners.setScene(sceneViewAllThreeWinners);

//      Button Controls

        buttonExit.setOnAction(value -> {
            windowMainMenu.close();
        });

        buttonDisplayDataUsingName.setOnAction(value ->{
            windowMainMenu.close();
            windowSearch.show();

        });

        buttonDisplayAllThreeWinners.setOnAction(value ->{
            windowMainMenu.close();
            windowViewAllThreeWinners.show();
        });

        buttonDisplayMatchInfo.setOnAction(value -> {
                    windowMainMenu.close();
                    windowViewMatchInformation.show();
                    String b="";
                    int a=0;
                    int c=0;
                    while(a<score.size()){
                        c=c+1;
                        if(c==1){
                            b=b+"\n"+ score.get(a);
                        }
                        else if(c==2){
                            b=b+"\n"+"player number:"+score.get(a);
                        }
                        else if(c==3){
                            b=b+"\n"+"runs score:"+score.get(a);
                        }
                        else if(c==4){
                            b=b+"\n"+"boundaries:"+score.get(a);
                        }
                        else if(c==5){
                            b=b+"\n"+"stricke rate:"+score.get(a);
                        }
                        else if(c==6){
                            b=b+"\n"+"important point:"+score.get(a);
                        }
                        else if(c==7){
                            b=b+"\n"+"venue:"+score.get(a);
                            c=0;
                        }


                        a=a+1;

                    }
                    System.out.println(b);
                    labelTop7.setText(b);
        });

        buttonViewPlayerDetails.setOnAction(value -> {
            windowMainMenu.close();
            windowDetails.showAndWait();
        });
    }

    private static void loadData() {

        PlayerDetails playerDetails=null;

        try(BufferedReader br = new BufferedReader(new FileReader("Team A.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }

        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team B.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }
        try(BufferedReader br = new BufferedReader(new FileReader("Team C.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);
                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team D.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team E.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team F.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team G.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);
                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team H.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);
                index ++;                                           //Incrementing the Index
            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team I.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("Team J.txt"))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(":");

                playerDetails=new PlayerDetails(tokens[0],tokens[1],tokens[2],tokens[3]);
                playerlist.add(playerDetails);

                index ++;                                           //Incrementing the Index

            }

            System.out.println("\u2318 Data Loaded Successfully");

            for (PlayerDetails playerDetails1:playerlist) {

                System.out.println(playerDetails.getPlayerName());
                System.out.println(playerDetails.getPlayerSchool());
                System.out.println(playerDetails.getPlayerAge());
                System.out.println(playerDetails.getPlayerRole());

            }
        }

        catch (Exception e) {
            System.out.println("An Error Occurred");
        }
    }


    public void validation(String team){

        if (textBoxNum.equals("") || textBoxScore.equals("") || textBoxBound.equals("") ||
                textBoxRate.equals("") || textBoxRecord.equals("")) {

            AlertBox.display("Alert Box", "Please fill all inputs");
        }

        try {
            NumberInt = Integer.parseInt(textBoxNum.getText());
        } catch (Exception e1) {
            AlertBox.display("Alert Box", "Player number is not an integer");
        }

        try {
            runsInt = Integer.parseInt(textBoxScore.getText());
        } catch (Exception e1) {
            AlertBox.display("Alert Box", "Runs are not an integer");
        }

        try {
            boundInt = Integer.parseInt(textBoxBound.getText());
        } catch (Exception e1) {
            AlertBox.display("Alert Box", "Boundaries are not an integer");
        }

        try {
            strikeInt = Integer.parseInt(textBoxRate.getText());
        } catch (Exception e1) {
            AlertBox.display("Alert Box", "Strike rate is not an integer");
        }

        if (!(NumberInt >= 0 && NumberInt <= 10)) {
            AlertBox.display("Alert Box", "Player number is out of range");
        }

        if (!(runsInt >= 0)) {
            AlertBox.display("Alert Box", "Runs are out of range");
        }

        if (!(boundInt >= 0)) {
            AlertBox.display("Alert Box", "Boundaries are out of range");
        }

        if (!(strikeInt >= 0)) {
            AlertBox.display("Alert Box", "Strike rate is out of range");
        }

        if (!(textBoxNum.equals("") || textBoxScore.equals("") || textBoxBound.equals("") ||
                textBoxRate.equals("") || textBoxRecord.equals("")) && NumberInt > 0 && runsInt > 0
                && boundInt > 0 && strikeInt > 0 && NumberInt >= 0 && NumberInt <= 10 && runsInt >= 0
                && boundInt >= 0 && strikeInt >= 0) {

            score.add(team);
            score.add(Integer.parseInt(textBoxNum.getText()));
            score.add(Integer.parseInt(textBoxScore.getText()));
            score.add(Integer.parseInt(textBoxBound.getText()));
            score.add(Integer.parseInt(textBoxRate.getText()));
            score.add(textBoxRecord.getText());
            score.add((String) combo_box.getValue());

        }
    }
}

