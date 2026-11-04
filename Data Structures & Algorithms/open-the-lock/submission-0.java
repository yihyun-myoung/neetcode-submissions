class Solution {
    public int openLock(String[] deadends, String target) {
        if (Arrays.asList(deadends).contains("0000"))
            return -1;

        Set<String> visited = new HashSet<>();

        record State(String lock, int count) {}

        Queue<State> queue = new ArrayDeque<>();
        
        queue.offer(new State("0000", 0));
        visited.add("0000");

        for (String i : deadends) visited.add(i);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.lock().equals(target))
                return current.count();

            for (int i = 0; i < 4; i++) {
                for (int dir : new int[] {-1, 1}) {
                    char[] digits = current.lock().toCharArray();

                    int number = digits[i] - '0';
                    int next = (number + dir + 10) % 10;

                    digits[i] = (char) ('0' + next);
                    String nextLock = new String(digits);

                    if (!visited.contains(nextLock)) {
                        visited.add(nextLock);
                        queue.offer(new State(nextLock, current.count() + 1));
                    }
                }
            }
        }

        return -1;
    }
}