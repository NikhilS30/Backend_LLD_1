package mergesortMultithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort_Client {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> listToSort = List.of(8, 7, 9, 1, 2, 4, 3, 5, 6, 10);

        ExecutorService es = Executors.newCachedThreadPool();
        MergeSort mergeSort = new MergeSort(listToSort, es);
        Future<List<Integer>> futurefinalList = es.submit(mergeSort);

        List<Integer> finalSortedList = futurefinalList.get();

        System.out.println(finalSortedList);
        es.shutdown();
    }
}
