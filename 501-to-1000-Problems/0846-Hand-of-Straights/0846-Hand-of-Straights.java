class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        int numOfGroup = hand.length / groupSize;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0 ; i < hand.length; i++) {
            if (map.get(hand[i]) == null) {
                map.put(hand[i], 1);
            } else {
                map.put(hand[i], map.get(hand[i])+1);
            }
        }

        for (int count = 0; count < numOfGroup; count++) {
            Map.Entry<Integer, Integer> smallestOne = map.firstEntry();
            int smallest = smallestOne.getKey();
            int smallestValue = smallestOne.getValue();
            for (int i = 1; i < groupSize; i++) {
                if (map.get(smallest+i) == null) return false;
                map.put(smallest+i, map.get(smallest+i)-1);
                if (map.get(smallest+i) == 0)
                    map.remove(smallest+i);
            }
            if (smallestValue == 1)
                map.remove(smallest);
            else
                map.put(smallest, smallestValue-1);
        }

        return true;
    }
}