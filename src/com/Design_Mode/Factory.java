package com.Design_Mode;


interface Product{}
class ConcreteProduct implements Product{}
class ConcreteProduct1 implements Product{}
class ConcreteProduct2 implements Product{}


/**
 * 工厂方法模式：
 * 定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化推迟到子类。
 */

//在简单工厂中，创建对象的是另一个类，而在工厂方法中，是由子类来创建对象。
public abstract class Factory {
    //Factory 有一个 doSomethind() 方法，这个方法需要用到一组产品对象，
    // 这组产品对象由 factoryMethod() 方法创建。该方法是抽象的，需要由子类去实现。
    abstract public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
    }
}

class ConcreteFactory extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

class ConcreteFactory1 extends Factory{
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
