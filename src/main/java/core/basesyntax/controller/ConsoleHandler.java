package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String EXIT = "q";
    private static final String DELIMITER = " ";
    private static final int BET_VALUE_INDEX = 0;
    private static final int COEFFICIENT_INDEX = 1;
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть розмір ставки і її коефіціент або 'q' для виходу");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT)) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(DELIMITER);
                int betValue = Integer.parseInt(betData[BET_VALUE_INDEX]);
                double coefficient = Double.parseDouble(betData[COEFFICIENT_INDEX]);
                bet = new Bet(betValue, coefficient);
            } catch (NumberFormatException e) {
                System.out.println("Введіть будь ласка коректні дані для розрахунку ставки");
            }
            betDao.add(bet);
            if (bet != null) {
                System.out.println(bet.toString());
            }
        }
    }
}
