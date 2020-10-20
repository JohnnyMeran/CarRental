package ro.jademy.carrental.dao;

import ro.jademy.carrental.DBUtil;
import ro.jademy.carrental.model.users.Employee;
import ro.jademy.carrental.model.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBEmployeeDao implements UserDao {


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select u.ID as user_ID,\n" +
                    "e.ID as employee_ID,\n" +
                    "company_ID,\n" +
                    "username,\n" +
                    "pass,\n" +
                    "first_name,\n" +
                    "last_name\n" +
                    "from users u \n" +
                    "inner join employees e\n" +
                    "on e.user_id = u.ID");
            ResultSet userResult = stmt.executeQuery();
            while (userResult.next()) {
                int userId = userResult.getInt("user_ID");
                int employeeId = userResult.getInt("employee_ID");
                int companyId = userResult.getInt("company_ID");
                String firstName = userResult.getString("first_name");
                String lastName = userResult.getString("last_name");
                String username = userResult.getString("username");
                String password = userResult.getString("pass");
                userList.add(new Employee(userId, employeeId, companyId, firstName, lastName, username, password));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong");
        }
        return userList;
    }
    @Override
    public int findId(User employee){
        if(employee instanceof Employee) {
            try {
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select e.ID from users u inner join employees e " +
                        "on e.user_id = u.ID " +
                        "where e.first_name = ? and e.last_name = ? and e.company_ID = ? and u.username = ? and u.pass = ?");
                stmt.setString(1,employee.getFirstName());
                stmt.setString(2,employee.getLastName());
                stmt.setInt(3,((Employee) employee).getCompanyId());
                stmt.setString(4,employee.getUserName());
                stmt.setString(5,employee.getPassWord());
                ResultSet userResult = stmt.executeQuery();
                userResult.next();
                return userResult.getInt("ID");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
        return -1;
    }

    @Override
    public User findById(int employeeId) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select u.ID as user_ID,\n" +
                    "e.ID as employee_ID,\n" +
                    "company_ID,\n" +
                    "username,\n" +
                    "pass,\n" +
                    "first_name,\n" +
                    "last_name\n" +
                    "from users u \n" +
                    "inner join employees e\n" +
                    "on e.user_id = u.ID where e.ID = ?");
            stmt.setInt(1, employeeId);
            ResultSet userResult = stmt.executeQuery();

            while (userResult.next()) {
                int userId = userResult.getInt("user_ID");
                int companyId = userResult.getInt("company_ID");
                String firstName = userResult.getString("first_name");
                String lastName = userResult.getString("last_name");
                String username = userResult.getString("username");
                String password = userResult.getString("pass");
                return new Employee(userId, employeeId, companyId, firstName, lastName, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong");
        }
        return null;
    }

    @Override
    public void create(User employee) {
        if (employee instanceof Employee) {
            try {
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into Users(username,pass) values (?,?)");
                stmt.setString(1, employee.getUserName());
                stmt.setString(2, employee.getPassWord());
                stmt.executeUpdate();
                stmt = conn.prepareStatement("select ID from Users where username = ? and pass = ?");
                stmt.setString(1, employee.getUserName());
                stmt.setString(2, employee.getPassWord());
                ResultSet userResult = stmt.executeQuery();
                userResult.next();
                stmt = conn.prepareStatement("insert into Employees(first_name,last_name,company_ID,user_ID) values (?,?,?,?)");
                stmt.setString(1, employee.getFirstName());
                stmt.setString(2, employee.getLastName());
                stmt.setInt(3, (((Employee) employee).getCompanyId()));
                stmt.setInt(4, userResult.getInt("ID"));
                stmt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Something went wrong");
            }
        } else {
            System.out.println("Insert a employee");
        }
    }

    @Override
    public void update(User employee) {
        if (employee instanceof Employee) {
            try {
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement("update employees set first_name = ?, last_name = ?, company_ID = ? where ID = ?");
                stmt.setString(1, employee.getFirstName());
                stmt.setString(2, employee.getLastName());
                stmt.setInt(3, ((Employee) employee).getCompanyId());
                stmt.setInt(4, ((Employee) employee).getEmployeeId());
                stmt.executeUpdate();
                stmt = conn.prepareStatement("update users set username = ?, pass = ? where ID =?");
                stmt.setString(1, employee.getUserName());
                stmt.setString(2, employee.getPassWord());
                stmt.setInt(3, employee.getUserId());
                stmt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Something went wrong");
            }

        }
    }

    @Override
    public void remove(User employee) {
        if (employee instanceof Employee) {
            try {
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement("set SQL_SAFE_UPDATES = 0;");
                stmt.execute();
                stmt = conn.prepareStatement("delete from employees where ID = ? and first_name = ? and last_name = ? and company_ID = ? and user_ID = ?");
                stmt.setInt(1, ((Employee) employee).getEmployeeId());
                stmt.setString(2, employee.getFirstName());
                stmt.setString(3, employee.getLastName());
                stmt.setInt(4, ((Employee) employee).getCompanyId());
                stmt.setInt(5, employee.getUserId());
                stmt.executeUpdate();
                stmt = conn.prepareStatement("delete from users where ID = ? and username = ? and pass = ?");
                stmt.setInt(1, employee.getUserId());
                stmt.setString(2, employee.getUserName());
                stmt.setString(3, employee.getPassWord());
                stmt.executeUpdate();
                stmt = conn.prepareStatement("set SQL_SAFE_UPDATES = 1");
                stmt.execute();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
    }

    public void remove(int employeeId) {
        User employee = findById(employeeId);
        remove(employee);
    }
}
