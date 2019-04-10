package com.dsoft.service;


import com.dsoft.entity.Item;

public interface ItemService {
	public Item addNewItem(Item item);
	public Item findItemById(Long itemId);
}
