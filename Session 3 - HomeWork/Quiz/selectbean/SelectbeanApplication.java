package ir.freeland.spring.selectbean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ir.freeland.spring.selectbean.service.BankiranServices;

import org.springframework.stereotype.Component;

@Component
public class SelectbeanApplication {
	@Autowired
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_selectbean.xml");
//		BankiranServices  bankiranServices = context.getBean(BankiranServices.class);
//		bankiranServices.accountTransaction("136-800-384123");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SelectbeanApplication.class);
        BankiranServices bankiranServices = context.getBean(BankiranServices.class);
        bankiranServices.accountTransaction("136-800-384123");
        context.close();
		
	}

}
