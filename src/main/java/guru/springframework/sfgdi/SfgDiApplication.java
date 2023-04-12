package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args); // run returns an application context

		MyController myController = (MyController) ctx.getBean("myController"); // asks for an instance of MyController (the Framework generates the Object, this is why we don't need to do "new MyController", it's being done for us)

		System.out.println("------ Primary Bean");
		System.out.println(myController.sayHello());

		// make GreetingServiceImpl a service (@Service)
		// --> necessary for all the following DIs

		System.out.println("------ Property");
		// to make Property Injection work, we had to:
		// - annotate PropertyInjectedController as a conroller (@Controller)
		// - set @Autowired annotation to greetingService in Controller

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------ Setter");
		// to make Setter Injection work, we had to:
		// - annotate SetterInjectedController as a conroller (@Controller)
		// - autowire the setter method within that controller

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------ Constructor");
		// to make Constructor Injection work, we had to:
		// - tell Spring Framework, that the ConstuctorInjectedController is a Spring managed component (@Controller)
		// - no more need to add @Autowire for constructors

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
