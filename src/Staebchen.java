public class Staebchen {
    // Attribut
    private boolean wirdBenutzt = false;
    //get()-Methode
    public synchronized void get() throws InterruptedException
    {
        while(wirdBenutzt)
        {
            System.out.println("Philosoph muss auf ein Stäbchen warten.");
            wait();
        }
        wirdBenutzt = true;
    }

    //put()-Methode
    public synchronized void put()
    {
        wirdBenutzt = false;
        notifyAll();
    }

}