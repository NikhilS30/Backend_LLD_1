package mergesortMultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {

	private List<Integer> listToSort;
	private ExecutorService es;

	public MergeSort(List<Integer> listToSort, ExecutorService es) {
		this.listToSort = listToSort;
		this.es = es;
	}

	@Override
	public List<Integer> call() throws Exception {

		if (listToSort.size() <= 1)  //agar mere paas ek hi element bacha hoto kya muje divide karna hai? no mai direct return kawra duga
			return listToSort;

		int mid = listToSort.size() / 2; 

		List<Integer> leftListToSort = new ArrayList<>(listToSort.subList(0, mid)); //0 to mid ki list bana li
		List<Integer> rightListToSort = new ArrayList<>(listToSort.subList(mid, listToSort.size())); //mid to size ki bana li

		MergeSort leftMergeSort = new MergeSort(leftListToSort, es);  //ab maine ye mergesort ko dedia ki sort karke dedo
		MergeSort rightMergeSort = new MergeSort(rightListToSort, es);

		Future<List<Integer>> futureLeftSortedList = es.submit(leftMergeSort); //isne muje ek future list bucket diya ki mai left sorted list tumhe isme duga
		Future<List<Integer>> futureRightSortedList = es.submit(rightMergeSort); //isne muje ek future list bucket diya ki mai right sorted list tumhe isme duga

		List<Integer> leftSortedList = futureLeftSortedList.get();  //muje ab left sorted list mil gayi hai
		List<Integer> rightSortedList = futureRightSortedList.get(); //muje ab right sorted list mil gayi hai

		// Merge both sorted halves
		List<Integer> finalAns = new ArrayList<>();
		int i = 0, j = 0;

		while (i < leftSortedList.size() && j < rightSortedList.size()) {
			if (leftSortedList.get(i) < rightSortedList.get(j)) {
				finalAns.add(leftSortedList.get(i));
				i++;
			} else {
				finalAns.add(rightSortedList.get(j));
				j++;
			}
		}

		// Append remaining elements
		while (i < leftSortedList.size()) {
			finalAns.add(leftSortedList.get(i));
			i++;
		}

		while (j < rightSortedList.size()) {
			finalAns.add(rightSortedList.get(j));
			j++;
		}

		return finalAns;
	}
}
