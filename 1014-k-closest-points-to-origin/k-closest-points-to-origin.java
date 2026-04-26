class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Comparator<int[]> c = (a,b) -> {
            int ad = a[0]*a[0] + a[1]*a[1];
            int bd = b[0]*b[0] + b[1]*b[1];
                            
            return Integer.compare(bd, ad);

            /*
            Above logic is trimed from this -
            Compare distance between the points from its origin 
            using Euclidean distance formula

            double ad = Math.pow(Math.pow(a[0],2) + Math.pow(a[1],2) , 0.5);
            double bd = Math.pow(Math.pow(b[0],2) + Math.pow(b[1],2) , 0.5);
                            
            return Double.compare(bd, ad);
            */
        };

        PriorityQueue<int[]> heap = new PriorityQueue<>(c);

        for(int i=0; i<k; i++) {
            heap.add(points[i]);
        }

        //heap.stream().forEach(h -> System.out.println(h[0] +","+ h[1]));

        for(int i=k; i<points.length; i++) {
            if(c.compare(points[i], heap.peek()) == 1) {
                heap.poll();
                heap.add(points[i]);
            }
        }

        return heap.stream().toArray(int[][]::new);
    }
}