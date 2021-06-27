package ru.netology;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Switcher switcher = new Switcher();

        Thread user = new UserThread("User", switcher);
        Thread gameBox = new GameBoxThread("Gamebox", switcher);

        gameBox.start();
        user.start();
        user.join();
        gameBox.interrupt();
    }
}
