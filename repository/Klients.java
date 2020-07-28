package sql.demo.repository;

import sql.demo.model.Klient;
import sql.demo.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Klients extends BaseTable implements TableOperation{

    public Klients() throws SQLException {
        super("Klients");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS Klients(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "first_name VARCHAR(255) NOT NULL," +
                "last_name VARCHAR(255) NOT NULL,"+
                "adres VARCHAR(255) NOT NULL)", "Создана таблица " + tableName);
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
            Klient klient = new Klient();
            klient.setId(resultSet.getInt(1));
            klient.setFirst_name(resultSet.getString(2));
            klient.setLast_name(resultSet.getString(3));
            klient.setAdres(resultSet.getString(4));
            System.out.println(klient);
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