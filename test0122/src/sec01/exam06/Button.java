package sec01.exam06;

public class Button {
	
	static interface OnClickListener{
		void onClick();
	}
	
	OnClickListener listener;

	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	void touch() {
		listener.onClick();
	}

	

}
