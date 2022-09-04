package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User selectUser(int idUser);
}
