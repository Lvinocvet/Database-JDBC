package sql.demo.repository;

import sql.demo.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderProducts extends BaseTable implements TableOperation{

    public OrderProducts() throws SQLException {
        super("OrderProducts");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS OrderProduct(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "count INTEGER NOT NULL," +
                "product BIGINT NOT NULL," +
                "tovar BIGINT NOT NULL)", "Создана таблица " + tableName);
    }




    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE OrderProduct ADD FOREIGN KEY (Product) REFERENCES Products(id)",
                "Cоздан внешний ключ OrderProducts.product -> product.id");
        super.executeSqlStatement(" ALTER TABLE OrderProduct ADD FOREIGN KEY (Tovar) REFERENCES Orders(id)",
                "Cоздан внешний ключ OrderProducts.tovar -> order.id");


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