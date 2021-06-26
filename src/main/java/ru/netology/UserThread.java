package ru.netology;

public class UserThread extends Thread {
    private String name;

    static int waitingTime = 1000;
    static byte quantityOfSwitching = 5;

    public UserThread(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (byte i = 0; i < quantityOfSwitching; i++) {
                Thread.sleep(waitingTime);
                if (!Main.switcher) {
                    Main.switcher = true;
                    System.out.println(name + " turned on the switcher. ");
                }
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", name);
        }
    }
}
