package recursion;

public class SumOfNaturalNumbers {
	
	static int sum(int n)
	{
		if(n==1)
			return 1;
		else
			return sum(n-1)+n;
	}

	public static void main(String[] args) {
		
		System.out.println(sum(1000));
		
	}

}
