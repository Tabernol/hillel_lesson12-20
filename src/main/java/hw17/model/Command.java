package hw17.model;

public enum Command {
    SHOW("show"),
    ADD("add"),
    DELETE("delete"),
    READ("read"),
    EXIT("exit");

    public String command;

    Command(String command) {
        this.command = command;
    }
}
