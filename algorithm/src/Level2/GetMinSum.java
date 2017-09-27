package Level2;

import java.util.Arrays;

public class GetMinSum{
	 public int getMinSum(int []A, int []B)
	    {
		 int answer = 0;
		 Arrays.sort(A);
		 for (int i = 0; i < B.length; i++) {
			for (int j = i; j < B.length; j++) {
				if(B[i] < B[j]){
					int temp = B[i];
					B[i] = B[j];
					B[j] = temp;
				}
			}
		}
		 for (int i = 0; i < B.length; i++) {
			answer += (A[i] * B[i]);
		}
	        return answer;
	    }
	 
	/* Arrays.sort(A);
     Arrays.sort(B);

     int length = A.length;
     int answer = 0;

     for (int i = 0; i < length; i++) {
       answer += A[i] * B[length - 1 - i];
     }

     return answer;*/
	 public static void main(String[] args)
	    {
	        GetMinSum test = new GetMinSum();
	        int []A = {1,2,4,3};
	        int []B = {3,4,2,3};
	        System.out.println(test.getMinSum(A,B));
	    }

	
}
