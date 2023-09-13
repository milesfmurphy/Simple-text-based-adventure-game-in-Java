package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private final String name;
  private final Inventory inventory;
  private Position position;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.position = new PositionImpl(startX, startY);
    this.inventory = new InventoryImpl();
  }

  public Position getPosition() {
    return position;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public String getName() {
    return name;
  }

  public void move(Direction direction) {
    position = position.getNeighbor(direction);
  }
}
