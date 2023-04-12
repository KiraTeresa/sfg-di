package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        // Mimicking what the Spring Framework would be doing:
        // - creating a SetterInjectedController Object
        // - assigning it to the controller variable
        controller = new SetterInjectedController();

        // using the setter method to inject the Greeting Service Implementation
        controller.setGreetingService(new SetterInjectedGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}