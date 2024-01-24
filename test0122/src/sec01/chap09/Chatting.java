package sec01.chap09;

public class Chatting {
	void startChat(String chatId) {
		String nickName = chatId;
//		String nickName = null;
//		nickName = chatId; //final값이라 변경 불가
		
		class Chat{
			public void start() {

					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
			}
					
				void sendMessage(String message) {
					System.out.println(message);
			}
		}
			Chat chat = new Chat();
			chat.start();
	}

	public static void main(String[] args) {
		Chatting chatting = new Chatting();
		chatting.startChat("YUN");
		
	}
	
}
