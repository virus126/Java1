package lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Барсик");
        animals[1] = new Dog("Шарик");
        animals[2] = new Horse("Мустанг");

        for (int j = 0; j < animals.length; j++)
            if (animals[j].run())
                System.out.println(animals[j].getName() + " бежит");
            else
                System.out.println(animals[j].getName() + " не умеет бегать");

        for (int j = 0; j < animals.length; j++)
            if (animals[j].swim())
                System.out.println(animals[j].getName() + " плывет");
            else
                System.out.println(animals[j].getName() + " не умеет плавать");

        for (int j = 0; j < animals.length; j++)
            if (animals[j].jump(0.6f))
                System.out.println(animals[j].getName() + " преодолевает препятствие");
            else
                System.out.println(animals[j].getName() + " не может преодолеть препятствие");
    }
}
