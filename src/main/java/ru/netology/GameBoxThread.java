package ru.netology;

public class GameBoxThread extends Thread {
    private String name;
    private Switchable switcher;

    final static int CHEKING_TIME = 350;
    private final static boolean TURN_ON_THE_SWITCHER = false;

    public GameBoxThread(String name, Switchable switcher) {
        this.name = name;
        this.switcher = switcher;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(CHEKING_TIME);
                turnOff();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            turnOff();
            System.out.printf(name + " завершен.");
        }
    }

    private void turnOff() {
        if (switcher.getStatus()) {
            switcher.setStatus(TURN_ON_THE_SWITCHER);
            System.out.println(name + " turned off the switcher.");
        }
    }
}
