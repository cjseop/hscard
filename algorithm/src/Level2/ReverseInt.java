package Level2;

import java.util.Arrays;

/*
 reverseInt 메소드는 int형 n을 매개변수로 입력받습니다.
n에 나타나는 숫자를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를들어 n이 118372면 873211을 리턴하면 됩니다.
n은 양의 정수입니다.
*/
public class ReverseInt {
	public int reverseInt(int n){
		String[] strArr = String.valueOf(n).split("");
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		String result = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			result += strArr[i];
		}
		return Integer.parseInt(result);
		
//		res = "";
//        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
//        return Integer.parseInt(res);
	}
  
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void  main(String[] args){
		ReverseInt ri = new ReverseInt();
		System.out.println(ri.reverseInt(118372));
	}
}
