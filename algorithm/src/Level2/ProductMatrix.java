package Level2;
/*
 행렬의 곱셈은, 곱하려는 두 행렬의 어떤 행과 열을 기준으로, 
 좌측의 행렬은 해당되는 행, 우측의 행렬은 해당되는 열을 순서대로 곱한 값을 더한 값이 들어갑니다. 
 행렬을 곱하기 위해선 좌측 행렬의 열의 개수와 우측 행렬의 행의 개수가 같아야 합니다. 
 곱할 수 있는 두 행렬 A,B가 주어질 때, 행렬을 곱한 값을 출력하는 productMatrix 함수를 완성해 보세요.
 */
public class ProductMatrix {
	public int[][] productMatrix(int[][] A, int[][] B) {
		boolean checkSize = true;
		int[][] answer = new int[A.length][B.length];
		for (int i = 0; i < A.length; i++) {
			if(B.length != A[i].length){
				checkSize = false;
			}
		}
		if(checkSize){
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B[0].length; j++) {
					int sum = 0;
					for (int k = 0; k < B.length; k++) {
						sum += A[i][k] * B[k][j];
					}
					answer[i][j] = sum;
					System.out.print(answer[i][j] + "\t");
				}
				System.out.println();
			}
			return answer;
		}
		return answer;
		
//		int[][] answer = new int[A.length][B[0].length];
//        if(A[0].length == B.length){
//            for (int i = 0; i < answer.length; i++) {
//                for (int j = 0; j < answer[0].length; j++) {
//                    for (int k = 0; k < A[0].length; k++) {
//                        answer[i][j]+=A[i][k]*B[k][j];
//                    }
//                }
//
//            }
//        }
//        return answer;

	}

	public static void main(String[] args) {
		ProductMatrix c = new ProductMatrix();
		int[][] a = { { 1, 2, 3 }, 
					  { 2, 3, 3 } };
		
		int[][] b = { { 3 }, 
				      { 5 },
				      { 4 }};
      // 아래는 테스트로 출력해 보기 위한 코드입니다.
      System.out.println("행렬의 곱셈 : " + c.productMatrix(a, b));
	}
}
