package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть розмір ставки і її коефіціент або 'q' для виходу");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int betValue = Integer.parseInt(betData[0]);
                double coefficient = Double.parseDouble(betData[1]);
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
