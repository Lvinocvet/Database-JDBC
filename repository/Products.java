package sql.demo.repository;

import sql.demo.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products extends BaseTable implements TableOperation{

    public Products() throws SQLException {
        super("Products");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS Products(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "discr VARCHAR(255) NOT NULL,"+
                "cost INTEGER NOT NULL)", "Создана таблица " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
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
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setDiscr(resultSet.getString(3));
            product.setCost(resultSet.getInt(4));
            System.out.println(product);
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
