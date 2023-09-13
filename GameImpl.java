package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null) {
      throw new IllegalArgumentException();
    }
    if (player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return player.getInventory().getNumItems() == map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited())
      System.out.println("You have already visited this location.");

    if (map.getCell(player.getPosition()).hasChest())
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");

    map.getCell(player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!map.getCell(player.getPosition()).hasChest())
      System.out.println("No chest to open, sorry!");
    else if (map.getCell(player.getPosition()).getChest().isEmpty())
      System.out.println("The chest is empty.");
    else {
      System.out.println(
          "You collected these items: " + map.getCell(player.getPosition()).getChest().getItems());
      player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position position = player.getPosition().getNeighbor(direction);
    if (position.getX() >= map.getWidth()
        || position.getY() >= map.getHeight()
        || position.getX() < 0
        || position.getY() < 0) return false;
    else {
      Cell posCell = map.getCell(position);
      return posCell != null;
    }
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else System.out.println("You can't go that way! Try another direction.");
  }
}
