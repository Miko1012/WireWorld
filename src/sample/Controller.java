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
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextArea ta1;
    @FXML
    public Canvas c;
    @FXML
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


    public void start() {
        System.setOut(ps);
        System.setErr(ps);
        boolean op = true;
        Config cfg = new Config(1000, 0, tf1.getText(), tf2.getText());
        FileRead fr = new FileRead(cfg);
        op = fr.setSize();
        if(!op) {return;}
        op = fr.readFile();
    //    System.out.println(op);
        if(!op) {return;}
        String str[][] = fr.getTemp();
        Grid grid = new Grid(fr.getX(), fr.getY());
        final Cell[][] macierz = grid.createInitial(fr.getX(), fr.getY(), str);


        cfg.setoutfile(tf2.getText());
        //System.out.println(cfg.getOutFile());
        FileWrite fw = new FileWrite(cfg, fr);

        if(Integer.parseInt(tf3.getText()) < 1) {System.out.println("Podaj poprawny interwał!"); return;}
        if(Integer.parseInt(tf3.getText()) > 1000) {System.out.println("Podaj poprawny interwał!"); return;}
        if(Integer.parseInt(tf4.getText()) < 1) {System.out.println("Podaj poprawna ilosc generacji!"); return;}
        if(Integer.parseInt(tf4.getText()) > 1000) {System.out.println("Podaj poprawna ilosc generacji!"); return;}

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
        }, Integer.parseInt(tf3.getText()), Integer.parseInt(tf3.getText()));
        fw.writeFile(m2.getgrid());
    }

}

