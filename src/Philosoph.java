import java.util.Random;
public class Philosoph extends Thread {
    private static Random rand = new Random();
    // Attribute
    int id;
    Staebchen[] staebchen;

    // Konstruktor
    public Philosoph(int id, Staebchen s1, Staebchen s2)
    {
        this.id=id;
        staebchen = new Staebchen[]{s1,s2};
    }
    // run()-Methode
    public void run() {
        try {
            while(true) {
                // denken
                System.out.println("Philosoph "+ id + " denkt");
                Thread.sleep(rand.nextInt(500) + 500);

                // hungrig (versuche Staebchen zu erhalten)
                if(id==0)
                {
                    staebchen[0].get();
                    staebchen[1].get();
                }
                else
                {
                    staebchen[1].get();
                    staebchen[0].get();
                }

                // essen
                System.out.println("Philosoph "+ id + " isst");
                Thread.sleep(rand.nextInt(500) + 500);

                // satt (lege Staebchen zurück)
                staebchen[0].put();
                staebchen[1].put();
            }
        }
        catch(InterruptedException ie) {
        }
    }
}