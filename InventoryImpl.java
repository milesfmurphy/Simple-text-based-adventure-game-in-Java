package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> inventory;

  public InventoryImpl() {
    inventory = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return inventory.isEmpty();
  }

  @Override
  public int getNumItems() {
    return inventory.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> newlist = new ArrayList<>();
    int x = 0;
    while (x < getNumItems()) {
      newlist.add(inventory.get(x));
      x++;
    }
    return newlist;
  }

  @Override
  public void addItem(Item item) {
    inventory.add(0, item);
  }

  @Override
  public void removeItem(Item item) {
    inventory.remove(item);
  }

  @Override
  public void clear() {
    inventory.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    if (other == null) {
      throw new IllegalArgumentException();
    }
    List<Item> newlist = other.getItems();
    other.clear();
    inventory.addAll(newlist);
  }
}
