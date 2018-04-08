package com.Design_Mode;

/**单例模式：
 * 使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 * 私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。
 */


//懒汉式-线程不安全
    /*以下实现中，私有静态变量 uniqueInstance 被延迟化实例化，
      这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源。
      这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 if(uniqueInstance == null) ，那么就会多次实例化 uniqueInstance。
    */
public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}


//懒汉式-线程安全
   /*
   只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，
   从而避免了对 uniqueInstance 进行多次实例化的问题。
   但是这样有一个问题，就是当一个线程进入该方法之后，其它线程试图进入该方法都必须等待，因此性能上有一定的损耗。
   */
class Singleton_safe{
    private static Singleton_safe uniqueInstance;
    private Singleton_safe(){}
    public static synchronized Singleton_safe getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton_safe();

        }
        return uniqueInstance;
    }

}

//饿汉式-线程安全
    /*
     线程不安全问题主要是由于 uniqueInstance 被实例化了多次，
     如果 uniqueInstance 采用直接实例化的话，就不会被实例化多次，也就不会产生线程不安全问题。
     但是直接实例化的方式也丢失了延迟实例化带来的节约资源的优势。
     */
    //private static Singleton uniqueInstance = new Singleton();



//双重校验锁-线程安全
    /*
     uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行。
     也就是说，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
     双重校验锁先判断 uniqueInstance 是否已经被初始化了，如果没有被实例化，那么才对实例化语句进行加锁。
     */

class Singleton_double {

    private volatile static Singleton_double uniqueInstance;

    private Singleton_double() { }

    public static Singleton_double getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                //在 uniqueInstance == null 的情况下，如果两个线程同时执行 if 语句，那么两个线程就会同时进入 if 语句块内。
                //虽然在 if 语句块内有加锁操作，但是两个线程都会执行 uniqueInstance = new Singleton(); 这条语句，只是早晚的问题，
                // 也就是说会进行两次实例化，从而产生了两个实例。因此必须使用双重校验锁，也就是需要使用两个 if 判断。
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton_double();
                }
            }
        }
        return uniqueInstance;
    }
}