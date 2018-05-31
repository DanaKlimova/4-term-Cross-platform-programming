package sample;

import javafx.concurrent.Task;

import java.util.ArrayList;

public class CalcExtremums extends Task<Void> {
    private functionValue data;
    private ArrayList<Extremums> extremums;
    private Extremums currExtremums;


    CalcExtremums(functionValue data) {
        this.data = data;
        extremums = new ArrayList<>();
        this.currExtremums = new Extremums();
    }


    @Override
    protected Void call() throws Exception {
        for (int i = 0; i < data.getxList().size(); i++) {
            extremums.add(new Extremums());
            calcPoint point = new calcPoint(i, data.getyList(), extremums.get(i));
            point.start();
            try {
                point.join();
            } catch (InterruptedException ex) {

            }
        }

        if (extremums.size() == 0) {
            System.out.println("не вернулись экстремумы");
        }

        for (int i = 0; i < extremums.size(); i++) {
            Integer max = extremums.get(i).getMax();
            Integer min = extremums.get(i).getMin();

            if (max != null) {
                if (currExtremums.getMax() != null) {

                    if (max > currExtremums.getMax()) {
                        currExtremums.setMax(max);
                    }
                } else {
                    currExtremums.setMax(max);
                }

            }
            if (min != null) {
                if (currExtremums.getMax() != null) {

                    if (min < currExtremums.getMin()) {
                        currExtremums.setMin(min);
                    }
                } else {
                    currExtremums.setMin(min);
                }

            }


        }
        updateMessage("Max: " + currExtremums.getMax() + ", min: " + currExtremums.getMin());
        return null;
    }
}
