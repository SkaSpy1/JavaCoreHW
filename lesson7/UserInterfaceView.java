package lesson7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите название города на английском языке (Например: Moscow)");
                String city = scanner.nextLine();
                System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                        "2 - Получить погоду на следующие 5 дней, " +
                        "выход (exit) - завершить работу");
                String command = scanner.nextLine();
                if (command.equals("0")) break;
                controller.getWeather(command, city);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат ввода данных. Попробуйте ещё раз!");
            }
        }
    }
}