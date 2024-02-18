package kz.bitlab.shop.users.service;


import kz.bitlab.shop.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import kz.bitlab.shop.users.entity.User;

public class UserService extends DBManager {

    public static Long login(String email, String password) {
        Long id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select id from users where email = ? and password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static User getUserById(Long userId) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, email, password, full_name FROM users WHERE id = ?");
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
