package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import logic.*;
import logic.Cell;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller  {

    @FXML
    public Button b1;
    private TextField tf1;
    private TextField tf3;
    private TextField tf4;
    private TextArea ta1;
    public Canvas c;
    private PrintStream ps;
    //private PrintStream ps = new PrintStream(new Console(console));

    CanvasPainter cp = new CanvasPainter();
    //GraphicsContext gc = c.getGraphicsContext2D();
    Generation g = new Generation();

    public void initialize() {
        ps = new PrintStream(new Console(ta1)) ;
    }

    /*public void button(ActionEvent event) {
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("Hello World");
    }*/

    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
    }

    /*
    public void button(ActionEvent event) {
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("Hello World");
    }*/

    public void readfile(ActionEvent event) {
        System.setOut(ps);
        System.setErr(ps);
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
        System.setOut(ps);
        System.setErr(ps);
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
        m2.setx(Integer.parseInt(tf4.getText()));
        //tu
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run(/*int count, int stop*/) {
                int x = m2.getx();
                if(x <= 0) {t.cancel();}
                x--;
                m2.setx(x);
                Cell[][] m = m2.getgrid();
                m = gen.generateNext(m);
                cp.clearCanvas(c);
                cp.drawCanvas(c, m);
                m2.savegrid(m);
               //
            }
        }, 0, Integer.parseInt(tf3.getText()));
    }

}

