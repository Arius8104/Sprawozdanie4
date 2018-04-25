package lab4;

public class SimEngine {
    private double masa;
    private double k;
    private double c;
    private double dlugosc;
    private double yMasy;
    private double predk;
    private double yZawieszenia;
    private double g;
    private double sila;
    private double przysp;

    //Konstruktor z parametrami
    public SimEngine(double masa, double k, double c, double dlugosc, double yMasy, double predk, double yZawieszenia, double g) {
        this.masa = masa;
        this.k = k;
        this.c = c;
        this.dlugosc = dlugosc;
        this.yMasy = yMasy;
        this.predk = predk;
        this.yZawieszenia = yZawieszenia;
        this.g = g;
    }

    //Gettery
    public double getMasa() {
        return masa;
    }

    public double getK() {
        return k;
    }

    public double getC() {
        return c;
    }

    public double getL() {
        return dlugosc;
    }

    public double getyMasy() {
        return yMasy;
    }

    public double getV() {
        return predk;
    }

    public double getyZawieszenia() {
        return yZawieszenia;
    }

    public double getG() {
        return g;
    }

    //Settery
    public void setMasa(double masa) {
        this.masa = masa;
    }

    public void setK(double k) {
        this.k = k;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setL(double l) {
        this.dlugosc = l;
    }

    public void setyMasy(double yMasy) {
        this.yMasy = yMasy;
    }

    public void setV(double v) {
        this.predk = v;
    }

    public void setyZawieszenia(double yZawieszenia) {
        this.yZawieszenia = yZawieszenia;
    }

    public void setG(double g) {
        this.g = g;
    }

    //Główna metoda symulująca fizykę wahadła
    public void przebiegSymulacji(int delay)
    {
        sila = -k*(yMasy-yZawieszenia) - c * predk;
        przysp = sila/masa;
        predk = predk + przysp * delay/500;
        yMasy = yMasy + predk * delay/500 + przysp*delay*delay/125000;
    }

    //Metoda ustawiająca prędkość na 0
    public void reset(){
        predk=0;
    }
}