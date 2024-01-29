package sec01.exam01;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 85);
		map.put("김하나", 85);
		map.put("김두울", 80);
		map.put("김하나", 80);
		System.out.println(map.get("김하나"));
		System.out.println(map.size());
	}

}
