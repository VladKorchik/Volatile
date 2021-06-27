package ru.netology;

public class Switcher implements ISwitcher {
    private volatile boolean status = false;

    public Switcher() {
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
