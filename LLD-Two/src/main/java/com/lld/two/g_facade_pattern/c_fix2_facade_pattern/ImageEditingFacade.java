package com.lld.two.g_facade_pattern.c_fix2_facade_pattern;

import com.lld.two.g_facade_pattern.image_editing.services.*;

public class ImageEditingFacade {
    //  Eager Initialization
    private static ImageLoader imageLoader = new ImageLoader();
    private static FilterService filterService = new FilterService();
    private static ImageModifier imageModifier = new ImageModifier();
    private static ImageWriter imageWriter = new ImageWriter();
    private static AnalyticsService analyticsService = new AnalyticsService();

    private static ImageEditingManager imageEditingManager = new ImageEditingManager(
            imageLoader,
            filterService,
            imageModifier,
            imageWriter,
            analyticsService
    );
    public static void editImage(String imagePath, String filterType, int brightness) {
        imageEditingManager.editImage(imagePath,filterType,brightness);
    }
}
