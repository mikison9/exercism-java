import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

class CustomHashMap<T> {
    ArrayList<LinkedList<T>> array;
    int size;
    int itemCount;

    CustomHashMap(Integer size) {
        if (size == null) {
            this.size = 10;
        } else {
            this.size = size;
        }

        this.array = new ArrayList<>(this.size);
        for (int i = 0; i < this.size; i++) {
            this.array.add(new LinkedList<>());
        }
        itemCount = 0;
    }

    int hash(T value) {
        return value.hashCode() % this.size;
    }

    void resize(int newSize) {
        ArrayList<LinkedList<T>> newArray = new ArrayList<>(newSize);

        for (int i = 0; i < newSize; i++) {
            this.array.add(new LinkedList<>());
        }

        for (LinkedList<T> l : this.array) {
            for (T item : l) {
                int newHash = item.hashCode() % newSize;
                newArray.get(newHash).add(item);
            }
        }
        this.array = newArray;
    }

    void add(T value) {
        int hash = this.hash(value);
        this.array.get(hash).add(value);
        this.itemCount++;
        if (this.itemCount == this.array.size()) {
            this.resize(this.array.size());
        }
    }

    void remove(T value) {
        int hash = this.hash(value);
        this.array.get(hash).remove(value);
        this.itemCount--;
    }

    boolean contains(T value) {
        int hash = this.hash(value);
        return this.array.get(hash).contains(value);
    }

    boolean isEmpty() {
        return this.itemCount == 0;
    }
}

class CustomSet<T> {
    CustomHashMap<T> map = new CustomHashMap<>(10);

    CustomSet() {

    }

    CustomSet(Collection<T> data) {
        for (T elem : data) {
            this.add(elem);
        }
    }

    boolean isEmpty() {
        return this.map.isEmpty();
    }

    boolean contains(T element) {
        return this.map.contains(element);
    }

    boolean isDisjoint(CustomSet<T> other) {
        return this.getIntersection(other).isEmpty();
    }

    boolean add(T element) {
        if (!this.contains(element)) {
            this.map.add(element);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            CustomSet<T> other = (CustomSet<T>) obj;

            return this.isSubset(other) && other.isSubset(this);
        } else {
            return false;
        }
    }

    CustomSet<T> getIntersection(CustomSet<T> other) {
        CustomSet<T> intersection = new CustomSet<>();

        for (LinkedList<T> l : this.map.array) {
            for (T elem : l) {
                if (other.contains(elem)) {
                    intersection.add(elem);
                }
            }
        }

        return intersection;
    }

    CustomSet<T> getUnion(CustomSet<T> other) {
        CustomSet<T> union = new CustomSet<>();

        for (LinkedList<T> l : this.map.array) {
            for (T elem : l) {
                union.add(elem);
            }
        }

        for (LinkedList<T> l : other.map.array) {
            for (T elem : l) {
                union.add(elem);
            }
        }

        return union;
    }

    CustomSet<T> getDifference(CustomSet<T> other) {
        CustomSet<T> difference = new CustomSet<>();

        for (LinkedList<T> l : this.map.array) {
            for (T elem : l) {
                if (!other.contains(elem)) {
                    difference.add(elem);
                }
            }
        }

        return difference;
    }

    boolean isSubset(CustomSet<T> other) {
        for (LinkedList<T> l : other.map.array) {
            for (T elem : l) {
                if (!this.contains(elem)) {
                    return false;
                }
            }
        }

        return true;
    }
}
