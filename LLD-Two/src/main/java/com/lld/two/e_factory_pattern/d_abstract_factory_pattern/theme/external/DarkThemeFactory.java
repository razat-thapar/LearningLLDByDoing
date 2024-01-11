package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.external;

import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Button;
import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Checkbox;
import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.ThemeFactory;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}
