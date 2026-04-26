class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++){
            int n = res.size();
            for(int j=0;j<n;j++){
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(nums[i]);
                res.add(t);
            }
        }
        return res;
    }
}