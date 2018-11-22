package pkg2.pkg3.pkg4._tree;

public class _tree {

    public static void main(String[] args) {

        Node s=new Node();
      Node temp[];
          Node arr[]=new Node[4];            
        for(int i=0;i<4;i++)
        {
            arr[i]=new Node();
        }
    
      
         s.insert(arr,5);
         s.insert(arr,8);
         s.insert(arr,6);
         s.insert(arr,4);

         s.insert(arr,3);
         s.insert(arr,2);
        s.insert(arr,9);
         s.insert(arr,10);
         s.insert(arr,11);
       s.insert(arr,12);
       
         s.insert(arr,1);    
        s.insert(arr,7);
        s.Check(arr, 1111);
        System.out.println("inorder traversal");
        s.traverse(arr);
    }
}