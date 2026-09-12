/*
 * WEEK 8 - TASK 3
 * Problem: Java Singleton
 * Platform: HackerRank
 *
 * Question: Implement a singleton class so that only one instance of the
 * class can be created and its private message can be accessed through a
 * public getter.
 */

class Singleton {
    private static Singleton single_instance = null;
    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    public String getStr() {
        return str;
    }
}

class JavaSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleInstance();
        instance.str = "Hello I am a singleton! Let me say hello world to you";
        System.out.println(instance.getStr());
    }
}
