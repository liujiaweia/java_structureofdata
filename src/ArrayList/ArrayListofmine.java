package ArrayList;
//所有的类都继承Object
public class ArrayListofmine<E> {

    private int size;
    private E[] elements;

    //定义静态变量
    private static final int DEFAULT_CAPATICY = 10;
    private static final int ELEMENT_NO_FOUNT = -1;

    //有参构造
    public ArrayListofmine(int capaticy){
        capaticy = (capaticy<DEFAULT_CAPATICY)?DEFAULT_CAPATICY:capaticy;
        elements = (E[]) new Object[capaticy];
    }
    //无参构造
    public ArrayListofmine(){
        this(DEFAULT_CAPATICY);
    }
    //数组大小
    public int size(){
        return size;
    }
    //数组是否为空
    public boolean isempty(){
        return size==0;
    }
    //包含
    public boolean contains(E element){
        return indeOf(element)!=ELEMENT_NO_FOUNT;
    }
    //get函数
    public E get(int index){
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException("数组越界");

        return elements[index];
    }
    //替换后 返回添加前 的数值
    public E set(int index,E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return  old;
    }
    //查找下标
    public int indeOf(E element){
        if(element==null) {
            for(int i=0;i<size;i++){
                if(elements[i]==null)
                    return i;
            }
        }
        else{
            for(int i=0;i<size;i++){
                if(element.equals(elements[i]))
                    return i;
            }
        }
        return ELEMENT_NO_FOUNT;
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+",Size"+size);
    }
    private void rangeCheck(int index){
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException("Index:"+index+",Size"+size);
    }
    private void rangeCheckAdd(int index){
        if(index<0||index>size)
            throw new IndexOutOfBoundsException("Index:"+index+",Size"+size);
    }
    //清楚所有元素
    public void clear(){
        for(int i=0;i<size;i++){
            elements[i] = null;
        }
        size = 0;
    }
    //添加
    public void add(E element){
        add(size,element);
    }
    //删除
    public E remove(int index){
       rangeCheck(index);
        E old = elements[index];
        for(int i=index+1;i<=size-1;i++){
            elements[i-1] = elements[i];
        }
        //size--;
        elements[--size] = null;
        trim();
        return old;
    }
    //指定位置添加
    public void add(int index,E element){

        rangeCheckAdd(index);

        ensureCapacity(size+1);


        for(int i=size-1;i>=index;i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    //扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity>=capacity) return;
        //扩容1.5倍;
        int newcapacity = oldCapacity+(oldCapacity>>1);
        E[] newElements = (E[]) new Object[newcapacity];
        for(int i=0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity+"扩容为"+newcapacity);

    }
    private void trim(){
        int oldCapacity = elements.length;
        int newcapacity = oldCapacity>>1 ;
        if(size>=newcapacity||oldCapacity<=DEFAULT_CAPATICY) return ;

        E[] newElements = (E[]) new Object[newcapacity];
        for(int i=0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity+"缩容为"+newcapacity);
    }

    //输出
    @Override
    public String toString() {
        StringBuilder string =  new StringBuilder();
        string.append("size==").append(size).append(",[");
        for(int i=0;i<size;i++){
            string.append(elements[i]);
            if(i!=size-1)
                string.append(",");
        }
        string.append("]");
        return string.toString();
    }


}
