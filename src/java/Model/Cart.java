/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart {

    private List<Item> item;

    public Cart(List<Item> item) {
        this.item = item;
    }

    public Cart() {
        item = new ArrayList<>();
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    private Item getItemByProductCode(int id) {
        for (Item o : item) {
            if (o.getProduct().getId() == id) {
                return o;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Item i = new Item();

    }

    //Thêm sản phẩm vào giỏ 
    public void addItemToCard(Item t) {

        //Trong giỏ đã có item
        if (getItemByProductCode(t.getProduct().getId()) != null) {
            //Cộng dồn số lượng
            Item i = getItemByProductCode(t.getProduct().getId());
            i.setQuantity(i.getQuantity() + 1);
            System.out.println(i.getQuantity());
        } else {
            // chưa có sản phẩm trong giỏ
            item.add(new Item(t.getProduct(), 1, t.getPrice()));

        }

    }

    public void divItemToCard(Item t) {
        //Trong giỏ đã có item
        if (getItemByProductCode(t.getProduct().getId()) != null) {
            //Tr? dồn số lượng
            Item i = getItemByProductCode(t.getProduct().getId());
            i.setQuantity(i.getQuantity() - 1);
        }
    }
    
    
//    trả về số lượng

    public int getQuantityByProductCode(int id) {
        return getItemByProductCode(id).getQuantity();
    }
    
    public void removeItem(int ProductCode) {
        if (getItemByProductCode(ProductCode) != null) {
            item.remove(getItemByProductCode(ProductCode));
        }
    }
    
    public double getTotal() {
        double total = 0;
        double totalorder = 0;
        for (Item o : item) {
            total += o.getQuantity() * o.getPrice();
            
        }
        return total;
    }
}
