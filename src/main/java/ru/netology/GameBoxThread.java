package ru.netology;

public class GameBoxThread extends Thread {
    private String name;
    private ISwitcher switcher;

    final static int checkingTime = 350;
    private final static boolean turnOffTheSwitcher = false;

    public GameBoxThread(String name, ISwitcher switcher) {
        this.name = name;
        this.switcher = switcher;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(checkingTime);
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
            switcher.setStatus(turnOffTheSwitcher);
            System.out.println(name + " turned off the switcher.");
        }
    }
}
