package ch14;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
	private String name;
	private int englishScore;
	private int mathScore;
}
