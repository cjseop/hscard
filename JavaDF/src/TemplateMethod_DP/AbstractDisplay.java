package TemplateMethod_DP;

public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void display()
	{
		open();
		for (int i = 0; i < 5; i++) {
			print();
		}
		close();
	}
}

/*
 3)Template Method (하위 클래스에서 구체적으로 처리하기) 
 상위클래스에 템플릿에 해당하는 메소드 정의. 하위클래스에서 추상메소드 구현.
 상위 클래스에서 뼈대를 결정하고, 하위클래스에서 그 구체적인 내용을 결정.
 
*등장인물
AbstractClass(추상 클래스)의 역할
:템플릿 메소드를 구현. 추상메소드 선언.

ConcreteClass(구현 클래스)의 역할
:추상클래스에 정의 되어 있는 추상 메소드를 구체적으로 구현

*특징
1)로직을 공통화 할 수 있다.
상위 클래스의 템플릿 메소드에서 알고리즘이 기술되어 있으므로, 하위 클래스측에서는 알고리즘을 일일이 기술할 필요가 없다

2)상위 클래스와 하위 클래스의 연계
추상메소드를 실제로 하위 클래스에서 구현할 때 그 메소드가 어느 타이밍에서 호출되는지 이해해야한다

3)하위 클래스를 상위 클래스와 동일시 한다
상위 클래스형의 변수에 하위 클래스의 어떠한 인스턴스를 대입해도 제대로 작동할 수 있도록 한다 LSP

*/
