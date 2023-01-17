class SnapshotArray {

    Map<Integer, Integer>[] hashArr;
    int size;
    int id;
    
    public SnapshotArray(int length) {
        
        size = length;
        hashArr = new HashMap[length];
        id = 0;
    }
    
    public void set(int index, int val) {
        
        if(hashArr[index] == null){
            hashArr[index] = new HashMap<>();
        }
        
        hashArr[index].put(id, val);
    }
    
    public int snap() {
        
        id++;
        return id - 1;
    }
    
    public int get(int index, int snap_id) {
        
        if(hashArr[index] == null){
            return 0;
        }
        
        while(snap_id >= 0 && hashArr[index].containsKey(snap_id) == false){
            snap_id--;
        }
        
        if(snap_id == -1){
            return 0;
        }
        
        return hashArr[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */