package io.github.zaphodious.heroshop.gamelogic;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public abstract class Item {

    protected String name;

    protected int stackSize;
    protected int maxStackSize;

    protected Item(String name) {
        this(name, 1, Reference.DEFAULT_MAX_STACK_SIZE);
    }

    protected Item(String name, int stackSize) {
        this(name, stackSize, Reference.DEFAULT_MAX_STACK_SIZE);
    }

    protected Item (String name, int stackSize, int maxStackSize) {
        this.name = name;
        this.stackSize = stackSize;
        this.maxStackSize = maxStackSize;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void addToStack(int value) {
        stackSize += value;
    }

    public void addToStack() {
        addToStack(1);
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {

        return name.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
