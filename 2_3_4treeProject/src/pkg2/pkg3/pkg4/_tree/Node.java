package pkg2.pkg3.pkg4._tree;

public class Node {
    
    Object data;
    Node root2[];
 Node left[];
 Node right[];
int z=0,len=0,p=0,j=-1,check=0;
    Node()
    {
        left=null;
        right=null;
        data=null;
        root2=null;
    }
    public Node[] insert(Node child[],Object d )
    {
          int i=0,j;
          Node parent[]=null;
        len=child.length;
    for(i=0;i<len;i++)
    {
        if(child[i].data==null && child[i].left==null && child[i].right==null)
        {
           child[i].data=d;
          
           break;
        }
      else if(child[i].data!=null && child[i].left==null && child[i].right==null)
      {
          if((int) child[i].data>(int)d)
          {
              j=(int)child[i].data;
              child[i].data=d;
              d=j;
              continue;
          }
      }
        else if(child[i].data!=null)
        {
         if(child[i].right!=null || child[i].left!=null)
         { 
            
             if((int)child[i].data>(int)d)
            {
                if(child[i].left!=null)
                {
                    z++;
                    parent=child;
                    root2=child;
                   child=insert(child[i].left,d);
                }
               else
                continue;
                root2=parent;
                break;
            }
            else if((int)child[i].data<(int)d)
            {
                    if(child[i].right!=null)
                            { 
                                parent=child;
                               root2=child;
                             child=insert(child[i].right,d);
                
                            }
                           else
                            continue;                  
                    root2=parent;
                    break;
            
            }

            }
        }
        }
            parent=root2;
            if(child!=null && parent!=null)
            {
                if(child[3].data!=null && parent[3].data!=null)
                {
                if((int)child[3].data==(int)parent[3].data)     
                    parent=null;
                }
            }
                if(child[3].data!=null)
            {

                child=split(child, parent);
             }

            return child;
            
    }
            
    public Node[] split(Node[] root1,Node[] root3)
       {
           int i=0,position=-1;
           Node newarr[]=new Node[4];
           Node newarr2[]=new Node[4];
            Node temp=new Node();
           for( i=0;i<4;i++)
           {
               newarr[i]=new Node();
               newarr2[i]=new Node();
           }
           
           newarr[0].data=root1[0].data;          
           newarr[0].left=root1[0].left;          
           newarr[0].right=root1[0].right;          
  
           newarr2[0].data=root1[2].data;
            newarr2[0].left=root1[2].left;
           newarr2[0].right=root1[2].right;
 
           newarr2[1].data=root1[3].data;
           newarr2[1].right=root1[3].right;
           newarr2[1].left=root1[3].left;

           root1[0].data=root1[1].data;
           if(root1[1].left!=null)
           {
               if(newarr[0].right!=null)
               {
               for(i=0;i<4;i++)
               {
                   if(root1[1].left[i].data!=null)
                   insert(newarr,(int)root1[1].left[i].data);
                    else
                       break;
               }
               }
               else if(newarr[0].right==null)
                   newarr[0].right=root1[1].left;
           }
           if(root1[1].right!=null)
           {
            if(newarr2[0].left!=null)
               {
               for(i=0;i<4;i++)
               {
                   if(root1[1].right[i].data!=null)
                   insert(newarr2,(int)root1[1].right[i].data);
                    else
                       break;
               }
               }
               else if(newarr2[0].left==null)
                   newarr2[0].left=root1[1].right;
           }
           root1[0].left=newarr;
           root1[0].right=newarr2;
           
           for( i=1;i<root1.length;i++)
            {
                 root1[i].data=null;
              }
           if(root3!=null)
           {
               for( i=0;i<root3.length;i++)
               {
                         if(root3[i].data!=null)
                        {
                            if((int) root3[i].data>(int)root1[0].data)
                             {                         
                                 if(position==-1)
                                           position=i;
                                            
                                        temp=root3[i];
                                        root3[i]=root1[0];
                                       root1[0]=temp;
                                       continue;
                                  }
                            else
                                continue;
                        }
                         else if(root3[i].data==null)
                         {
                                    if(position==-1)
                                    position=i;       
                             root3[i]=root1[0];         
                              break;               
                         }
               }
           } 
           if(root3!=null)
           {
               if(position==0)
               {
                   root3[position+1].left=null;

               }
               else if(position==1 || position==2)
               {
                   
                    if(root3[position+1].data!=null)
                    {  
                        root3[position-1].right=null;
                        root3[position+1].left=null;
                    }  
                    else if(root3[position+1].data==null)
                    root3[position-1].right=null;
                   
               }
               else if(position==3)
               {    
                    root3[position-1].right=null;
               }   
              
               root1=root3;
               
           }                                  
           return root1;
       }
public void traverse(Node[] r)        
{

    for(int j=0;j<4; j++)
    {
        if(r[j].data==null)
            break;
       if(r[j].left!=null)
       {
        traverse(r[j].left);
        }
            System.out.printf(" %d ",r[j].data);
       if(r[j].right!=null)
       {
        traverse(r[j].right);
       }
    }
}
public void Check(Node[] array,Object d)
    {
        if(!search(array,d) && check!=1)
         {
             System.out.println("Value not Found...");
         }
    }
    public boolean  search(Node[] array,Object d)
    {
        check=0;
        for(p=0;p<4;p++)
        {
            if(array[p].data==null)
            {
                break;
            }
            if((int)d == (int)array[p].data)
            {
                System.out.println(array[p].data+" Value Found");
                check=1;
                p=3;
                return true;
                
            }
            else if((int)d>(int)array[p].data)
            {
                if(array[p].right!=null)
                {
                    search(array[p].right,d);
                }
              }
            else if((int)d<(int)array[p].data)
            {
                if(array[p].left!=null)  
                {
                    search(array[p].left,d);
                }
                 }
        }
        return false;
    }
}
       
  