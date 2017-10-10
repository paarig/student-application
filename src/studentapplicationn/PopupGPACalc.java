/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplicationn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author paari
 */
public class PopupGPACalc implements EventHandler<ActionEvent> {
    
    
    public static void CreateGPACalc(int width, int height, String topdisplay, String windowname, Stage homestage){
        
        VBox CalculatorScreen=new VBox();
        Stage CalculatorStage=new Stage();
        Label CalculatorName=new Label(topdisplay);
        Button ReturnHome=new Button("Go back to home page");
        
        
        
        CheckBox NinthFirstSem=new CheckBox();
        NinthFirstSem.setText("Ninth Grade 1st Semester");
        
        CheckBox NinthSecondSem=new CheckBox();
        NinthSecondSem.setText("Ninth Grade 2nd Semester");
                
        CheckBox TenthFirstSem=new CheckBox();
        TenthFirstSem.setText("Tenth Grade 1st Semester");
                        
        CheckBox TenthSecondSem=new CheckBox();
        TenthSecondSem.setText("Tenth Grade 2nd Semester");
                        
        CheckBox EleventhFirstSem=new CheckBox();
        EleventhFirstSem.setText("Eleventh Grade 1st Semester");
                        
        CheckBox EleventhSecondSem=new CheckBox();
        EleventhSecondSem.setText("Eleventh Grade 2nd Semester");
                        
        CheckBox TwelfthFirstSem=new CheckBox();
        TwelfthFirstSem.setText("Twelfth Grade 1st Semester");
                        
        CheckBox TwelfthSecondSem=new CheckBox();
        TwelfthSecondSem.setText("Twelfth Grade 2nd Semester");
     
        Scene Calculator=new Scene(CalculatorScreen,width,height);
        CalculatorScreen.setSpacing(10);
        
        ReturnHome.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                CalculatorStage.close();
            }
        });
        
        Button Done=new Button();
        Done.setText("If you are done making choices, click this button");
        
        Done.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                Checker(NinthFirstSem, NinthSecondSem, TenthFirstSem, TenthSecondSem, EleventhFirstSem, EleventhSecondSem, TwelfthFirstSem, TwelfthSecondSem);
                Scene Calculations= SceneChanger(NinthFirstSem.isSelected(), NinthSecondSem.isSelected(), TenthFirstSem.isSelected(), TenthSecondSem.isSelected(), EleventhFirstSem.isSelected(), EleventhSecondSem.isSelected(), TwelfthFirstSem.isSelected(), TwelfthSecondSem.isSelected(), Calculator, CalculatorStage );
                CalculatorStage.setScene(Calculations);
            }
        });
        CalculatorStage.setTitle(windowname);
        CalculatorStage.initModality(Modality.APPLICATION_MODAL);
        CalculatorStage.setFullScreen(true);
        CalculatorScreen.getChildren().addAll(CalculatorName, NinthFirstSem, NinthSecondSem, TenthFirstSem, TenthSecondSem, EleventhFirstSem, EleventhSecondSem, TwelfthFirstSem, TwelfthSecondSem, Done, ReturnHome);
        CalculatorScreen.setAlignment(Pos.CENTER);
        
        
        

        CalculatorStage.setWidth(1600);
        CalculatorStage.setHeight(900);
        CalculatorStage.setScene(Calculator);
        CalculatorStage.show();
        CalculatorStage.showAndWait();
    }
    
    public static Scene SceneChanger(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6, boolean b7, boolean b8, Scene initialscene, Stage wholestage){
        VBox CalculatorScreen=new VBox();
        Label CalculatorName=new Label("Type in your grades below");
        Button ReturnHome=new Button("Go back to the homepage of the application");
        ReturnHome.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                wholestage.close();
            }
        });
        Button ReturntoMenu=new Button("Go back to recheck the classes you have taken");
        ReturntoMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                wholestage.setScene(initialscene);
            }
        });    
        
        double SemesterCounter=0.000;
        
        double UnweightedGPASum=0.000;
        
        double WeightedGPASum=0.000;
        
        CalculatorScreen.getChildren().add(CalculatorName);
        if(b1==true){
        
        Label NinthGrade1=new Label("Type your 9th Grade 1st Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(NinthGrade1);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;
        
        HBox NinthGrade1stSem=new HBox();
        NinthGrade1stSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        NinthGrade1stSem.setSpacing(10);
        CalculatorScreen.getChildren().add(NinthGrade1stSem);
        }
        if(b2==true){
        Label NinthGrade2=new Label("Type your 9th Grade 2nd Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(NinthGrade2);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third ");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;
        
        HBox NinthGrade2ndSem=new HBox();
        NinthGrade2ndSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        NinthGrade2ndSem.setSpacing(10);
        CalculatorScreen.getChildren().add(NinthGrade2ndSem);
        
        }
        if(b3==true){
        Label TenthGrade1=new Label("Type your 10th Grade 1st Semester Grades Below by Period");
        Label firstLabel=new Label("First");
        CalculatorScreen.getChildren().add(TenthGrade1);        
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
     
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++; 
        
        HBox TenthGrade1stSem=new HBox();
        TenthGrade1stSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        TenthGrade1stSem.setSpacing(10);
        CalculatorScreen.getChildren().add(TenthGrade1stSem);        
        }
        if(b4==true){
        Label TenthGrade2=new Label("Type your 10th Grade 2nd Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(TenthGrade2);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
      
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;
        
        HBox TenthGrade2ndSem=new HBox();
        TenthGrade2ndSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        TenthGrade2ndSem.setSpacing(10);
        CalculatorScreen.getChildren().add(TenthGrade2ndSem);
        }
        if(b5==true){
        Label EleventhGrade1=new Label("Type your 11th Grade 1st Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(EleventhGrade1);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;

        HBox EleventhGrade1stSem=new HBox();
        EleventhGrade1stSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        EleventhGrade1stSem.setSpacing(10);
        CalculatorScreen.getChildren().add(EleventhGrade1stSem);
        }
        if(b6==true){
        Label EleventhGrade2=new Label("Type your 11th Grade 2nd Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(EleventhGrade2);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;
        
        HBox EleventhGrade2ndSem=new HBox();
        EleventhGrade2ndSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        EleventhGrade2ndSem.setSpacing(10);
        CalculatorScreen.getChildren().add(EleventhGrade2ndSem);
        }
        if(b7==true){
        Label TwelfthGrade1=new Label("Type your 12th Grade 1st Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(TwelfthGrade1);
        
        Label firstLabel=new Label("First");
      
        TextField firstClass=new TextField();
        firstClass.setMaxWidth(1);
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();
        secondClass.setMaxWidth(1);
        
        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        thirdClass.setMaxWidth(1);
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        fourthClass.setMaxWidth(1);
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        fifthClass.setMaxWidth(1);
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        sixthClass.setMaxWidth(1);
        
        Label sixthLabel=new Label("Sixth");
        
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;        
        
        HBox TwelfthGrade1stSem=new HBox();
        TwelfthGrade1stSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        TwelfthGrade1stSem.setSpacing(10);
        CalculatorScreen.getChildren().add(TwelfthGrade1stSem);
        }   
        if(b8==true){
        Label TwelfthGrade2=new Label("Type your 12th Grade 2nd Semester Grades Below by Period");
        CalculatorScreen.getChildren().add(TwelfthGrade2);
        
        Label firstLabel=new Label("First");
        
        TextField firstClass=new TextField();
        firstClass.setText("ex. A-");
        
        CheckBox firstCheck=new CheckBox("AP/IB?");
        
        TextField secondClass=new TextField();

        Label secondLabel=new Label("Second"); 
        
        CheckBox secondCheck=new CheckBox("AP/IB?");
        
        TextField thirdClass=new TextField();
        
        Label thirdLabel=new Label("Third");
        
        CheckBox thirdCheck=new CheckBox("AP/IB?");        
        
        TextField fourthClass=new TextField();
        
        Label fourthLabel=new Label("Fourth");
        
        CheckBox fourthCheck=new CheckBox("AP/IB?");    
        
        TextField fifthClass=new TextField();
        
        Label fifthLabel=new Label("Fifth");
        
        CheckBox fifthCheck=new CheckBox("AP/IB?");        
        
        TextField sixthClass=new TextField();
        
        Label sixthLabel=new Label("Sixth");
       
        CheckBox sixthCheck=new CheckBox("AP/IB?");
        
        UnweightedGPASum+=UnweightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        WeightedGPASum+=WeightedGPACalc(firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, firstCheck, secondCheck, thirdCheck, fourthCheck, fifthCheck, sixthCheck);
        
        SemesterCounter++;        
        
        HBox TwelfthGrade2ndSem=new HBox();
        TwelfthGrade2ndSem.getChildren().addAll(firstLabel, firstClass, firstCheck, secondLabel, secondClass, secondCheck, thirdLabel, thirdClass, thirdCheck, fourthLabel, fourthClass, fourthCheck, fifthLabel, fifthClass, fifthCheck, sixthLabel, sixthClass, sixthCheck);
        TwelfthGrade2ndSem.setSpacing(10);
        CalculatorScreen.getChildren().add(TwelfthGrade2ndSem);
        }
        
        //UnweightedGPASum/=SemesterCounter;
        
        //WeightedGPASum/=SemesterCounter;
        
        Button Done=new Button();
        Done.setText("After typing in all your grades click here");
        
        
       
 
        CalculatorScreen.getChildren().addAll(Done, ReturntoMenu, ReturnHome);
        CalculatorScreen.setAlignment(Pos.CENTER);
        
        
        Scene Calculator=new Scene(CalculatorScreen,500,450);
        CalculatorScreen.setSpacing(10);
        
        return Calculator;
    }
    
    public static void Checker(CheckBox c1, CheckBox c2, CheckBox c3, CheckBox c4, CheckBox c5, CheckBox c6, CheckBox c7, CheckBox c8){
        if(c8.isSelected()){
            c7.setSelected(true);
        }
        if(c7.isSelected()){
            c6.setSelected(true);
        }        
        if(c6.isSelected()){
            c5.setSelected(true);
        }
        if(c5.isSelected()){
            c4.setSelected(true);
        }        
        if(c4.isSelected()){
            c3.setSelected(true);
        }        
        if(c3.isSelected()){
            c2.setSelected(true);
        }        
        if(c2.isSelected()){
            c1.setSelected(true);
        }              
        
    }
    
    public static double WeightedGradeCalc(TextField firsttext, CheckBox firstcheck){
        double classgrade=0.000;
        if(firsttext.getText().toLowerCase()=="a"){
            classgrade=4.000;
        }
        else if(firsttext.getText().toLowerCase()=="a-"){
            classgrade=3.700;
        }
        else if(firsttext.getText().toLowerCase()=="b+"){
            classgrade=3.300;
        }
        else if(firsttext.getText().toLowerCase()=="b"){
            classgrade=3.000;
        }
        else if(firsttext.getText().toLowerCase()=="b-"){
            classgrade=2.700;
        }
        else if(firsttext.getText().toLowerCase()=="c+"){
            classgrade=2.300;
        }
        else if(firsttext.getText().toLowerCase()=="c"){
            classgrade=2.000;
        }
        else if(firsttext.getText().toLowerCase()=="c-"){
            classgrade=1.700;
        }
        else if(firsttext.getText().toLowerCase()=="d+"){
            classgrade=1.300;
        }
        else if(firsttext.getText().toLowerCase()=="d"){
            classgrade=1.000;
        }
        else if(firsttext.getText().toLowerCase()=="d-"){
            classgrade=0.700;
        }
        else if(firsttext.getText().toLowerCase()=="f"){
            classgrade=0.000;
        }
        else{
            classgrade=-1000.000;
        }
        if(firstcheck.isSelected()){
            classgrade+=1.000;
        }
        return classgrade;
    }
      
    public static double UnweightedGradeCalc(TextField firsttext, CheckBox firstcheck){
        double classgrade=0.000;
        if(firsttext.getText().toLowerCase()=="a"){
            classgrade=4.000;
        }
        else if(firsttext.getText().toLowerCase()=="a-"){
            classgrade=3.700;
        }
        else if(firsttext.getText().toLowerCase()=="b+"){
            classgrade=3.300;
        }
        else if(firsttext.getText().toLowerCase()=="b"){
            classgrade=3.000;
        }
        else if(firsttext.getText().toLowerCase()=="b-"){
            classgrade=2.700;
        }
        else if(firsttext.getText().toLowerCase()=="c+"){
            classgrade=2.300;
        }
        else if(firsttext.getText().toLowerCase()=="c"){
            classgrade=2.000;
        }
        else if(firsttext.getText().toLowerCase()=="c-"){
            classgrade=1.700;
        }
        else if(firsttext.getText().toLowerCase()=="d+"){
            classgrade=1.300;
        }
        else if(firsttext.getText().toLowerCase()=="d"){
            classgrade=1.000;
        }
        else if(firsttext.getText().toLowerCase()=="d-"){
            classgrade=0.700;
        }
        else if(firsttext.getText().toLowerCase()=="f"){
            classgrade=0.000;
        }
        else{
            classgrade=-1000.000;
        }
        return classgrade;
    }    

    public static double WeightedGPACalc(TextField first, TextField second, TextField third, TextField fourth, TextField fifth, TextField sixth, CheckBox firstcheck, CheckBox secondcheck, CheckBox thirdcheck, CheckBox fourthcheck, CheckBox fifthcheck, CheckBox sixthcheck){
        double weightedgpa=0.000;
        weightedgpa+=WeightedGradeCalc(first, firstcheck);
        weightedgpa+=WeightedGradeCalc(second, secondcheck);
        weightedgpa+=WeightedGradeCalc(third, thirdcheck);
        weightedgpa+=WeightedGradeCalc(fourth, fourthcheck);
        weightedgpa+=WeightedGradeCalc(fifth, fifthcheck);
        weightedgpa+=WeightedGradeCalc(sixth, sixthcheck);
        weightedgpa/=6.000;
        return weightedgpa;
    }
    
    public static double UnweightedGPACalc(TextField first, TextField second, TextField third, TextField fourth, TextField fifth, TextField sixth, CheckBox firstcheck, CheckBox secondcheck, CheckBox thirdcheck, CheckBox fourthcheck, CheckBox fifthcheck, CheckBox sixthcheck){
        double unweightedgpa=0.000;
        unweightedgpa+=UnweightedGradeCalc(first, firstcheck);
        unweightedgpa+=UnweightedGradeCalc(second, secondcheck);
        unweightedgpa+=UnweightedGradeCalc(third, thirdcheck);
        unweightedgpa+=UnweightedGradeCalc(fourth, fourthcheck);
        unweightedgpa+=UnweightedGradeCalc(fifth, fifthcheck);
        unweightedgpa+=UnweightedGradeCalc(sixth, sixthcheck);
        unweightedgpa/=6.000;
        return unweightedgpa;
    }
    
    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

