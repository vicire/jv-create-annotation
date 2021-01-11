package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private static final Class MARKER = Dao.class;

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (!(Factory.getBetDao().getClass().isAnnotationPresent(MARKER))) {
                    throw new NoSuchAnnotationException("There is no such annotation (" + MARKER
                            + ") in the class (" + Factory.getBetDao().getClass() + ")");
                }
                if (!(Factory.getUserDao().getClass().isAnnotationPresent(MARKER))) {
                    throw new NoSuchAnnotationException("There is no such annotation (" + MARKER
                            + ") in the class (" + Factory.getUserDao().getClass() + ")");
                }
                if (field.getType() == BetDao.class) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == UserDao.class) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
