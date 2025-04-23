package topics.DesignPatterns.Creational.SingletonDP;

public class TVSet {
    private static TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("Object instantiated");
    }

    public static TVSet getTvSetInstance() {
        if(tvSetInstance == null) {
            synchronized (TVSet.class) {
                if(tvSetInstance == null) {
                    tvSetInstance = new TVSet();
                }
            }
        }

        return tvSetInstance;
    }
}
