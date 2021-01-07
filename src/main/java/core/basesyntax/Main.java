package core.basesyntax;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.UserConsoleHandler;

public class Main {

    public static void main(String[] args) {
        BetConsoleHandler betHandler = new BetConsoleHandler();
        UserConsoleHandler userHandler = new UserConsoleHandler();
        userHandler.handle();
        betHandler.handle();
    }
}
