package ru.netology;

public class Main {
    static volatile boolean switcher = false;

    public static void main(String[] args) throws InterruptedException {

        Thread user = new UserThread("User");
        Thread gameBox = new GameBoxThread("Gamebox");

        gameBox.start();
        user.start();
        user.join();
        gameBox.interrupt();
    }
}
