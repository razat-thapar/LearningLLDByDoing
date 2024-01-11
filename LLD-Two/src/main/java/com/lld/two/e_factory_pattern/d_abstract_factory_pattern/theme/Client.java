package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme;
import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.external.DarkThemeFactory;

public class Client {
    private static ThemeFactory themeFactory = new DarkThemeFactory();
    public static void main(String[] args) {
        //Abstract Factory Pattern.
        // STep 1: create Product interface(s) (Products of Family Factory)
        // step 2: create subclasses implementing Product interface.(3rd party libraries).
        // STep 3: create a Family Factory interface
        // step 4: create subclasses implementing family Factory interface.


        //give me a button and checkbox.
        Button button = themeFactory.createButton();
        button.onClick();
        Checkbox checkbox = themeFactory.createCheckbox();
        checkbox.onSelect();

        //PROS:
        //1. OCP is followed. (if we add a new TextField class i.e., Product, no modification in existing classes required)
        //2. SRP is followed. (every code entity have only 1 responsibility. )
        //3. client class is coding to an interface of Family Factory. (Dependency Inversion is followed.)

        //CONS:
        //1. class explosion ( for every product heirarchy, we have a Family factory heirarchy as well.)
    }
}
