package core.basesyntax.model;

import java.util.Objects;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object user) {
        if (this == user) {
            return true;
        }
        if (user == null || getClass() != user.getClass()) {
            return false;
        }
        User user1 = (User) user;
        return Objects.equals(user1.name, ((User) user).name) && user1.age == ((User) user).age;
    }

    @Override
    public String toString() {
        return "User: "
                + "name " + name
                + ", age " + age
                + ".";
    }
}
