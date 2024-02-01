package dateType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		//예전 방식
		Date now = new Date();
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(now));
		
		//최근 방식
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date);
		System.out.println();

	}

}
