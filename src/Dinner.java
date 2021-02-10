public class Dinner {
    public static void main(String[] args) {
        Thread[] philosoph = new Thread[5];
        Staebchen staebchen[] = new Staebchen[5];
        for (int i = 0; i < 5; ++i) {
            staebchen[i] = new Staebchen();
        }
        for (int i = 0; i < 5; ++i) {
            philosoph[i] = new Philosoph(i, staebchen[(i+4)%5], staebchen[i]);
            philosoph[i].start();
        }
    }
}