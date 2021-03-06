package trees;

import java.util.Stack;

// given a preorder traversal array, check if it is valid for a bst

// Bruteforce : O(n^2)

public class ValidPreorder {
	// O(n) solution using stack
	static boolean solve(int pre[])
	{
		int n = pre.length;
		Stack<Integer> s = new Stack<>();
		// value stored in the stack will always be in decreasing order
		int parent = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			// if we find a node which is on right side and smaller than parent than return false 
			if(pre[i] < parent)
				return false;
			
			// if pre[i] is in right subtree of stack top
			// keep removing items smaller than pre[i]
			// and make the last removed item as new parent
			while(!s.empty() && s.peek() < pre[i])
			{
				parent = s.peek();
				s.pop();
			}
			s.push(pre[i]);
		}
		return true;
		
	}

	public static void main(String[] args) {
		int pre[]= {2, 4, 3};
		System.out.println(solve(pre));
		
		int pre1[] = {2, 4, 1};
		System.out.println(solve(pre1));
		
		int pre2[] = {40, 30, 35, 80, 100};
		System.out.println(solve(pre2));
		
		int pre3[] = {40, 30, 35, 20, 80, 100};
		System.out.println(solve(pre3));

	}

}
