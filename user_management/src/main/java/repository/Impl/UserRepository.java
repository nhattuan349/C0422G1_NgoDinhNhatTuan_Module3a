package repository.Impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SP_SELECT_ALL_USER = "call show_all();";
    private final String SP_DELETE_USER = "call delete_user(id_sp);";
    private final String SP_SELECT_USER_BY_ID = "call select_by_id(id_sp);";
    private final String SP_UPDATE = "call update_user(id, 'name','' );";

    @Override
    public List<User> selectAllUser() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();

             // Step 2:Create a statement using connection object
             CallableStatement callableStatement = connection.prepareCall(SP_SELECT_ALL_USER);) {
            System.out.println(callableStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                int id = rs.getInt("id_hoc_sinh");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); CallableStatement callableStatement = connection.prepareCall(SP_DELETE_USER);) {
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); CallableStatement callableStatement = connection.prepareCall(SP_SELECT_ALL_USER);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setInt(4, user.getId());

            rowUpdated = callableStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User selectUser(int idUser) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             CallableStatement callableStatement = connection.prepareCall(SP_SELECT_ALL_USER);) {
            callableStatement.setInt(1, idUser);
            System.out.println(callableStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_hoc_sinh");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
