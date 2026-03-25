package org.dsa;

public class CirculerQueue {
    int[] cQueue;
    int f,r;
    int size;
    public CirculerQueue(int size){
        cQueue = new int[size];
        this.size = size;
        this.f = -1;
        this.r = -1;
    }
    public CirculerQueue(){}
    public void insert(int x){
        if((f == 0 && r==size-1)||(f==r+1)){
            System.out.println("Queue is full");
            return;
        }
        if( f== -1 ) f= 0;
        if(r==size-1) r= 0;
        else r ++;
        cQueue[r] = x;
    }

    public int delete(){
        int y ;
        if(f == -1 ){
            System.out.println("Queue is Empty..");
            return -1;
        }
        y =cQueue[f];
        if( f ==r )
            f = r = -1;
        else if(f == size-1 )
            f = 0;
        else f++;
        return  y;
    }


    public void display(){
        if(f==-1){
            System.out.println("Queue is Empty");
            return;
        }
        int i = f;
        if(f<=r){
            while( i<= r){
                System.out.print(cQueue[i++]+" ");
            }
        }
        else{
            while(i<= size -1 ){
                System.out.print(cQueue[i++]+ " ");
            }
            i = 0;
            while(i<=r) {
                System.out.println(cQueue[i++]+" ");
            }
            System.out.println();
        }

    }

    public void peek(){
        if(f==-1){
            System.out.println("Queue is Empty ");
            return;
        }
    }

}
