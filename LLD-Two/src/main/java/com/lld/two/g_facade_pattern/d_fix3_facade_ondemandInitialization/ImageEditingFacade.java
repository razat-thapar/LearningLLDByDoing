package com.lld.two.g_facade_pattern.d_fix3_facade_ondemandInitialization;

import com.lld.two.g_facade_pattern.image_editing.services.*;

public class ImageEditingFacade {
    //  On Demand Initialization + Singleton pattern for getting one instance of dependencies.
    private static ImageLoader imageLoader;
    private static FilterService filterService;
    private static ImageModifier imageModifier;
    private static ImageWriter imageWriter;
    private static AnalyticsService analyticsService;

    private static ImageEditingManager imageEditingManager;
    public static void editImage(String imagePath, String filterType, int brightness) {
        imageEditingManager = getImageEditingManager();
        imageEditingManager.editImage(imagePath,filterType,brightness);
    }

    public static ImageEditingManager getImageEditingManager(){
        //double check locking
        if(imageEditingManager == null){
            synchronized (ImageEditingFacade.class){
                if(imageEditingManager == null){

                    imageEditingManager = new ImageEditingManager(
                            getImageLoader(),
                            getFilterService(),
                            getImageModifier(),
                            getImageWriter(),
                            getAnalyticsService()
                    );
                }
            }
        }
        return imageEditingManager;
    }
    public static FilterService getFilterService(){
        //double check locking.
        if(filterService == null){
            synchronized (ImageEditingFacade.class){
                if(filterService == null){
                    filterService = new FilterService();
                }
            }
        }
        return filterService;
    }
    public static ImageModifier getImageModifier(){
        //double check locking.
        if(imageModifier == null){
            synchronized (ImageEditingFacade.class){
                if(imageModifier == null){
                    imageModifier= new ImageModifier();
                }
            }
        }
        return imageModifier;
    }
    public static ImageWriter getImageWriter(){
        //double check locking.
        if(imageWriter == null){
            synchronized (ImageEditingFacade.class){
                if(imageWriter == null){
                    imageWriter = new ImageWriter();
                }
            }
        }
        return imageWriter;
    }
    public static ImageLoader getImageLoader(){
        //double check locking.
        if(imageLoader == null){
            synchronized (ImageEditingFacade.class){
                if(imageLoader == null){
                    imageLoader = new ImageLoader();
                }
            }
        }
        return imageLoader;
    }
    public static AnalyticsService getAnalyticsService(){
        //double check locking.
        if(analyticsService == null){
            synchronized (ImageEditingFacade.class){
                if(analyticsService == null){
                    analyticsService = new AnalyticsService();
                }
            }
        }
        return analyticsService;
    }
}
