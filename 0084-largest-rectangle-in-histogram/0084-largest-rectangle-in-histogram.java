// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n=heights.length;
//         if(n==1){
//             if(heights[n-1]==0){
//                 return 0;
//             }
//             return heights[n-1];
//         }
       
//         Stack<Integer> st =new Stack<>();
//         int [] nse=new int[n];
//         int [] pse=new int[n];
//         nse[n-1]=-1;
//         st.push(n-1);
//         //Next Smaller Element
//         for(int i=n-2;i>=0;i--){
//             while(!st.isEmpty() && heights[st.peek()]>heights[i]){
//                 st.pop();
//             }
//             if(st.isEmpty()){
//                 nse[i]=n;
//             }
//             else{
//                 nse[i]=st.peek();
//             }
//             st.push(i);
//         }
//         while(st.size()>0){
//             st.pop();
//         }

//         //previous Smaller Element
//         st.push(0);
//         pse[0]=-1;
        
//         for(int i=1;i<n;i++){
//             while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
//                 st.pop();
//             }
//             if(st.isEmpty()){
//                 pse[i]=n;
//             }
//             else{
//                 pse[i]=st.peek();
//             }
//             st.push(i);
//         }

//         // maximum area of rectangle 
    
//         int max = -1;

//         for(int i=0;i<n;i++){
//             int area =heights[i]*(nse[i]-pse[i]-1);
//             max=Math.max(max,area);
//         }

// return max;
//     }
// }
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        // Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        // Previous Smaller Element (PSE)
        // Note: Using strict '>' here allows duplicate elements to extend 
        // their boundaries properly across one of the two passes.
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Maximum area of rectangle
        int max = 0;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }
        
        return max;
    }
}
