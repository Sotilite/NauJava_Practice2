package Tasks;

public class Task1 {
    public static int findLastPositiveElement(int[] array) {
        var lastPositiveElement = 0;
        for(var element : array) {
            if(element > 0) {
                lastPositiveElement = element;
            }
        }
        return lastPositiveElement;
    }
}
