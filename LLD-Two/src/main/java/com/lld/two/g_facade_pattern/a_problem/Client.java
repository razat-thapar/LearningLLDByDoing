package com.lld.two.g_facade_pattern.a_problem;

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
    }
}
