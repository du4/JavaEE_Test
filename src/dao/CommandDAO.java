package dao;

import beans.Command;
import connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO extends AbstractDAO implements IDAO <Command> {
    @Override
    public Command read(int id) {
        List<Command> commands =  getAll("WHERE cmd_id=" + id + " LIMIT 0,1");
        return (commands.size() > 0) ? commands.get(0) : null;
    }

    @Override
    public int create(Command entity) {
        String sql = String.format("INSERT INTO cmd(action, permission, role) VALUES('%s','%d','%d');",
                entity.getAction(), entity.isPermission(), entity.getRole());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Command entity) {
        String sql = String.format("UPDATE `cmd` SET `action`='%s', `permission`='%d', `role`='%d' WHERE `cmd`.`cmd_id` = %d;",
                entity.getAction(), entity.isPermission(), entity.getRole(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Command entity) {
        String sql = String.format("DELETE FROM `cmd` WHERE  `cmd`.`cmd_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List <Command> getAll(String WhereAndOrder) {
        List<Command> commands = new ArrayList<>();
        String sql = "SELECT * FROM cmd " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                commands.add(new Command(resultSet.getInt("cmd_id"),resultSet.getString("action"),
                        resultSet.getBoolean("permission"),resultSet.getInt("role")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return commands;
    }
}
