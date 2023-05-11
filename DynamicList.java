import java.util.NoSuchElementException;

public class DynamicList<T> {
    public int length = 0;
    private int size = 0;
    T[] list;

    public DynamicList() {
        this.size = 1;
        this.list = (T[]) new Object[this.size];
    }

    public void add(T element) {
        if (this.length < this.size) {
            this.list[this.length] = element;
        } else {
            this.size *= 2;
            this.list = extendList(this.list);
            this.list[this.length] = element;
        }
        this.length++;
    }

    public int size() {
        return this.length;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalAccessError();
        } else if (index >= this.length) {
            throw new IllegalAccessError();
        }
        return this.list[index];
    }

    public int indexOf(T element) {
        for (int index = 0; index < this.length; index++) {
            if (this.list[index] == element) {
                return index;
            }
        }
        return -1;
    }

    public void pop() {
        if (this.length < 1) {
            throw new NoSuchElementException("Nothing to remove");
        }
        this.list[this.length - 1] = null;
        this.length--;
    }

    public void remove(int indexToRemove) {
        if (indexToRemove >= this.length || indexToRemove < 0) {
            throw new IllegalArgumentException();
        } else if (this.length - 1 == indexToRemove) {
            pop();
        } else {
            for (int index = indexToRemove; index < this.length - 1; index++) {
                this.list[index] = this.list[index + 1];
            }
        }
        this.length--;
    }

    private T[] extendList(T[] originalList) {
        T[] tempList = (T[]) new Object[this.size];
        for (int index = 0; index < this.length; index++) {
            tempList[index] = originalList[index];
        }
        return tempList;
    }

    @Override
    public String toString() {
        if (this.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int index = 0; index < this.length - 1; index++) {
            result += String.valueOf(this.list[index]) + ",";
        }
        result += String.valueOf(this.list[this.length - 1]) + "]";
        return result;
    }
}