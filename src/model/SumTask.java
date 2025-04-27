package model;

public class SumTask implements Runnable{

    private final int[] array;
    private final int start;
    private final int end;
    private long result;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        result = 0;
        for (int i = start; i < end; i++) {
            result += array[i];
        }
    }

    public long getResult() {
        return result;
    }
}
