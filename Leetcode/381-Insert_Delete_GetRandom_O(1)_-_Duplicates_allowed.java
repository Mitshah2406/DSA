
class RandomizedCollection {
    private Map<Integer, Set<Integer>> hm;
    private List<Integer> arr;
    private Random r;

    public RandomizedCollection() {
        hm = new HashMap<>();
        arr = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        boolean contains = hm.containsKey(val);
        hm.computeIfAbsent(val, k -> new HashSet<>()).add(arr.size());
        arr.add(val);
        return !contains;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) return false;

        Set<Integer> indices = hm.get(val);
        int removeIdx = indices.iterator().next();
        indices.remove(removeIdx);

        if (indices.isEmpty()) {
            hm.remove(val);
        }

        int lastIdx = arr.size() - 1;
        if (removeIdx != lastIdx) {
            int lastElement = arr.get(lastIdx);
            arr.set(removeIdx, lastElement);
            Set<Integer> lastIndices = hm.get(lastElement);
            lastIndices.remove(lastIdx);
            lastIndices.add(removeIdx);
        }

        arr.remove(lastIdx);

        return true;
    }

    public int getRandom() {
        return arr.get(r.nextInt(arr.size()));
    }
}


