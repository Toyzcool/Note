package Two;

class Sequence {
    private Object[] items;
    // 记录数组位置
    private int next = 0;

    Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector{
        private int i = 0;
        @Override public boolean end() {
            return i == items.length;
        }

        @Override public Object current() {
            return items[i];
        }

        @Override public void next() {
            if(i < items.length)
                i++;
        }
        // 生成对外部类的引用
        public Sequence getSequence(){
            return Sequence.this;
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }

}
