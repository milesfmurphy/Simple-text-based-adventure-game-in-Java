package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int items;
  private final Cell[][] map;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) throw new IllegalArgumentException();
    map = new Cell[width][height];
    this.items = numItems;
  }

  public int getWidth() {
    return map.length;
  }

  public int getHeight() {
    return map[0].length;
  }

  public Cell getCell(int x, int y) {
    if (getWidth() <= x || getHeight() <= y) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (x < 0 || y < 0) throw new ArrayIndexOutOfBoundsException();
    return map[x][y];
  }

  public Cell getCell(Position position) {
    if (getWidth() <= position.getX() || getHeight() <= position.getY()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (position.getX() < 0 || position.getY() < 0) throw new ArrayIndexOutOfBoundsException();
    return map[position.getX()][position.getY()];
  }

  public void initCell(int x, int y) {
    if (getWidth() <= x || getHeight() <= y) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (x < 0 || y < 0) throw new ArrayIndexOutOfBoundsException();
    map[x][y] = new CellImpl(x, y);
  }

  public int getNumItems() {
    return items;
  }
}
