package testJava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// 자기 자신을 초기화 할 수 없기 때문에 제너릭~으로 초기화 하고 xml 파일을 넣어준다
		// 컨테이너를 구축하는 것 (beans안에 있는 bean 객체가 다 올라감)
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
//		TV tv = (TV) context.getBean("samsungTV");
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		LgTV tv = (LgTV) context.getBean("lgTV");
		tv.getTv().powerOn();
		// =>결과: 삼성TV전원을 켠다.
		
		//bean에서 가져오지 않고 독립적으로도 사용 가능
		//LgTV tv1 = new LgTV((TV) context.getBean("samsungTV"));
	}

}
