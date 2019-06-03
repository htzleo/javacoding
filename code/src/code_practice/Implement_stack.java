package code_practice;

import java.util.ArrayList;
import java.util.List;

public class Implement_stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    List<Integer> list = new ArrayList<>();
    // 压入新元素
    public void push(int x) {
        // write your code here
        list.add(x);
    }

    /*
     * @return: nothing
     */
    // 栈顶元素弹出
    public void pop() {
        // write your code here
        if (!list.isEmpty()){
            list.remove(list.size()-1);
        }
    }

    /*
     * @return: An integer
     */
    // 返回栈顶元素
    public int top() {
        // write your code here
        return list.get(list.size()-1);
    }

    /*
     * @return: True if the stack is empty
     */
    // 判断是否是空栈
    public boolean isEmpty() {
        // write your code here
        return list.size() == 0;
    }
}
