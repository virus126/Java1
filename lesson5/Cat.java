package lesson5;

class Cat extends Animal {

    Cat (String name) {
        super(name);
        jump_height = 1.0f;
    }

    @Override
    boolean swim () {
        return false;
    }
}
