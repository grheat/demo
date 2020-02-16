package demo;

public class Singleton {
        private volatile static Singleton uniqueSingleton;
        private Singleton(){};
        public static Singleton getInstance() {
                if (uniqueSingleton == null) {
                        synchronized (Singleton.class) {
                                if (uniqueSingleton == null) {
                                        uniqueSingleton = new Singleton();
                                }
                        }
                }
                return uniqueSingleton;
        }
}
