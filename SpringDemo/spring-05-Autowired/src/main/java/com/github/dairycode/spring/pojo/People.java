package com.github.dairycode.spring.pojo;

import javax.annotation.Resource;

public class People {

    // 如果显式定义了Autowired的required属性为false,说明这个对象可以为null,否则不允许为空
    @Resource(name = "cat")
    private Cat cat;
    @Resource(name = "dog")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
