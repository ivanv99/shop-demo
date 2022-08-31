package com.ivanvelev.repositories;

import com.ivanvelev.models.Item;
import com.ivanvelev.utils.HibernateTestsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemRepositoryTests {

    private final ItemRepository itemRepository = new ItemRepositoryImpl();

    @Test
    public void test() {
        Item one = HibernateTestsUtil.item("bike", 1);
        Item two = HibernateTestsUtil.item("book", 2);
        Item three = HibernateTestsUtil.item("apple", 3);
        Item four = HibernateTestsUtil.item("phone", 4);
        Item five = HibernateTestsUtil.item("laptop", 5);

        itemRepository.createItem(one);
        itemRepository.createItem(two);
        itemRepository.createItem(three);
        itemRepository.createItem(four);
        itemRepository.createItem(five);

        Assertions.assertEquals(5, itemRepository.getAllItems().size());

        Item itemToChange = itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue());
        itemToChange.setName("motorbike");
        itemToChange.setPrice(333.44);

        itemRepository.updateItem(itemToChange);

        Item changedItem = itemRepository.getItemById(itemRepository.getAllItems().get(itemRepository.getAllItems().size() - 1).getId().intValue());

        Assertions.assertEquals("motorbike", changedItem.getName());

        itemRepository.deleteItem(one);
        itemRepository.deleteItem(two);
        itemRepository.deleteItem(three);
        itemRepository.deleteItem(four);
        itemRepository.deleteItem(five);

        Assertions.assertEquals(0, itemRepository.getAllItems().size());
    }
}
