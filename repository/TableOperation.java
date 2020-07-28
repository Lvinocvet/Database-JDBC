package sql.demo.repository;

        import java.sql.SQLException;

// Операции с таблицами
public interface TableOperation {
    void createTable() throws SQLException; // создание таблицы
    void createForeignKeys() throws SQLException; // создание связей между таблицами



}
