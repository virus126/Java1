package lesson5;

class Animal {
    String name;
    float jump_height = 0;

    Animal (String name) {
        this.name = name;
    }

    boolean run () {
        return true;
    }

    boolean swim () {
        return true;
    }

    boolean jump (float height) {
        if (jump_height >= height)
            return true;
        else
            return false;
    }

    String getName () {
        return this.name;
    }
}
