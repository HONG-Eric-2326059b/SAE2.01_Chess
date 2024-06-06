package Chess;

public class Timer {

    private String minute;
    private String sec;

    public void Rapide10() throws InterruptedException {
        int i = 600;
        while (i != 0){
            i = i -1;
            Thread.sleep(1000);
        }
        System.out.println("Loose");
    }

    public void blitz3() throws InterruptedException {
        int i = 360;
        while (i != 0){
            i = i - 1;
            Thread.sleep(1000);
        }
        System.out.println("Loose");
    }



}
