package stack;

import java.util.Stack;

//output the length of longest valid parenthesis substring
public class LongestValidParenthesis {
	// TC : O(n)
	// SC : O(n)
	static void solve(String s)
	{
		int n = s.length();
		Stack<Integer> st = new Stack<>();
		st.push(-1);           //IMP
		int result = 0;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '(')
				st.push(i);
			// if closing bracket
			else
			{
				if(!st.isEmpty())
					st.pop();
				// update length 
				if(!st.isEmpty())
					result = Math.max(result, i - st.peek());
				else
					st.push(i);
			}
		}
		System.out.println(result);
		
	}
	// SC :O(1)
	static void solve1(String s)
	{
		int n = s.length();
		int left = 0;
		int right = 0;
		int result = 0;
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '(')
				left++;
			else
				right++;
			
			if(left > right)
				left = right = 0;
			if(left == right)
			{
				result = Math.max(result, 2*right);
			}
			
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String s = "((()()()()(((())";
		String s1 = "()";
		
		solve(s1);
		solve(s);
		solve1(s);

	}

}
