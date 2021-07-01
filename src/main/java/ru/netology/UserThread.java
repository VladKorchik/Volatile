package ru.netology;

public class UserThread extends Thread {
    private String name;
    private Switchable switcher;

    private final static int WAITING_TIME = 1000;
    private final static byte QUANTITY_OF_SWITCHING = 5;
    private final static boolean TURN_ON_THE_SWITCHER = true;

    public UserThread(String name, Switchable switcher) {
        this.name = name;
        this.switcher = switcher;
    }

    public void run() {
        try {
            for (byte i = 0; i < QUANTITY_OF_SWITCHING; i++) {
                Thread.sleep(WAITING_TIME);
                if (!switcher.getStatus()) {
                    switcher.setStatus(TURN_ON_THE_SWITCHER);
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
