package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.*;

import java.util.Timer;
import java.util.TimerTask;

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
    private TextField tf4;
    @FXML
    private Label l1;
    @FXML
    public Canvas c;
    CanvasPainter cp = new CanvasPainter();
    //GraphicsContext gc = c.getGraphicsContext2D();
    Generation g = new Generation();

    public void readfile() {
        Config cfg = new Config(1000, 0, tf1.getText(), "cokolwiek");
        FileRead fr = new FileRead(cfg);
        fr.setSize();
        fr.readFile();
        String str[][] = fr.getTemp();
        Grid grid = new Grid(fr.getX(), fr.getY());
        Cell[][] macierz = grid.createInitial(fr.getX(), fr.getY(), str);
        cp.drawCanvas(c, macierz);
    }

    public void start() {
        Config cfg = new Config(1000, 0, tf1.getText(), "cokolwiek");
        FileRead fr = new FileRead(cfg);
        fr.setSize();
        fr.readFile();
        String str[][] = fr.getTemp();
        Grid grid = new Grid(fr.getX(), fr.getY());
        final Cell[][] macierz = grid.createInitial(fr.getX(), fr.getY(), str);
       // cp.drawCanvas(c, macierz);
        Generation gen = new Generation(fr, cfg);
        Grid m2 = new Grid();
        m2.savegrid(macierz);
        //tu
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Cell[][] m = m2.getgrid();
                m = gen.generateNext(m);
                cp.clearCanvas(c);
                cp.drawCanvas(c, m);
                m2.savegrid(m);
                System.out.println("ale");
            }
        }, 0, 1000);
    }

    public void changel1() {
        l1.setText("ahoj");
       // cp.drawCanvas(c, );
    }
}

