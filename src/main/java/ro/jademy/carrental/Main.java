package ro.jademy.carrental;

import ro.jademy.carrental.dao.DBEmployeeDao;
import ro.jademy.carrental.dao.UserDao;
import ro.jademy.carrental.data.Data;
import ro.jademy.carrental.model.users.Employee;
import ro.jademy.carrental.model.users.User;
import ro.jademy.carrental.shop.Shop;

public class Main {

    public static void main(String[] args) {
        // Q: this is the main entry point of our program. What should we do here?
        UserDao users = new DBEmployeeDao();
        User employee = new Employee("Flo","Florinescu","florin.florinesc","flo123",1);
        users.create(employee);
        users.findAll().stream().forEach(User -> System.out.println(User));
        User employee1 = users.findById(users.findId(employee));
        employee1.setPassWord("florinescu123");
        employee1.setFirstName("Florin");
        users.update(employee1);
        users.findAll().stream().forEach(User -> System.out.println(User));
        users.remove(employee1);
        users.findAll().stream().forEach(User -> System.out.println(User));

        /*Data.carList();
        Data.userList();
        Data.carListMixer(Data.users,Data.carList);
        Shop myShop = new Shop(Data.users);
        while(!myShop.start());
        }*/
    }
}
