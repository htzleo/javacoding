package code_practice;

public class ThreeStacks {
    public int stackSize;
    public int indexUsed; //indexUsed记录整个数组中的所用的索引数
    public int[] stackPointer; //记录三个栈顶指针stackPointer，也就是三个栈顶所在的数组索引
    public StackNode[] buffer;
    ///数组buffer中的每一个元素，并不能单单是简单的int类型，而是一个链表中的节点，它包含值value，栈中向栈底方向的之前元素索引prev，向栈顶方向的后来元素索引next

    public ThreeStacks(int size){
        // do intialization if necessary
        //构造：要初始化stackPointer为3个-1,
        // 表示没有;indexUsed=0;buffer为一个长度为三倍栈大小的数组
        stackSize = size;
        stackPointer = new int[3];
        for (int i = 0;i<3;i++){
            stackPointer[i] = -1;
        }
        indexUsed = 0;
        buffer = new StackNode[stackSize*3];
    }

    public void push(int stackNum, int value){
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value, -1);
        if (lastIndex != -1){
            buffer[lastIndex].next=stackPointer[stackNum];
        }
    }
    public int pop(int stackNum){
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        if (lastIndex != indexUsed -1){
            swap(lastIndex,indexUsed-1,stackNum);
        }
        stackPointer[stackNum] = buffer[stackPointer[stackNum]].prev;
        if (stackPointer[stackNum] != -1)
            buffer[stackPointer[stackNum]].next = -1;

        buffer[indexUsed-1] = null;
        indexUsed --;
        return value;
    }

    public int peek(int stackNum){
        return buffer[stackPointer[stackNum]].value;
    }

    public boolean isEmpty(int stackNum){
        return stackPointer[stackNum] == -1;
    }
    public void swap(int lastIndex, int topIndex, int stackNum) {
        if (buffer[lastIndex].prev == topIndex) {
            int tmp = buffer[lastIndex].value;
            buffer[lastIndex].value = buffer[topIndex].value;
            buffer[topIndex].value = tmp;
            int tp = buffer[topIndex].prev;
            if (tp != -1) {
                buffer[tp].next = lastIndex;
            }
            buffer[lastIndex].prev = tp;
            buffer[lastIndex].next = topIndex;
            buffer[topIndex].prev = lastIndex;
            buffer[topIndex].next = -1;
            stackPointer[stackNum] = topIndex;
            return;
        }

        int lp = buffer[lastIndex].prev;
        if (lp != -1)
            buffer[lp].next = topIndex;

        int tp = buffer[topIndex].prev;
        if (tp != -1)
            buffer[tp].next = lastIndex;

        int tn = buffer[topIndex].next;
        if (tn != -1)
            buffer[tn].prev = lastIndex;
        else {
            for (int i = 0; i < 3; ++i)
                if (stackPointer[i] == topIndex)
                    stackPointer[i] = lastIndex;
        }

        StackNode tmp = buffer[lastIndex];
        buffer[lastIndex] = buffer[topIndex];
        buffer[topIndex] = tmp;
        stackPointer[stackNum] = topIndex;
    }
}

class StackNode{
    public int prev, next;
    public int value;
    public StackNode(int p,int v,int n){
        value = v;
        prev = p;
        next = n;
    }
}
