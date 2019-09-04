//顺序表
public class MyArrayList implements List {
    int[] array=null;
    int size=0;//数组中 实际元素个数
    private int[] ensureCapacity() {
        //1.申请新房子
        int newCapacity=array.length+array.length/2;
        int[] newArray=new int[newCapacity];
        System.arraycopy(array,0,newArray,0,size);
        this.array=newArray;
        return array;
    }
    @Override
    public boolean add(int element) {
        //尾插
        if(size==0){
            array[0]=element;
            size++;
        }else{
            array[size]=element;
        }
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        //指定坐标 插入元素
        if(index<0||index>=size){
            System.out.println("下标错误");
            return false;
        }else{
            //计算大小，申请内存
            if(size<array.length){
                System.arraycopy(array,index,array,index+1,size-index);
                array[index]=element;
            }else{
                int[] newArray=ensureCapacity();
                System.arraycopy(newArray,index,newArray,index+1,size-index);
                newArray[index]=element;
            }
        }
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        //获取该处坐标值
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        //修改该处坐标值
        array[index]=val;
        return array[index];
    }

    @Override
    public int remove(int index) {
        //删除该出数字
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return array[index];
    }

    @Override
    public int size() {
        //获取数组实际元素的长度
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator Iterator() {
        return null;
    }
}
