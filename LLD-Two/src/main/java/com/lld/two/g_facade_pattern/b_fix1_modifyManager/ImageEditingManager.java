package com.lld.two.g_facade_pattern.b_fix1_modifyManager;

import com.lld.two.g_facade_pattern.image_editing.model.Image;
import com.lld.two.g_facade_pattern.image_editing.services.*;
public class ImageEditingManager {
//  Eager Initialization
    private static ImageLoader imageLoader = new ImageLoader();
    private static FilterService filterService = new FilterService();
    private static ImageModifier imageModifier = new ImageModifier();
    private static ImageWriter imageWriter = new ImageWriter();
    private static AnalyticsService analyticsService = new AnalyticsService();

//    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
//        this.imageLoader = imageLoader;
//        this.filterService = filterService;
//        this.imageModifier = imageModifier;
//        this.imageWriter = imageWriter;
//        this.analyticsService = analyticsService;
//    }

    public static void editImage(String imagePath, String filterType, int brightness) {

        Image image = imageLoader.loadImage(imagePath);

        filterService.applyFilter(image, filterType);
        imageModifier.adjustBrightness(image, brightness);

        imageWriter.saveImage(image);
        analyticsService.store(image);
    }

}
