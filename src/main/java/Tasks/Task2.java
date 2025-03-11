package Tasks;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class Task2 {
    public static void selectionSort(ArrayList<Double> list) {
        for(var i = 0; i < list.size() - 1; i++) {
            var minIndex = i;
            for(var j = i + 1; j < list.size(); j++) {
                if(list.get(minIndex) > list.get(j)) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                swap(list, minIndex, i);
            }
        }
    }
}
