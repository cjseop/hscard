package Adapter_DP;

public interface Print {
	public abstract void printWeak();
	public abstract void printStrong();
}

/*
2.Adapter 패턴
:이미 제공되어 있는 것과 필요한 것 사이의 차이를 없애준다

종류
1)상속을 사용한 Adapter 패턴
2)위임을 사용한 Adapter 패턴

*등장인물
1)Target(대상)의 역할
:지금 필요한 메소드를 결정

2)Clinet(의뢰자)의 역할
:Target 역할의 메소드를 사용해서 일을 한다 

3)Adaptee(개조되는 쪽)의 역할
이미 준비되어 있는 메소드를 가지고 있는 역할

4)Adapter의 역할
Adaptee역할의 메소드를 사용해서 어떻게든 Target역할을 만족시키기 위한 것

*특징
 이미 존재하는 클래스를 재활용하기 위함. 기존의 클래스를 개조해서 필요한 클래스를 만듬.
*/
