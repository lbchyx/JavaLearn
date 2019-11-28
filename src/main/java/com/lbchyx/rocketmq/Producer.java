package com.lbchyx.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.Scanner;

public class Producer {

	public static void main(String[] args) throws Exception {
		DefaultMQProducer producer = new DefaultMQProducer("my_group");
		producer.setNamesrvAddr("localhost:9876");
		producer.setInstanceName("rmq_instance");
		producer.start();

		Message message = new Message("demo_topic", "demo_tag", "这是一条测试消息".getBytes());
		producer.send(message);
		boolean flag = true;
		while (flag){
			String text = new Scanner(System.in).nextLine();
			if ("close producer".equals(text)){
				flag = false;
			}else{
				Message msg = new Message("demo_topic", "demo_tag", text.getBytes());
				producer.send(msg);
			}
		}
		producer.shutdown();
	}
}
