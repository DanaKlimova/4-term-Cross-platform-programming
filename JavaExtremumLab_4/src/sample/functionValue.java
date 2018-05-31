package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observable;

public class functionValue {
    private ArrayList<Integer> xList;
    private ArrayList<Integer> yList;
    private ArrayList<Subscriber> subscribers;

    functionValue() {
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
        subscribers = new ArrayList<Subscriber>();
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void notifySubscribers() {
        for (Subscriber s:this.subscribers) {
            s.update(this);
        }
    }

    public ArrayList<Integer> getxList() {
        return xList;
    }

    public ArrayList<Integer> getyList() {
        return yList;
    }
}
