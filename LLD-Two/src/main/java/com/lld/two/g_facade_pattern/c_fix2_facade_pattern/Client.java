package com.lld.two.g_facade_pattern.c_fix2_facade_pattern;

public class Client {
    public static void main(String[] args) {
        //WE need to edit an image , adjust it's brightness and apply some filter
        String imagePath = "C:\\Users\\user\\OneDrive\\Pictures\\Razat.jpg";
        String filterType = "Gaussian";
        int brightness = 90;
        //we have to create an object of ImageEditingManager
        //inject dependencies
//        ImageEditingManager imageEditingManager = new ImageEditingManager(
//                new ImageLoader(),
//                new FilterService(),
//                new ImageModifier(),
//                new ImageWriter(),
//                new AnalyticsService()
//        );
        //invoke method to finally edit our image.
        //imageEditingManager.editImage(imagePath,filterType,brightness);

        //Problem:
        //1. Client only need to edit Image and should not be bothered about injecting dependencies and creating imageEditingManager.
        //Requirement:
        //2. we need to make image editing simpler for client.
        //Approach 1:
        //1. We can modify ImageEditingManager and make editImage static.

        //ImageEditingManager.editImage(imagePath,filterType,brightness);

        //PROS:
        //1. image editing is simpiler for client.
        //CONS:
        //1. tight coupling of manager with service classes. (Violation of Dependency Inversion principle)
        //Due to this our code will not be extensible and might see regression bugs. \\
        //2. Manager class is an existing code and might be shared , so, modifications might not be possible.

        //Approach 2:
        //2. We can use Facade Design Pattern.
        //Steps:
        //1. Create a new class that encapsulates the creation of manager class and injecting dependencies.
        //2. Facade class delegates the editImage to manager class.
        ImageEditingFacade.editImage(imagePath,filterType,brightness);
        //PROS:
        //1. Client can use a simple class that exposes an editImage() method.
        //2. Facade class is making client life easier.
        //CONS:
        //1. In this scenario, due to eager initialization, startup times may get effected.
        // easy fix is to create on demand initialization of manager class.

    }
}
