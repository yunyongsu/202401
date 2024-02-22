package stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {

	public static void main(String[] args) {
		//람다식
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //asList = 리터럴값일 때 사용 가능
		list.stream().filter(i->i%2==0).forEach(i->System.out.println(i));
		
//		//기본식
//		List<Integer> list =new ArrayList<>();
//			list.add(1); list.add(2); ...
//		for (Integer i : list) {
//			if (i % 2 == 0) {
//				System.out.println(i);
//			}
//		}

	}

}
