package lesson_1;

public class Main {
    public static void main(String[] args) {
        Course cource = new Course(new Doable[]{
                new Track(1000, 10),});

        Team team = new Team("-=Спарта=-", new Player[] {
                new Player("Виссарион", 1000, 10),
                new Player("Галактион", 800, 7),
                new Player("Никандр", 1000, 8),
                new Player("Никодим",850, 2) {
                }});

        System.out.println(team);
       cource.doIt(team);
       
        team.showResults();
    }
}
