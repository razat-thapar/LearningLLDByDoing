package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme;
//Step3 : Create family factory interface.
public interface ThemeFactory {
    Button createButton();
    Checkbox createCheckbox();
}
