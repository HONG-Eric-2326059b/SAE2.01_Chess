package Chess;

public class Timer {
    private int secondsRestante;
    private boolean lancement;
    private Thread Time;

    public Timer(int seconds) {
        this.secondsRestante = seconds;
        this.lancement = false;
    }

    public void start() {
        if (!lancement) {
            lancement = true;
            Time = new Thread(() -> {
                try {
                    while (secondsRestante > 0) {
                        Thread.sleep(1000);
                        secondsRestante--;
                    }
                } catch (InterruptedException e) {
                }
            });
            Time.start();
        }
    }

    public void stop() {
        if (lancement && Time != null) {
            lancement = false;
            Time.interrupt();
        }
    }

    public int getSecondsRestante() {
        return secondsRestante;
    }

    public boolean Lancement() {
        return lancement;
    }
}
