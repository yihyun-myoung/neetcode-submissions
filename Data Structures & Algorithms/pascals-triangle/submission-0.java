class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>(List.of(1)));

        if (numRows == 1)
            return answer;
            
        answer.add(new ArrayList<>(List.of(1, 1)));

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = answer.get(i - 1);
            List<Integer> newRow = new ArrayList<>(List.of(1));
            for (int j = 0; j < row.size() - 1; j++) {
                newRow.add(row.get(j) + row.get(j + 1));
            }
            newRow.add(1);
            answer.add(newRow);
        }
        return answer;
    }
}