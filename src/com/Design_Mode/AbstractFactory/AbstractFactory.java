package com.Design_Mode.AbstractFactory;

/**抽象工厂模式：
 * 1.抽象工厂模式创建的是对象家族，也就是很多对象而不是一个对象，并且这些对象是相关的，也就是说必须一起创建出来。
 * 而工厂模式只是用于创建一个对象，这和抽象工厂模式有很大不同
 * 2.抽象工厂模式用到了工厂模式来创建单一对象，AbstractFactory 中的 createProductA 和 createProductB 方法都是让子类来实现，
 * 这两个方法单独来看就是在创建一个对象，这符合工厂模式的定义。
 * 3.至于创建对象的家族这一概念是在 Client 体现，Client 要通过 AbstractFactory 同时调用两个方法来创建出两个对象，
 * 在这里这两个对象就有很大的相关性，Client 需要同时创建出这两个对象。
 */
class AbstractProductA {}
class AbstractProductB {}
class ProductA1 extends AbstractProductA {}
class ProductA2 extends AbstractProductA {}
class ProductB1 extends AbstractProductB{}
class ProductB2 extends AbstractProductB{}

public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory{
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    AbstractProductB createProductB() {
        return new ProductB2();
    }
}


class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        abstractFactory = new ConcreteFactory2();
        productA = abstractFactory.createProductA();
    }
}
