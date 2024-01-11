package com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.external;

import com.lld.two.e_factory_pattern.d_abstract_factory_pattern.theme.Button;

public class LightButton implements Button {
    @Override
    public void onClick(){
        System.out.println("Light button is clicked!");
    }
}
