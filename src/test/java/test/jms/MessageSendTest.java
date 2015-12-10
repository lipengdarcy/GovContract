package test.jms;

//短信的消费者
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSendTest {
	
	@Autowired
	private static SendServiceTest sender;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-jms.xml");
		
		String myMessage = "hello world";
		sender.sendMessage(myMessage);
		System.out.println("-----send over-----");

	}

}
