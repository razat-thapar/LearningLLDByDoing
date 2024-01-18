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
        //1. Client only need to edit Image and should not be bothered about injecting dependencies and creating imageEditingManager.
        //Requirement:
        //2. we need to make image editing simpler for client.
        //Approach:
        //1. We can modify ImageEditingManager and make editImage static.
        //2. We can use Facade Design Pattern.
    }
}
