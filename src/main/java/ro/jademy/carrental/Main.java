package ro.jademy.carrental;

import ro.jademy.carrental.data.Data;
import ro.jademy.carrental.shop.Shop;

public class Main {

    public static void main(String[] args) {
        // Q: this is the main entry point of our program. What should we do here?
        Data.carList();
        Data.userList();
        Data.carListMixer(Data.users,Data.carList);
        Shop myShop = new Shop(Data.users);
        while(!myShop.start());
        }
    }
