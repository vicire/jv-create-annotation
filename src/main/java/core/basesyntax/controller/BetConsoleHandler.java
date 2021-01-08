package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetConsoleHandler {
    private static final String EXIT = "q";
    private static final String DELIMITER = " ";
    private static final int BET_VALUE_INDEX = 0;
    private static final int COEFFICIENT_INDEX = 1;
    private BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bet value and coefficient or press 'q' to exit");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT)) {
                return;
            }
            try {
                String[] betData = command.split(DELIMITER);
                int betValue = Integer.parseInt(betData[BET_VALUE_INDEX]);
                double coefficient = Double.parseDouble(betData[COEFFICIENT_INDEX]);
                betDao.add(new Bet(betValue, coefficient));
                System.out.println(betDao.getAll());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter the correct data for bet calculation");
            }
        }
    }
}
