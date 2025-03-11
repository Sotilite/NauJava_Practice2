package Tasks;

public class Task1 {
    public static int findLastPositiveElement(int[] array) {
        var lastPositiveElement = -1;
        for(var element : array) {
            if(lastPositiveElement < element) {
                lastPositiveElement = element;
            }
        }
        return lastPositiveElement;
    }
}
