package com.lld.two.g_facade_pattern.image_editing.services;

import com.lld.two.g_facade_pattern.image_editing.model.Image;

public class ImageLoader {
    public Image loadImage(String imagePath) {
        return new Image();
    }
}