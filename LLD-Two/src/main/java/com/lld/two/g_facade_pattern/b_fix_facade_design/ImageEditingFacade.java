package com.lld.two.g_facade_pattern.b_fix_facade_design;

import com.lld.two.g_facade_pattern.image_editing.model.Image;
import com.lld.two.g_facade_pattern.image_editing.services.*;

public class ImageEditingFacade {

    private ImageEditingManager imageEditingManager;

    public ImageEditingFacade(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        this.imageEditingManager = new ImageEditingManager(imageLoader,filterService,imageModifier,imageWriter,analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        imageEditingManager.editImage(imagePath,filterType,brightness);
    }
}
