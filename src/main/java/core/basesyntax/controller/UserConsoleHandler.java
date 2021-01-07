package core.basesyntax.controller;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.User;
import java.util.Scanner;

public class UserConsoleHandler {
    private static final String EXIT = "q";
    private static final String DELIMITER = " ";
    private static final int NAME_VALUE_INDEX = 0;
    private static final int AGE_INDEX = 1;
    UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я і вік або 'q' для виходу");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT)) {
                return;
            }
            try {
                String[] userData = command.split(DELIMITER);
                String name = userData[NAME_VALUE_INDEX];
                int age = Integer.parseInt(userData[AGE_INDEX]);
                userDao.add(new User(name,age));
                System.out.println(userDao.getAll());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Введіть будь ласка коректні дані");
            }
        }
    }
}
