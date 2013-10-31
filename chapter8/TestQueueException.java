//本例题完整了类的定义。为了抛出例外，对书中代码做了一点修改
public class TestQueueException
{
  public static void main(String args[])
  {
	Queue queue = new Queue();

	for(int i=1;i<8;i++)
	{
          queue.enqueue(i);
	  System.out.println(queue.visitAllNode());
	}
	System.out.println("\n");//加入两行回车
	try{
	  while(true)
	  {
	    System.out.print(queue.dequeue()+"出队；");
	    System.out.println("队列中还有："+queue.visitAllNode());
	  }
	}
	catch(EmptyQueueException e)
	{
	   System.out.println(e.toString());
	}
  }
}
//-----------------------------------------------------------------
class Queue extends LinkList		//定义队列类
{
	boolean isEmpty()			//判断队列是否为空
	{
		if(m_FirstNode==null)
			return true;
		else
			return false;
	}
	void enqueue(int newdata)	//加队操作，在队列尾部加入一个数据
	{
		Node next = m_FirstNode;
		if(next==null)
			m_FirstNode = new Node(newdata);
		else
		{
			while(next.getNext()!=null)
				next = next.getNext();
			next.setNext(new Node(newdata));
		}
	}
	int dequeue()	throws EmptyQueueException 
	{	//减队操作，若队列不空，则从队列头部取出一个数据	
		int data;
		if(isEmpty())
                    throw (new EmptyQueueException("队已空"));
                else
		{
			data = m_FirstNode.getData();
			m_FirstNode = m_FirstNode.getNext();
			return data;
		}
	}
}
//----------------------------------------------------------------
class EmptyQueueException extends Exception {  //定义异常类
     public EmptyQueueException(String msg){
         super(msg);
     }
}

//-----------------------------------------------------------------
 class LinkList				//定义链表类
{
	Node m_FirstNode;		//链表中的第一个节点
	LinkList()			//构造函数1：建立空链表
	{
		m_FirstNode = null;
	}
	LinkList(int data)		//构造函数2：建立只有一个节点的链表
	{
		m_FirstNode = new Node(data);
	}
	String visitAllNode()	//遍历链表每个节点，将所有数据串成一个字符串
	{
		Node next = m_FirstNode;	//从第一个节点开始
		String s = "";
		while(next!=null)			//直到最后一个节点
		{
			s = s + next.getData() + ";  ";
			next = next.getNext();	//next指向下一个节点
		}
		return s;
	}
	void insertAtBegin(int data)  //将数据data的节点插入在整个链表的前面
	{
		if(m_FirstNode == null) 	//对于空链表，直接插入
			m_FirstNode = new Node(data);
		else	//把新节点插在第一个节点前面，并指向原来的第一节点
			m_FirstNode = new Node(data,m_FirstNode);
	}

	void insertAfterId(int data,int id)
	{          //将数据data插在包含数据id的节点后面若链表中没有id,则插入在整个链表的最后
		Node next = m_FirstNode;
		if(next == null)	//对于空链表，直接插入
			m_FirstNode = new Node(data);
		else
		{
			while(next.getNext()!=null && next.getData()!=id)
				next = next.getNext();				//找到合适的插入位置
			next.setNext( new Node(data,next.m_Next) );
		}
	}
	boolean removeAtId(int id)		//删除链表中第一个数据为id的节点
	{
		Node ahead = m_FirstNode;	//前面的节点
		Node follow = ahead;		//指向ahead的节点

		if(ahead == null)		//链表为空，删除失败
			return false;
		else if(ahead.getData()==id)	//第一个节点就是欲删除节点
		{
			m_FirstNode = m_FirstNode.getNext();	//删除成功
			return true;
		}
		else
		{
			ahead = ahead.getNext();	//第二个节点
			if(ahead==null)	  //若只有一个节点且不是欲删除节点
				return false;		//删除失败
			else
			{
			  while(ahead!=null)
			  {
			    if(ahead.getData()==id)	//找到匹配的节点
			    {
				follow.setNext(ahead.getNext());
				return true;	//删除成功
			    }
	  		    follow = ahead;	//下移一步，检查下一个节点
			    ahead = ahead.getNext();//follow跟在ahead后面
			  }
			  return false;
			}
		}
	}
	void removeAll()		//删除所有的节点，令链表为空
	{
		m_FirstNode = null;
	}
}
//------------------------------------------------------
class Node                //定义节点类
{
 int m_Data;		//节点中保存的数据
 Node m_Next;	//节点中的指针属性，指向下一个Node对象的对象引用

 Node(int data)			//构造函数1
 {
	m_Data = data;
	m_Next = null;
 }
 Node(int data,Node next)	//构造函数2
 {
	m_Data = data;
	m_Next = next;
 }
 void setData(int data)	//修改节点中的数据
 {
	m_Data = data;
 }
 int getData()		//获得节点中的数据
 {
	return m_Data;
 }
 void setNext(Node next)//指定指针指向的Node对象引用
 {
	m_Next = next;
 }
 Node getNext()		//获得节点中的指针指向的对象引用
 {
	return m_Next;
 }
}