package sec03.exam01;

public abstract class SmartPhone2  extends Phone{
	int y; 
	
	public SmartPhone2(int x,int y) {
		super(x);
		this.y = y;
		
	}
	
	public void printX() {
		System.out.println(x);
	}

	}


