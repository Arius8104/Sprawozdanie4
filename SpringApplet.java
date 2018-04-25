package lab4;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends JApplet{
    private SimEngine simE;
    private SimTask simT;
    private Timer timerObject;

    private int width = 600;
    private int height = 600;
    private int scale=5;
    private int springYScale = 6;
    private int r=3;
    public void init() {
        //Zdefiniowanie wymiarów okna
        setSize(width, height);
        //Zdefiniowanie obiektów
        simE = new SimEngine(3.5,2.5,0.1,45,20,50,10,10);
        simT = new SimTask(simE, this, 40);
        //Utworzenie obiektu timera i ustawienie odświeżania na 40ms
        timerObject = new Timer();
        timerObject.scheduleAtFixedRate(simT, 0, 40);
    }


    public void paint(Graphics g) {

//Wyczyszczenie appletu
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        //Rysowanie sprężyny oraz masy
        g.setColor(Color.BLACK);
        g.drawLine(width/2,scale*(int)simE.getyZawieszenia(),width/2,scale*((int)simE.getyMasy()+(int)simE.getyZawieszenia()+(int)simE.getL()));
        g.fillOval( width/2-scale*r,scale*((int)simE.getyMasy()+(int)simE.getyZawieszenia()+(int)simE.getL())-5,2*scale*r, 2*scale*r);
    }


    public static void main(String[] args) { }
}
