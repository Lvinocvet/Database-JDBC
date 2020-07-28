package sql.demo;

import org.h2.tools.DeleteDbFiles;
import sql.demo.model.OrderProduct;
import sql.demo.model.Product;
import sql.demo.repository.*;
import java.sql.*;

public class Main {
    // Блок объявления констант
    public static final String DB_DIR = "d:/Универ/практика/untitled/DB";
    public static final String DB_FILE = "database";
    public static final String DB_URL = "jdbc:h2:/" + DB_DIR + "/" + DB_FILE;
    public static final String DB_Driver = "org.h2.Driver";

    // Таблицы СУБД
    Products products;
    Klients klients;
    Orders orders;
    OrderProducts orderProducts;


    // Получить новое соединение с БД
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Инициализация
    public Main(boolean renew) throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        products = new Products();
        klients = new Klients();
        orders = new Orders();
        orderProducts = new OrderProducts();

        }

// Инициализация по умолчанию, без удаления файла БД
public Main() throws SQLException, ClassNotFoundException {
        this(false);
        }

// Создание всех таблиц и внешних ключей
public void createTablesAndForeignKeys() throws SQLException {
        products.createTable();
        klients.createTable();
        orders.createTable();
        orderProducts.createTable();
        // Создание внешних ключей (связи между таблицами)
        orders.createForeignKeys();
        orderProducts.createForeignKeys();
        ;
        }

public void Active() throws SQLException {
   // products.Create("Insert Into products(name,discr,cost) VALUES('Chair','with back',3000)");
   // products.Create("Insert Into products(name,discr,cost) VALUES('Chair','no back',2000)");
   // products.Create("Insert Into products(name,discr,cost) VALUES('table','\n" +
   //         "4 seater table',9000)");
  //  products.Create("Insert Into products(name,discr,cost) VALUES('table','\n" +
     //       "6 seater table',12000)");
    // products.Read("select * from products");
        }





public static void main(String[] args) {
        try{
        Main stockExchangeDB = new Main(true);
          stockExchangeDB.createTablesAndForeignKeys();
         stockExchangeDB.Active();

        } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Ошибка SQL !");
        } catch (ClassNotFoundException e) {
        System.out.println("JDBC драйвер для СУБД не найден!");
        }
        }
        }
