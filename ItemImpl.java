package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    this.name = name;
    if (name == null) {
      throw new IllegalArgumentException("Name is null!");
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    else if (!(other.getClass() == ItemImpl.class)) throw new IllegalArgumentException();
    else return ((ItemImpl) other).getName().equals(this.getName());
  }

  @Override
  public String toString() {
    return this.name;
  }
}
