class Solution {
    public int largestAltitude(int[] gain) {
        int[] result = IntStream.of(gain)
                .boxed()
                .reduce(
                    new int[]{0, 0},
                    (r, g) -> {
                        r[0] += g;
                        r[1] = Math.max(r[1], r[0]);
                        return r;
                    },
                    (r1, r2) -> r1
                );

        return result[1];
    }
}
