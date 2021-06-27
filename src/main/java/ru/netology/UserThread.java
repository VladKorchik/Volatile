package ru.netology;

public class UserThread extends Thread {
    private String name;
    private ISwitcher switcher;

    private final static int waitingTime = 1000;
    private final static byte quantityOfSwitching = 5;
    private final static boolean turnOnTheSwitcher = true;

    public UserThread(String name, ISwitcher switcher) {
        this.name = name;
        this.switcher = switcher;
    }

    public void run() {
        try {
            for (byte i = 0; i < quantityOfSwitching; i++) {
                Thread.sleep(waitingTime);
                if (!switcher.getStatus()) {
                    switcher.setStatus(turnOnTheSwitcher);
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
