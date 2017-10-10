/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplicationn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author paari
 */
public class StudentApplicationn extends Application {
    VBox Layout;
    Scene HomePage;
    Stage MainWindow;
    PopupCalendar MonthlyCalendar;
    PopupGPACalc GPACalculator;
    Text Description;
    Menu OverallMenu;
    MenuItem CalendarLink;
    MenuItem GPACalcLink;
    MenuBar MenuBar;
    
    @Override
    public void start(Stage primaryStage) {
        Description=new Text();
        Description.setFont(new Font(15));
        Description.setText("Hello my name is Paari Gopal and this is my Application.\nIt was made using: \n•JavaFX\n•Java/MySQL Concepts");
        Description.setTextAlignment(TextAlignment.LEFT);
        
        MenuBar=new MenuBar();
        OverallMenu=new Menu("Site Guide");
        
        MainWindow=primaryStage;
        MainWindow.setWidth(1600);
        MainWindow.setHeight(900);
        //CalendarLink serves as a button that links users to the Monthly Calendar
        CalendarLink=new MenuItem();
        CalendarLink.setText("Monthly Calendar");
        
        MonthlyCalendar=new PopupCalendar();
        //setOnAction works to change the scene when the user clicks on the CalendarLink Button so as to bring the user to the Calendar(Uses Lambda Expression)
        CalendarLink.setOnAction(e -> MonthlyCalendar.CreateCalendar(500,450, "Welcome to your calendar","Your personal calendar"));
        
        
        //GPACalcLink serves as a button that links users to the GPA Calculator
        GPACalcLink=new MenuItem();
        GPACalcLink.setText("GPA Calculator");
        
        OverallMenu.getItems().addAll(CalendarLink,GPACalcLink);
        MenuBar.getMenus().add(OverallMenu);
        //setOnAction works to change the scene when the user clicks on the GPACalc Button so as to bring the user to the GPA Calculator(Uses Lambda Expression)
        GPACalcLink.setOnAction(e -> GPACalculator.CreateGPACalc(500,450, "Welcome to your GPA Calculator","Your personal GPA Calculator", MainWindow));
         
        
        Layout=new VBox(50);
        Layout.getChildren().addAll(MenuBar,Description);
        
        HomePage= new Scene(Layout, 500, 450);
        
        
        MainWindow.setTitle("Student Application");
        MainWindow.setScene(HomePage);
        MainWindow.show();
        MainWindow.setFullScreen(true);
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
