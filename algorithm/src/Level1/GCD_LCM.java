package Level1;

import java.util.Arrays;

/*
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환해주는 gcdlcm 함수를 완성해 보세요. 배열의 맨 앞에 최대공약수, 
그 다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 gcdlcm(3,12) 가 입력되면, [3, 12]를 반환해주면 됩니다.
*/
public class GCD_LCM {
	public int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (true) {
			int mod = max % min;
			if (mod == 0) {
				answer[0] = min;
				answer[1] = (a * b) / min;
				break;
			} else {
				max = min;
				min = mod;
			}
		}
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		GCD_LCM c = new GCD_LCM();
		System.out.println(Arrays.toString(c.gcdlcm(2, 3)));
	}
}
