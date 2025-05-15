package mergesortMultithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort_Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(8, 7, 9, 1, 2, 4, 3, 5, 6, 10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        mergeSort mergeSorter = new mergeSort(listToSort, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);

        List<Integer> sortedList = sortedListFuture.get();

        System.out.println(sortedList);
    }
}