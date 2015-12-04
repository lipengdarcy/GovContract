package test.jms.pubsub;


import javax.ejb.ActivationConfigProperty;  
import javax.ejb.MessageDriven;  
import javax.jms.JMSException;  
import javax.jms.Message;  
import javax.jms.MessageListener;  
import javax.jms.TextMessage;  

//客户端测试  
import javax.jms.MessageProducer;  
import javax.jms.Topic;  
import javax.jms.TopicConnection;  
import javax.jms.TopicConnectionFactory;  
import javax.jms.TopicSession;  
import javax.naming.InitialContext;  
  
@MessageDriven(activationConfig={  
            @ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Topic"),  
            @ActivationConfigProperty(propertyName="destination", propertyValue="topic/myTopic")  
    }  
)  

/*
2、Pub/Sub模式
在Pub/Sub模型中，有下列概念： 主题（Topic）、发布者（Publisher）、订阅者（Subscriber）。客户端将消息发送到主题。多个发布者将消息发送到Topic，系统将这些消息传递给多个订阅者。
 每个消息可以有多个消费者
 发布者和订阅者之间有时间上的依赖性。针对某个主题(Topic)的订阅者，它必须创建一个订阅之后，才能消费发布者的消息，而且，为了消费消息，订阅者必须保持运行的状态。
当然，为了缓和这种严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样，即使订阅者没有被激活（运行），它也能接收到发布者的消息。
如果你希望发送的消息可以不被做任何处理、或者被一个消费者处理、或者可以被多个消费者处理的话，那么可以采用Pub/Sub模型。

//注册消息监听器，当有消息发送过来的时候会调用onMessage方法(实现MessageListener 接口)
*/
public class TopicMessageBean implements MessageListener {  
  
    public void onMessage(Message msg) {  
        //共有下面几种消息类型  
        //1 Text  
        //2 Map  
        //3 Object  
        //4 stream  
        //5 byte  
        TextMessage txtMsg = (TextMessage)msg;  
        String s = "";  
        try {  
            s = txtMsg.getText();  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
        System.out.println("TopicMessageBean接收到了消息：" + s);  
    }  
 
  

  
  
 
    public static void main(String[] args) throws Exception {  
    InitialContext ctx = new InitialContext();  
    //获得QueueConnectionFactory对象  
    TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");  
    //创建QueueConnection对像   
    TopicConnection connection = factory.createTopicConnection();  
    //创建会话  
    //arg1:与事物有关，true表示最后提交，false表示自动提交  
    //arg2:表示消息向中间件发送确认通知，这里采用的是自动通知的类型  
    TopicSession session = (TopicSession) connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);  
    //取得destination  
    Topic queue = (Topic) ctx.lookup("topic/myTopic");  
    //消息生产者  
    MessageProducer publisher = session.createProducer(queue);  
    //定义消息  
    Message msg = session.createTextMessage("消息来了");  
    //发送消息  
    publisher.send(queue, msg);  
    session.close();  
    connection.close();  
          
    }  
}  