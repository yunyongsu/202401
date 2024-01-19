package sec02.exam03;

public class HankookTire extends Tire {

	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		++accmulatedRotation; // 누적 회전수 1 증가
		if (accmulatedRotation < maxRotation) { // 만약 누적회전수가 최대 회전수보다 적으면 진행
			System.out.println(location + "HankookTire 수명 : " + (maxRotation - accmulatedRotation) + "회");
			return true;
		} else { // 만약 누적회전수가 최대회전수와 같다면(펑크) false
			System.out.println("***" + location + "HankookTire 펑크 ***");
			return false;
		}

	}

}
