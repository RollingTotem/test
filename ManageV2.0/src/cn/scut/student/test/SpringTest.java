package cn.scut.student.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		System.out.println("----------------");
		//TestShow test  = (TestShow) ctx.getBean("testShow");
		//test.show();
	}
}
