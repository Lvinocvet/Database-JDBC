package sql.demo.repository;

import sql.demo.model.Order;
import sql.demo.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders extends BaseTable implements TableOperation{

    public Orders() throws SQLException {
        super("Orders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS Orders(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "date VARCHAR(255) NOT NULL," +
                "klient BIGINT NOT NULL)", "Создана таблица " + tableName);
    }



    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE Orders ADD FOREIGN KEY (klient) REFERENCES klients(id)",
                "Cоздан внешний ключ orders.klient -> klients.id");
    }



    public void Create(String sql) throws SQLException {
        super.executeSqlStatement(sql, "Добавлена запись в таблицу " + tableName);
    }
    public void Read(String sql) throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            Order order = new Order();
            order.setId(resultSet.getInt(1));
            order.setDate(resultSet.getString(2));
            order.setKlient(resultSet.getInt(3));
            System.out.println(order);
        }
        statement.close();

    }
    public void Update(String sql) throws SQLException {
        super.executeSqlStatement(sql, "Запись изменена в " + tableName);

    }
    public void Delete(String sql) throws SQLException {
        super.executeSqlStatement(sql, "Запись удалена из " + tableName);

    }




}