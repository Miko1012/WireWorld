package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.*;

public class Controller {
    @FXML
    public Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private Label l1;
    @FXML
    public Canvas c;

    CanvasPainter cp = new CanvasPainter();
    Config cfg = new Config();
    FileRead fr = new FileRead();
    Generation g = new Generation();

    private Cell[][] grid;

    public void readfile() {
        System.out.println(tf1.getText());
        cfg.setinfile(tf1.getText());
        System.out.println("a");
        fr.setConfig(cfg);
        System.out.println("b");
        fr.readFile();
        System.out.println("c");
        g.setargs(fr, cfg);
        Grid gr = new Grid(fr.getX(), fr.getY());
        grid = gr.createInitial(fr.getX(), fr.getY(), fr.getTemp());
        cp.drawCanvas(c, grid);

        //FileRead fr = new FileRead(tf1.getText());
        //fr.readFile();
        //System.out.println(tf1.getText());
        //Generation g = new Generation(fr, cfg);
        //grid = g.generate(fr);
       // cp.drawCanvas(c, grid);
    }

    public void changel1() {
        l1.setText("ahoj");
       // cp.drawCanvas(c, );
    }
}

