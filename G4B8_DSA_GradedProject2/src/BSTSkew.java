class Node
{
    int key;
    Node left, right;
    Node(int data)
    {
        key = data;
        left = right = null;
    }
}
class BSTSkew
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    static void convertskew(Node root, int order)
    {
        if(root == null)
        {
            return;
        }
        if(order > 0)
        {
            convertskew(root.right, order);
        }
        else
        {
            convertskew(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        if (order > 0)
        {
            convertskew(leftNode, order);
        }
        else
        {
            convertskew(rightNode, order);
        }
    }
    
    static void rightSkew(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.key + " ");
        rightSkew(root.right);       
    }
   
    public static void main (String[] args)
    {
        BSTSkew tree = new BSTSkew();
        tree.node = new Node(5);
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);

        int order = 0;
        convertskew(node, order);
        rightSkew(headNode);
    }
}