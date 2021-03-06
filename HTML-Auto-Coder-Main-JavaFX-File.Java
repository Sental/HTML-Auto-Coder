/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.auto.coder;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.geometry.Pos.CENTER_RIGHT;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;

/**
 *
 * @author Mark
 */
public class HTMLAutoCoder extends Application {
    
    Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
    
    Label paragraphLabel = new Label("Enter Paragraphs here then press the button.");
    TextArea paragraph = new TextArea();
    Button pbtn = new Button();
    
    Label largeHeadingLabel = new Label("Enter large heading here then press the button.");
    TextArea largeHeading = new TextArea();
    Button lHbtn = new Button();
    
    Label headingLabel = new Label("Enter a heading here then press the button.");
    TextArea heading = new TextArea();
    Button hbtn = new Button();
    
    Label subHeadingLabel = new Label("Enter a sub heading here then press the button.");
    TextArea subHeading = new TextArea();
    Button sHbtn = new Button();
    
    Label smallSubHeadingLabel = new Label("Enter a small sub heading here then press the button.");
    TextArea smallSubHeading = new TextArea();
    Button sSHbtn = new Button();
    
    Label imageLabel = new Label("Enter an image link here then press the button.");
    TextArea image = new TextArea();
    Button ibtn = new Button();
    
    Button prbtn = new Button("Preview");
    
    Label completeLabel = new Label("Your complete code is displayed here:");
    TextArea complete = new TextArea();
        
    
    @Override
    public void start(Stage primaryStage) {
        TextArea temp2 = new TextArea("0");
                
        paragraph.setWrapText(true);
        largeHeading.setWrapText(true);
        heading.setWrapText(true);
        subHeading.setWrapText(true);
        smallSubHeading.setWrapText(true);
        image.setWrapText(true);
        complete.setWrapText(true);
        
        VBox psub = new VBox(paragraphLabel, paragraph);
        psub.setMinWidth(966);
        HBox p = new HBox(psub, pbtn);
        
        VBox lhsub = new VBox(largeHeadingLabel, largeHeading);
        lhsub.setMinWidth(966);
        HBox lh = new HBox(lhsub, lHbtn);
        
        VBox hsub = new VBox(headingLabel, heading);
        hsub.setMinWidth(966);
        HBox h = new HBox(hsub, hbtn);
        
        VBox shsub = new VBox(subHeadingLabel, subHeading);
        shsub.setMinWidth(966);
        HBox sh = new HBox(shsub, sHbtn);
        
        VBox sshsub = new VBox(smallSubHeadingLabel, smallSubHeading);
        sshsub.setMinWidth(966);
        HBox ssh = new HBox(sshsub, sSHbtn);
        
        VBox isub = new VBox(imageLabel, image);
        isub.setMinWidth(966);
        HBox i = new HBox(isub, ibtn);
        
        VBox lsm = new VBox(p, lh, h, sh, ssh, i);
        lsm.setMinWidth(1266);
        
        Button alignleft = new Button("Align Left");
        alignleft.setOnAction(e -> {
            temp2.setText("3");
        });
        Button alignright = new Button("Align Right");
        alignright.setOnAction(e -> {
            temp2.setText("4");
        });
        Button alignjustify = new Button("Align Justify");
        alignjustify.setOnAction(e -> {
            temp2.setText("1");
        });
        Button aligncentre = new Button("Align Centre");
        aligncentre.setOnAction(e -> {
            temp2.setText("2");
        });
        Button underline = new Button("Underline");
        underline.setOnAction(e -> {
            temp2.setText("5");
        });
                
        pbtn.setText("Add a paragraph to completion Box");
        pbtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(paragraph, Style));
            paragraph.clear();
            temp2.setText("0");}
        });
        
        lHbtn.setText("Add a large heading to completion Box");
        lHbtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(largeHeading, Style));
            largeHeading.clear();
            temp2.setText("0");}
        });
        
        hbtn.setText("Add a heading to completion Box");
        hbtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(heading, Style));
            heading.clear();
            temp2.setText("0");}
        });
        
        sHbtn.setText("Add a subheading to completion Box");
        sHbtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(subHeading, Style));
            subHeading.clear();
            temp2.setText("0");}
        });
        
        sSHbtn.setText("Add a small suubheading to completion Box");
        sSHbtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(smallSubHeading, Style));
            smallSubHeading.clear();
            temp2.setText("0");}
        });
        
        ibtn.setText("Add an image to completion Box");
        ibtn.setOnAction(e -> {
            if (temp2.getText().equalsIgnoreCase("error") || temp2.getText() == null) {final int Style = 0;}
        else{
        final int Style = Integer.parseInt(temp2.getText());
            complete.appendText(addMarkUp(image, Style));
            image.clear();
            temp2.setText("0");}
        });
        
        prbtn.setOnAction(e -> {
            showhtml();
        });
        
        VBox srsm = new VBox(100, alignleft, aligncentre, alignright, alignjustify, underline);
        VBox rsm = new VBox(srsm);
        rsm.setMinWidth(100);
        
        rsm.setAlignment(CENTER_RIGHT);
        HBox subMaster = new HBox(lsm, rsm);
        
        VBox master = new VBox(subMaster, complete, prbtn);
        
        StackPane root = new StackPane();
        root.getChildren().add(master);
        
        Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());
        
        primaryStage.setTitle("HTML Auto Coder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public String addMarkUp(TextArea p, int i) {
        String style;
        if (addStyle(i) == null || addStyle(i).equalsIgnoreCase("error") || i == 0) {style = "";}
        else {style = addStyle(i);}
        String fm;
        String lm;
        TextArea temp = new TextArea();
        String ta = p.getText();

    if (p == paragraph) {
        fm = "<p " + style + ">";
        lm = "</p>";
        temp.setText(fm + ta + lm);
    }
    else if (p == largeHeading) {
        fm = "<h1 " + style + ">";
        lm = "</h1>";
        temp.setText(fm + ta + lm);
    }
    else if (p == heading) {
        fm = "<h2 " + style + ">";
        lm = "</h2>";
        temp.setText(fm + ta + lm);
    }
    else if (p == subHeading) {
        fm = "<h3 " + style + ">";
        lm = "</h3>";
        temp.setText(fm + ta + lm);
    }
    else if (p == smallSubHeading) {
        fm = "<h4 " + style + ">";
        lm = "</h4>";
        temp.setText(fm + ta + lm);
    }
    else if (p == image) {
        fm = "<img src='";
        lm = "' " + style + ">";
        temp.setText(fm + ta + lm);
    }
    return temp.getText();
    }
public String addStyle(int i) {
TextArea style = new TextArea();
switch(i) {
    case 1: style.setText("text-align: justify;"); break;
    case 2: style.setText("text-align: center;"); break;
    case 3: style.setText("text-align: left;"); break;
    case 4: style.setText("text-align: right;"); break;
    case 5: style.setText("text-decoration: underline;"); break;
    default: style.setText("error"); break;
}
if (style.getText() == null || style.getText().equalsIgnoreCase("error")) {
    String error = "error";
    return error;
}
else {
    String result = "style='" + style.getText() + "'";
    return result;
}
}

public void showhtml() {
    String write = "<html><head></head><body>" + complete.getText() + "</body></html>";
    String file = "preview.html";
    try {
    FileWriter w = new FileWriter(file);
    BufferedWriter writer = new BufferedWriter(w);
    writer.write(write);
    writer.close();}
    catch (IOException e) {
        System.out.println(e);
    }
    
    URI oURL;
        try {
            oURL = new URI("preview.html");
            Desktop.getDesktop().browse(oURL);}
    catch (IOException e) {
        System.out.println(e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(HTMLAutoCoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
