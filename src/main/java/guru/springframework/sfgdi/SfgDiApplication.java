package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args); // run returns an application context

		MyController myController = (MyController) ctx.getBean("myController"); // asks for an instance of MyController (the Framework generates the Object, this is why we don't need to do "new MyController", it's being done for us)

		String greeting = myController.sayHello();

		System.out.println(greeting);
	}

}
