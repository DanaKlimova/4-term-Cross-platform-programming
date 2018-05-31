package sample;

import java.util.ArrayList;

public class calcPoint extends Thread {
    int index;
    Extremums retValue;
    ArrayList<Integer> values;

    calcPoint(int index, ArrayList<Integer> values, Extremums retValue) {
        this.index = index;
        this.values = values;
        this.retValue = retValue;
    }
    @Override
    public void run() {
        if (values.isEmpty()) {

        } else {
            if (index == 0) {
                if (values.size() == 1) {
                    retValue.setMax(values.get(0));
                    retValue.setMin(values.get(0));
                } else {
                    if (values.get(0) > values.get(1)) {
                        retValue.setMax(values.get(0));
                        retValue.setMin(null);
                    } else {
                        retValue.setMax(null);
                        retValue.setMin(values.get(0));
                    }
                }
            }

            if (index == values.size() - 1) {
                if (values.get(index) > values.get(index - 1)) {
                    retValue.setMin(null);
                    retValue.setMax(values.get(index));
                } else {
                    retValue.setMin(values.get(index));
                    retValue.setMax(null);
                }
            }

            if (index != values.size() - 1 && index != 0) {

                if (values.get(index) > values.get(index - 1) && values.get(index) > values.get(index + 1)) {
                    retValue.setMin(null);
                    retValue.setMax(values.get(index));
                } else if (values.get(index) < values.get(index - 1) && values.get(index) < values.get(index + 1)) {
                    retValue.setMax(null);
                    retValue.setMin(values.get(index));
                } else {
                    retValue.setMax(null);
                    retValue.setMin(null);
                }
            }
        }
    }
}
