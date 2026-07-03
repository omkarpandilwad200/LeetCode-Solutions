class MinStack {
    Stack<Long> st =new Stack<>();
    Long min= -1L; 

    public MinStack() {
        
    }
    
    public void push(int value) {
        Long x=(long)value;
        if(st.size()==0){
            st.push(x);
            min=x;
        }
        else if(x>=min){
            st.push(x);
        }
        else{
            st.push(2*x-min);
            min=x;

        }
    }
    
    public void pop() {
        if(st.size()==0){
            return ;
        }
        else if(st.peek()>=min){
            st.pop();
        }
        else if(st.peek()<min){
            Long q=2*min-st.peek();
            min=q;
            st.pop();
        }
    }
    
    public int top() {
        if(st.size()==0){
            System.out.print("Stack Is empty");
            return 0 ;
        }
        else if(st.peek()>=min){
            return st.peek().intValue();
        }
        else 
        {
            return min.intValue();
        }
     
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */