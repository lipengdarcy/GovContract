package test.i18n;

import java.io.FileOutputStream;
import java.io.IOException;

//里面包括配置文件与国际化
import java.util.*;

public class I18N {
	public static void main(String[] args) throws IOException {
		// 以下是中文国际化的过程
		Properties properties = new Properties();
		// 设置hello对应的值为"你好，世界！"
		properties.setProperty("hello", "你好，世界！");
		properties.store(new FileOutputStream("Message_zh.properties"), "i18N");
		// 以上是中文国际化的过程
		
		// 以下是日语国际化的过程
		properties = new Properties();
		properties.setProperty("hello", "こんにちは、世界（せかい）！");
		properties.store(new FileOutputStream("Message_ja.properties"), "i18N");
		// 以上は、日本語の国際化
		
		// 以下是英语国家化的过程
		properties = new Properties();
		properties.setProperty("hello", "hello,world!");
		properties.store(new FileOutputStream("Message_en.properties"), "i18N");

		// Above is internationilizing in English
		// 下面加载国际化文件，第一个参数是国际化文件“xx_语言.propreties”中xx的部分，
		// 第二个参数是语言，Locale.getDefault()的意思是取本操作系统的语言
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Message",
				Locale.getDefault());
		// 然后取得key:hello在所对应的属性值value，把它打印出来
		System.out.println(resourceBundle.getString("hello"));
		// Locale.JAPAN能够强行指定取出日语国际化的结果，再把它打印出来
		resourceBundle = ResourceBundle.getBundle("Message", Locale.JAPAN);
		System.out.println(resourceBundle.getString("hello"));
		// 英语同理
		resourceBundle = ResourceBundle.getBundle("Message", Locale.ENGLISH);
		System.out.println(resourceBundle.getString("hello"));
	}
}