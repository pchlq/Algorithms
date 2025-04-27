import model.SumTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int numberOfThreads = 2;
        int len = array.length;
        SumTask[] tasks = new SumTask[numberOfThreads];

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * (len / numberOfThreads);
            int end = (i + 1) * (len / numberOfThreads);
            if (i == numberOfThreads - 1) {
                end = len;
            }
            tasks[i] = new SumTask(array, start, end);
            executorService.execute(tasks[i]);
        }

        long totalSum = 0;
        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        for (SumTask st : tasks) {
            totalSum += st.getResult();
        }

        System.out.println("Total sum = " + totalSum);
    }

//    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        int numberOfThreads = 2;
//        int len = array.length;
//        SumTask[] tasks = new SumTask[numberOfThreads];
//
//        ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
//
//        for (int i = 0; i < numberOfThreads; i++) {
//            int start = i * (len / numberOfThreads);
//            int end = (i + 1) * (len / numberOfThreads);
//            if (i == numberOfThreads - 1) {
//                end = len;
//            }
//            tasks[i] = new SumTask(array, start, end);
//            es.execute(tasks[i]);
//        }
//
//        long totalSum = 0;
//        es.shutdown();
//
//        while (!es.isTerminated()) {
//            // Ожидать завершения выполнения всех потоков
//        }
//
//        for (SumTask st : tasks) {
//            totalSum += st.getResult();
//        }
//
//        System.out.println("Sum=" + totalSum);
//    }
}
