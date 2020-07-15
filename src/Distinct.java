import java.util.Arrays;
import java.util.Random;

public class Distinct {
    static int MAX_N = 20; //100_000;
    static int MAX_VALUE = 30; //100_000_000;
    static int[] inputs = new int[MAX_N];
    static int[] outputs = new int[MAX_N];

    private static void makeArr() {
        for (int i = 0; i < MAX_N; i++) {
            Random random = new Random();
            inputs[i] = random.nextInt(MAX_VALUE);
        }
    }
    private static void printArr(int[] inputs) {
        Arrays.stream(inputs).forEach(i -> System.out.print(i+", "));
        System.out.println();
    }

    private static void printArr(int[] inputs, int limit) {
        Arrays.stream(Arrays.copyOfRange(inputs, 0, limit)).forEach(i -> System.out.print(i + ", "));
        System.out.println();
    }

    public static void main(String[] args) {
        makeArr();
        double start = System.currentTimeMillis();
        solveDistinct();
        System.out.println(String.format("%s", System.currentTimeMillis() - start));
    }

    private static void solveDistinct() {
        Arrays.sort(inputs);
        printArr(inputs);

        int o = 0;
        outputs[o++] = inputs[0];
        for (int i = 1, length = inputs.length; i < length; i++) {
            if (inputs[i-1] != inputs[i]) {
                outputs[o++] = inputs[i];
            }
        }

        printArr(outputs, o);
    }
}
