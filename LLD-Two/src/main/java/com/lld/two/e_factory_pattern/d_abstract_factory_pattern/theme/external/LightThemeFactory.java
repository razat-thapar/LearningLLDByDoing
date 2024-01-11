package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.external;

import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Button;
import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Checkbox;
import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.ThemeFactory;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
