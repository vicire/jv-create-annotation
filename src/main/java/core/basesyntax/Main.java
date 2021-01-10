package core.basesyntax;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.UserConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        BetConsoleHandler betHandler = (BetConsoleHandler) Injector
                .getInstance(BetConsoleHandler.class);
        UserConsoleHandler userHandler = (UserConsoleHandler) Injector
                .getInstance(UserConsoleHandler.class);
        userHandler.handle();
        betHandler.handle();
    }
}
