package Level1;

public class SumDivisor {
	public int sumDivisor(int num) {
		int answer = 1;
		for (int i = 2; i <= num; i++) {
			if(num % i == 0){
				answer += i;
			}
		}
		return answer;
		//return java.util.stream.IntStream.rangeClosed(1,num).filter(x -> num % x == 0).sum();
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		SumDivisor c = new SumDivisor();
		System.out.println(c.sumDivisor(12));
	}
}
