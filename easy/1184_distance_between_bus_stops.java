class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) return distanceBetweenBusStops(distance, destination, start);
        int oneDis = 0;
        int otherDis = 0;
        int i = start;
        while (i < destination) {
            oneDis += distance[i];
            i++;
        }
        while (i != start) {
            otherDis += distance[i];
            i = (i + 1) % distance.length;
        }
        return Math.min(oneDis, otherDis);
    }
}