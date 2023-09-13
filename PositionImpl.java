package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {

    switch (direction) {
      case EAST:
        return new PositionImpl(x + 1, y);

      case WEST:
        return new PositionImpl(x - 1, y);

      case NORTH:
        return new PositionImpl(x, y + 1);

      case SOUTH:
        return new PositionImpl(x, y - 1);
    }
    return null;
  }
}
