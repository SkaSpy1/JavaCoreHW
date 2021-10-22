package lesson_1;

public class Player  {
    String name;
    int run_limit;
    int jump_limit;

    public Player(String name, int run_limit, int jump_limit) {
        this.name = name;
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
    }


    public boolean run(int length) {
        return run_limit >= length;
    }
    public boolean jump(float height) {
        return jump_limit >= height;
    }

    public String toString() {
        return this.getClass().getName() + " " + name;
    }



    public boolean doIt(Player player) {
        return false;
    }

    public String getName() {
        return name;
    }
}

