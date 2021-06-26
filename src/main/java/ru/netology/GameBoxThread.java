package ru.netology;

public class GameBoxThread extends Thread {
    private String name;

    static int checkingTime = 350;

    public GameBoxThread(String name) {
        this.name = name;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(checkingTime);
                if (Main.switcher) {
                    turnedOffSwitcher();
                }
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            turnedOffSwitcher();
            System.out.printf("%s завершен\n", name);
        }
    }

    public void turnedOffSwitcher() {
        Main.switcher = false;
        System.out.println(name + " turned off the switcher.");
    }
}
