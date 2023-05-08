package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Items;

public interface ItemsDao {
	public Items saveItems(int mid, Items Items);

	public Items getItemsbyId(int id);

	public boolean deleteItemsId(int id);

	public Items updateItems(int id, Items Items);

	public List<Items> getAllItem();
}
