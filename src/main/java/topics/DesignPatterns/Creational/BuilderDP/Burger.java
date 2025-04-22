package topics.DesignPatterns.Creational.BuilderDP;

public class Burger {
    private boolean isNonVeg;
    private boolean addTomatoes;
    private boolean addOnions;
    private boolean addNachos;
    private boolean addExtraCheese;
    private boolean addSesame;

    private Burger(BurgerBuilder burgerBuilder) {
    }

    public boolean isNonVeg() {
        return isNonVeg;
    }

    public boolean isAddTomatoes() {
        return addTomatoes;
    }

    public boolean isAddOnions() {
        return addOnions;
    }

    public boolean isAddNachos() {
        return addNachos;
    }

    public boolean isAddExtraCheese() {
        return addExtraCheese;
    }

    public boolean isAddSesame() {
        return addSesame;
    }

    static class BurgerBuilder {
        private boolean isNonVeg;
        private boolean addTomatoes;
        private boolean addOnions;
        private boolean addNachos;
        private boolean addExtraCheese;
        private boolean addSesame;

        public BurgerBuilder setNonVeg(boolean nonVeg) {
            isNonVeg = nonVeg;
            return this;
        }

        public BurgerBuilder setAddTomatoes(boolean addTomatoes) {
            this.addTomatoes = addTomatoes;
            return this;
        }

        public BurgerBuilder setAddOnions(boolean addOnions) {
            this.addOnions = addOnions;
            return this;
        }

        public BurgerBuilder setAddNachos(boolean addNachos) {
            this.addNachos = addNachos;
            return this;
        }

        public BurgerBuilder setAddExtraCheese(boolean addExtraCheese) {
            this.addExtraCheese = addExtraCheese;
            return this;
        }

        public BurgerBuilder setAddSesame(boolean addSesame) {
            this.addSesame = addSesame;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
