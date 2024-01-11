package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.external;

import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Checkbox;

public class LightCheckbox implements Checkbox {
    @Override
    public void onSelect() {
        System.out.println("Light checkbox is selected.");
    }
}
