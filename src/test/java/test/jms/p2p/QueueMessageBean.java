package test.jms.p2p;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//客户端调用  
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myqueue") })
/*
 * 1、P2P模型
 * 在P2P模型中，有下列概念：消息队列(Queue)、发送者(Sender)、接收者(Receiver)。每个消息都被发送到一个特定的队列，接收者从队列中获取消息
 * 。队列保留着消息，直到它们被消费或超时。  每个消息只有一个消费者(Consumer)（即一旦被消费，消息就不再在消息队列中） 
 * 发送者和接收者之间在时间上没有依赖性，也就是说当发送者发送了消息之后，不管接收者有没有正在运行，它不会影响到消息被发送到队列。 
 * 接收者在成功接收消息之后需向队列应答成功 如果你希望发送的每个消息都应该被成功处理的话，那么你需要P2P模型。 举例：
 * //注册消息监听器，当有消息发送过来的时候会调用onMessage方法(实现MessageListener 接口)
 */
public class QueueMessageBean implements MessageListener {

	public void onMessage(Message msg) {
		// 共有下面几种消息类型
		// 1 Text
		// 2 Map
		// 3 Object
		// 4 stream
		// 5 byte
		TextMessage txtMsg = (TextMessage) msg;
		String s = "";
		try {
			s = txtMsg.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		System.out.println("QueueMessageBean接收到了消息：" + s);
	}

	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		// 获得QueueConnectionFactory对象
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx
				.lookup("QueueConnectionFactory");
		// 创建QueueConnection对像
		QueueConnection connection = factory.createQueueConnection();
		// 创建会话
		// arg1:与事物有关，true表示最后提交，false表示自动提交
		// arg2:表示消息向中间件发送确认通知，这里采用的是自动通知的类型
		QueueSession session = (QueueSession) connection.createQueueSession(
				false, QueueSession.AUTO_ACKNOWLEDGE);
		// 取得destination
		Queue queue = (Queue) ctx.lookup("queue/myqueue");
		// 消息生产者
		MessageProducer sender = session.createProducer(queue);
		// 定义消息
		Message msg = session.createTextMessage("消息来了");
		// 发送消息
		sender.send(queue, msg);
		session.close();
		connection.close();

	}
}
