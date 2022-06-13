package com.ivanvelev.repositories;

import com.ivanvelev.models.Item;
import com.ivanvelev.models.User;
import com.ivanvelev.util.Util;
import org.junit.Assert;
import org.junit.Test;

public class ItemRepositoryTests {

    private final ItemRepository itemRepository = new ItemRepositoryImpl();

    @Test
    public void test() {
        Item one = Util.item("bike",1);
        Item two = Util.item("book",2);
        Item three = Util.item("apple",3);
        Item four = Util.item("phone",4);
        Item five = Util.item("laptop",5);

        itemRepository.createItem(one);
        itemRepository.createItem(two);
        itemRepository.createItem(three);
        itemRepository.createItem(four);
        itemRepository.createItem(five);

        Assert.assertEquals(5, itemRepository.getAllItems().size());

        Item itemToChange = itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue());
        itemToChange.setName("motorbike");
        itemToChange.setPrice(333.44);

        itemRepository.updateItem(itemToChange);

        Item changedItem = itemRepository.getItemById(itemRepository.getAllItems().get(itemRepository.getAllItems().size() - 1).getId().intValue());

        Assert.assertEquals("motorbike", changedItem.getName());

        itemRepository.deleteItem(one);
        itemRepository.deleteItem(two);
        itemRepository.deleteItem(three);
        itemRepository.deleteItem(four);
        itemRepository.deleteItem(five);

        Assert.assertEquals(0, itemRepository.getAllItems().size());
    }
}
