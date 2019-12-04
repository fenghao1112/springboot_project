package com.fh.project.basic.builder;

/**
 * 所有属性使用final修饰，是为了这个类的成员变量不被修改，也就是该外部类是一个不可变类
 */
public class Nutrition {

    private  int servingSize;
    private  int servings;
    private  int calories;
    private  int fat;
    private  int sodium;
    private  int carbohydrate;

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    // 静态内部类
    public static class Builder {
        private final int servingSize;
        private final int servings;
        // 可以给成员变量初始化默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 静态内部类构造方法，用来初始化一些必填属性
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        // 静态内部类提供build方法来创建外部类
        public Nutrition build() {
            return new Nutrition(this);
        }

    }

    // 外部类私有构造方法，用来初始化外部类的
    private Nutrition(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        /*  A 外部类
            B 静态内部类
            C 内部类
            创建静态内部类的实例:
                        new A.B() ;A可以不需要构造方法，静态内部类的实例创建是不需要绑定到外部内的实例对象上的。
            创建内部类的实例：
                        A a = new A();
                        A.C c= b.new C();
         */
        Nutrition build = new Nutrition.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(build);
        build.setCalories(55);
        System.out.println(build);
    }

}
