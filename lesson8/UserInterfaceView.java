package lesson8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите название города в котором хотите узнать погоду: ");
                String city = scanner.nextLine();

                System.out.println("Нажмите 1 для получения погоды на сегодня;\nНажмите 2 получите прогноз на 5 дней;\n" +
                        "Нажмите 3 - Выгрузить данные за сегодня;\n" +
                        "Нажмите 4 - Выгрузить данные на 5 дней;\n" +
                        "Нажмите 0 для выхода: ");
                String command = scanner.nextLine();
                if (command.equals("0")) break;

                controller.getWeather(command, city);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Что-то пошло не так");
            } catch (NullPointerException e) {
                System.out.println("Что-то пошло не так!");
            }
        }
    }
}