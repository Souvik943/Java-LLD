package topics.DesignPatterns.Creational.BuilderDP;

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder()
                .setNonVeg(true)
                .setAddExtraCheese(true)
                .setAddExtraCheese(true)
                .build();

        System.out.println(burger);
    }
}
