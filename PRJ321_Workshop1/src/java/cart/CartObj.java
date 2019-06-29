/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.Serializable;
import static java.rmi.server.LogStream.log;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author son
 */
public class CartObj implements Serializable {

    private String customerID;
    private Map<String, Pair<String, Integer>> items;

    public CartObj() {
    }

    public CartObj(String customerID, Map<String, Pair<String, Integer>> items) {
        this.customerID = customerID;
        this.items = items;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Map<String, Pair<String, Integer>> getItems() {
        return items;
    }

    public void setItems(Map<String, Pair<String, Integer>> items) {
        this.items = items;
    }

    
    public void addToCart(String itemID, String item) {
        if (items == null) {
            items = new HashMap<>();
        }
        if (items.containsKey(itemID)) {
            int oldQuantity = items.get(itemID).getValue();
            items.put(itemID, new Pair(item, oldQuantity + 1));
        } else {
            items.put(itemID, new Pair(item, 1));
        }
    }

    public void removeItemFromCart(String itemID) {
        if (items == null) {
            return;
        }
        items.remove(itemID);
    }
}
