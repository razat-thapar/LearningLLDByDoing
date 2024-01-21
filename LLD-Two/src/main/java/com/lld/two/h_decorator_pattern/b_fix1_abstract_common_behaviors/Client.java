package com.lld.two.h_decorator_pattern.b_fix1_abstract_common_behaviors;

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
        Communicator emailService = new EmailService();
        emailService.send(user,message);
        Communicator phoneService = new PhoneService();
        phoneService.send(user,message);
        Communicator slackService = new SlackService();
        slackService.send(user,message);

        //PROS :
        //1. SRP is respected.
        //2. OCP is respected.
        //3. Liskov's substitution principle is respected.
        //4. We are able to send notifications to different channels alongwith email without modifying structure during runtime.

        //CONS:
        //1.


    }
}
