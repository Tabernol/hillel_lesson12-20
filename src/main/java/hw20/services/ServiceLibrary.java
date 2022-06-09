package hw20.services;

import hw20.model.*;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;

public class ServiceLibrary implements CheckAble, ConnectDAO {
    private static Map<String, Consumer<Scanner>> mapCommand = new HashMap<>();
    private static CommandService commandService = new CommandService();
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "hr";
    private static final String password = "hr";
    static Connection connect;
    Scanner scanner = new Scanner(System.in);

    static {
        commandInitializer();
    }

    public void startLibrary() {
        myConnection();
        if (!connectionStatus()) {
            System.out.println(Output.CONNECT_SUCCESS.description);
        } else {
            System.out.println(Output.NO_CONNECT.description);
        }
        String command = "";
        while (!check(command)) {
            Command.printDescription();
            command = scanner.nextLine().toLowerCase();
            mapCommand.getOrDefault(command, scanner1 -> System.out.println(Output.REPEAT)).accept(scanner);
        }
    }

    private static void commandInitializer() {
        mapCommand.put(Command.SHOW.command, scanner -> commandService.show());
        mapCommand.put(Command.ADD.command, scanner -> commandService.add());
        mapCommand.put(Command.DELETE.command, scanner -> commandService.delete());
        mapCommand.put(Command.EXIT.command, scanner -> commandService.exit());
    }

    public static boolean connectionStatus() {
        boolean status = false;
        try {
            status = connect.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }

    @Override
    public boolean check(String line) {
        return line.equals("exit");
    }


    @Override
    public Connection myConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection(
                    URL, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connect;
    }

    public static void main(String[] args) {
        ServiceLibrary start = new ServiceLibrary();
        start.startLibrary();
    }
}
