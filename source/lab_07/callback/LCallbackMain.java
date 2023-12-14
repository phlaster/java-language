package ru.java.callback;

import java.util.ArrayList;

public class LCallbackMain {
    ArrayList<LINotifier> notifires = new ArrayList<>(3);

    public static void main(String[] args) {
        LCallbackMain cm = new LCallbackMain();
        cm.init(new LPhone());
        cm.init(new LPhone());
        cm.init(new LPhone());
        cm.init(new LRadio());
        cm.init(new LTv());

        cm.sendNotification();

    }

    public void init(LINotifier n) {
        this.notifires.add(n);
    }

    public void sendNotification() {
        for (LINotifier n : this.notifires) {
            n.mynotify();
        }
    }
}
