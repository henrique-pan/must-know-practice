package algorithms.designPatterns.decorator;

public class ThreadSafeSingleton {

    /*
        The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
        That means that every read of a volatile variable will be read from the computer's main memory,
        and not from the CPU cache, and that every write to a volatile variable will be written to main memory,
        and not just to the CPU cache.
     */
    private static volatile ThreadSafeSingleton instance;

    private static Object locker = new Object();

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton result = instance;
        if(result == null) {
            synchronized (locker) {
                result = instance;
                if(result == null) {
                    instance = result = new ThreadSafeSingleton();
                }
            }
        }

        return result;
    }

}
