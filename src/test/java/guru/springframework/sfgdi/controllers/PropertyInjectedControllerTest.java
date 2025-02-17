package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp(){
        // Mimicking what the Spring Framework would be doing:
        // - creating a PropertyInjectedController Object
        // - assigning it to the controller variable
        controller = new PropertyInjectedController();

        // directly setting the property by accessing the new Greeting Service Implementation
        controller.greetingService = new PropertyInjectedGreetingService();
    }
    @Test
    void getGreeting() {

        System.out.println(controller.getGreeting());
    }
}