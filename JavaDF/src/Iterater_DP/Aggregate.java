package Iterater_DP;

public interface Aggregate {
	public abstract Iterators iterator();
}

/* 1.Iterator 패턴
:무엇인가 많이 모여있는 것들을 순서대로 지정하면서 전체를 검색하는 처리를 실행하기 위한 것

*등장인물
Iterator의 역할
:요소를 순서대로 검색해가는 인터페이스(API)를 결정
예제에서 Iterator인터페이스가 그 역할을 하고 hasNext, next메소드를 결정

 ConcreteIteraor(구체적인 반복자의 역할)
 :Iterator가 결정한 인터페이스를 실제로 구현
 
 Aggregate(집합체)의 역할
 :Iterator 역할을 만들어내는 인터페이스를 결정. 이 인터페이스는 내가 가지고 있는 요소를 순서대로 검색해 주는 사람을
 만들어 내는 메소드이다.
 
 ConcreteAggregate(구체적인 집합체의 역할)
 Aggregate 역할이 결정한 인터페이스를 실제로 구현. ConcreteIterator역할의 인스턴스를 만들어 낸다
 
 *특징
1.구현에 상관없이 Iterator를 사용할 수 있다.
 Iterator를 사용함으로써 구현과 분리해서 하나씩 셀 수 있기 때문이다.

2.Aggregate와 Iterator의 대응
 두 개의 인터페이스가 쌍을 이루듯이 반복자 역할과 집합체 역할도 쌍을 이루고 있다.
*/