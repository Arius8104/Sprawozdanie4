package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        simE = new SimEngine(3,4.5,0.19,40,35,40,5,10);
        simT = new SimTask(simE, this, 30);
        //Utworzenie obiektu timera i ustawienie odświeżania na 30ms
        timerObject = new Timer();
        timerObject.scheduleAtFixedRate(simT, 0, 30);
    }


    public void paint(Graphics g) {
        //Wyczyszczenie appletu
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        //Rysowanie ukladu wspolrzednych
        g.setColor(Color.LIGHT_GRAY);
        for(int i=0;i<width/20;i++)
        {
            g.drawLine(0,20*i,width,20*i);
            g.drawLine(20*i,0,20*i,height);
        }


        //Rysowanie utwierdzenia
        g.setColor(Color.BLACK);
        g.drawLine(width/2-100,0,width/2-100,scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2-100,scale*(int)simE.getyZawieszenia(),width/2+100,scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2+100,0,width/2+100,scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2-80,0,width/2-100,(int)(scale*simE.getyZawieszenia()/2.8));
        g.drawLine(width/2-60,0,width/2-100,(int)(scale*simE.getyZawieszenia()/1.5));
        g.drawLine(width/2-40,0,width/2-100,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2-20,0,width/2-80,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2,0,width/2-60,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+20,0,width/2-40,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+40,0,width/2-20,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+60,0,width/2,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+80,0,width/2+20,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+100,0,width/2+40,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+100,(int)(scale*simE.getyZawieszenia()/2.8),width/2+60,(int)(scale*simE.getyZawieszenia()));
        g.drawLine(width/2+100,(int)(scale*simE.getyZawieszenia()/1.5),width/2+80,(int)(scale*simE.getyZawieszenia()));

        //Rysowanie sprężyny oraz masy
        g.setColor(Color.BLACK);
        g.drawLine(width/2,scale*(int)simE.getyZawieszenia(),width/2+scale*20,scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2+scale*20,scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale +scale*(int)simE.getyZawieszenia(),width/2-scale*20,2*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2-scale*20,2*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia(),width/2+scale*20,3*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2+scale*20,3*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia(),width/2-scale*20,4*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2-scale*20,4*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia(),width/2+scale*20,5*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia());
        g.drawLine(width/2+scale*20,5*scale*((int)simE.getyMasy()-(int)simE.getyZawieszenia()+(int)simE.getL())/springYScale+scale*(int)simE.getyZawieszenia(),width/2,scale*((int)simE.getyMasy()+(int)simE.getL()));
        g.fillOval( width/2-scale*r,scale*((int)simE.getyMasy()+(int)simE.getL())-5,2*scale*r, 2*scale*r);

        //Rysowanie sil, predkosci, przyspieszen
        g.setColor(Color.RED);
        g.drawLine(width/16,height/2,width/16, height/2+2*(int)simE.getSila().y);
        g.drawLine(width/16+1,height/2,width/16+1, height/2+2*(int)simE.getSila().y);
        g.drawString("Sila",width/16-22,height/2);
        g.setColor(Color.BLUE);
        g.drawLine(width/6,height/2,width/6, height/2+2*(int)simE.getPredk().y);
        g.drawLine(width/6+1,height/2,width/6+1, height/2+2*(int)simE.getPredk().y);
        g.drawString("Predkosc",width/6-55,height/2);
        g.setColor(Color.MAGENTA);
        g.drawLine(width/3,height/2,width/3, height/2+2*(int)simE.getPrzysp().y);
        g.drawLine(width/3+1,height/2,width/3+1, height/2+2*(int)simE.getPrzysp().y);
        g.drawString("Przyspieszenie",width/3-90,height/2);
    }
}