package com.lld.two.h_decorator_pattern.c_fix2_decorator_pattern;

public class Client {
    public static void main(String[] args) {
        //Problem Statement: Let us say we want to build a class that sends our users emails with a greeting. We can start with a simple class.
        //As the application grows we may want to add some additional functionality to our email service.
        // For example, we may want to send phone notifications to our users or send them Slack messages.
        User user = User
                .builder()
                .name("Razat")
                .email("abc@g.com")
                .phone(7973712722L)
                .build();
//        EmailService emailService = new EmailService();
//        emailService.sendEmail(user,"Hello World!");

        //Requirement:
        //We need a way to send phone notification , slack notification on top of email
        // without modifying EmailService class
        //during runtime.

        //B.F:  Add new methods to our existing class.
        //PROBLEM:  1. can't modify the structure.
        //          2. SRP is violated.

        //Fix 1: since , we can't modify the class and add phone and slack methods .
        // We abstract the common behavior into a separate class.
          String message = "Hello World!";
//        Communicator emailService = new EmailService();
//        emailService.send(user,message);
//        Communicator phoneService = new PhoneServiceDecorator();
//        phoneService.send(user,message);
//        Communicator slackService = new SlackServiceDecorator();
//        slackService.send(user,message);

        //PROS :
        //1. SRP is respected.
        //2. OCP is respected.
        //3. Liskov's substitution principle is respected.
        //4. We are able to send notifications to different channels alongwith email without modifying structure during runtime.

        //CONS:
        //1.

        //FIX 2: Decorator Pattern.
        //Steps:
        //1. Common product interface.
        //2. Concrete product subclass.
        //3. Create a base Decorator abstract class that implements common interface.
        //4. Create concrete Decorator subclasses.
        //we can decorate the base object i.e., EmailService
        Communicator communicator = new SlackServiceDecorator(new PhoneServiceDecorator( new EmailService()));
        communicator.send(user,message);

        //PROS:
//        1. Object behavior can be extended at runtime by wrapping an object with one or several decorators without creating a new subclass.
//        2. Runtime configuration of an object is possible.
//        3. New behavior can be added to an object without changing its code.
//        4. SRP is respected by encapsulating the behavior in a separate class.
        //5. Liskov's is respected.

    }
}
