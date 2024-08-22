
class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> arr;
    Random r;

    public RandomizedSet() {
        hm = new HashMap<>();
        arr = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (!hm.containsKey(val)) {
            hm.put(val, arr.size());
            arr.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        }
        
        int idx1 = hm.get(val);
        int idx2 = arr.size() - 1;
        int lastElement = arr.get(idx2);
        
        // Swap the element to be removed with the last element
        arr.set(idx1, lastElement);
        hm.put(lastElement, idx1);

        // Remove the last element from the list
        arr.remove(idx2);
        hm.remove(val);

        return true;
    }

    public int getRandom() {
        int t = r.nextInt(arr.size());
        return arr.get(t);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */