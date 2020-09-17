package com.github.dairycode.abstractfactory;

public class HuaweiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
