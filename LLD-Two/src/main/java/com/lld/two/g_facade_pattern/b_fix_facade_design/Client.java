package com.lld.two.g_facade_pattern.b_fix_facade_design;

import com.lld.two.g_facade_pattern.image_editing.services.*;

public class Client {
    public static void main(String[] args) {
        //WE need to edit an image , adjust it's brightness and apply some filter
        String imagePath = "C:\\Users\\user\\OneDrive\\Pictures\\Razat.jpg";
        String filterType = "Gaussian";
        int brightness = 90;
        //we have to create an object of ImageEditingManager
        //inject dependencies
        ImageEditingManager imageEditingManager = new ImageEditingManager(
                new ImageLoader(),
                new FilterService(),
                new ImageModifier(),
                new ImageWriter(),
                new AnalyticsService()
        );
        //invoke method to finally edit our image.
        imageEditingManager.editImage(imagePath,filterType,brightness);

        //Problem:
        //1. Client only need to edit Image and ImageEditingManager might have lots of responsibilities.
        //Requirement:
        //2. We need to hide away the internal complexities from client and provide a simpler interface. .
        //Approach:
        //1 .Facade Design Pattern.
        //Steps:
        //1. Create a new Facade class that hides the internal implementation by delegating the task to Manager class.
        ImageEditingFacade imageEditingFacade = new ImageEditingFacade(
                new ImageLoader(),
                new FilterService(),
                new ImageModifier(),
                new ImageWriter(),
                new AnalyticsService()
        );
        //invoke method
        imageEditingFacade.editImage(imagePath,filterType,brightness);
        //PROS:
        //1. Client sees a simple interface and just inject dependencies like before but doesn't see the internal implementation
        //    also, will only see limited functionalities.
        //2. Easy to understand for client.
    }
}
