package studentapplicationn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author paari
 */
public class PopupCalendar {
    
    public static void CreateCalendar(int width, int height, String topdisplay, String windowname){
        GridPane CalendarScreen=new GridPane();
        Stage CalendarStage=new Stage();
        Label CalendarName=new Label(topdisplay);
        Button ReturnHome=new Button("Go back to home page");
        DatePicker CalendarDate=new DatePicker();
        
        CalendarStage.setTitle(windowname);
        CalendarStage.initModality(Modality.APPLICATION_MODAL);
        
        VBox topbox=new VBox(20);
        topbox.setPadding(new Insets(10));
        topbox.setSpacing(10);
        topbox.getChildren().add(CalendarDate);
        VBox.setMargin(topbox, new Insets(20));
        
        CalendarScreen.setAlignment(Pos.CENTER);
        CalendarScreen.setVgap(20);
        CalendarScreen.setHgap(20);        
        CalendarScreen.setPadding(new Insets(10));
        CalendarScreen.getChildren().addAll(CalendarName,topbox,ReturnHome);
        
        Scene Calendar=new Scene(CalendarScreen,width,height);
        
        ReturnHome.setOnAction(e -> CalendarStage.close());
        
        CalendarStage.setWidth(1600);
        CalendarStage.setHeight(900);
        
        CalendarStage.setScene(Calendar);
        CalendarStage.show();
        CalendarStage.showAndWait();
        

    }
}

