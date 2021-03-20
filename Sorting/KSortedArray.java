package Sorting;
import java.util.PriorityQueue;

public class KSortedArray {
	
	static int[] sort(int []arr,int k)
	{
		int n=arr.length;
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i=0;i<k+1;i++)
		{
			heap.add(arr[i]);
		}

		int index=0;          // index For inserting max element at the correct place
		int j= k+1;      // index For inserting in maxHeap
		while(index < n)
		{
			int x = heap.poll();
			arr[index] = x;
			if(j < n)
			{
				heap.add(arr[j]);
				j++;
			}
			index++;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int arr[]= {10,9,8,7,4,70,60,50};//{6,5,3,2,8,10,9};
		int k=4;
		arr=sort(arr,k);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}

//Should try to use miHeap
//That will make things easier
//COmplexity:O(nlog(k))
//AuxiliarySpace:O(k)
