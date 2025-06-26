package gestionale;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/company_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Cristante.100!";

    public void create(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, surname, email, hire_date, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getSurname());
            ps.setString(3, emp.getEmail());
            ps.setDate(4, emp.getHireDate());
            ps.setDouble(5, emp.getSalary());
            ps.executeUpdate();
        }
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection c = getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setSurname(rs.getString("surname"));
                e.setEmail(rs.getString("email"));
                e.setHireDate(rs.getDate("hire_date"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }
        }
        return list;
    }

    public void update(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET name=?, surname=?, email=?, hire_date=?, salary=? WHERE id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getSurname());
            ps.setString(3, emp.getEmail());
            ps.setDate(4, emp.getHireDate());
            ps.setDouble(5, emp.getSalary());
            ps.setInt(6, emp.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
