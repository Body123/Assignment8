package eg.edu.alexu.csd.datastructure.queue;
public class PriorityQueueImplementation implements IPriorityQueue {
	private int size=0;
	private class Node {
		public Object value;
		public int key;
		public Node next=null;
		public Node(Object value,int key){
			this.value=value;
			this.key=key;
		}
	}
	Node head=null;
	Node tail=null;
	@Override
	public void insert(Object item, int key) {
		// TODO Auto-generated method stub
		Node newNode=new Node(item,key);
		if(key<1) throw new RuntimeException("Wrong key");
		if(size==0) {
			head=newNode;
			tail=newNode;
		}else {
			if(key<head.key) {
				newNode.next=head;
				head=newNode;
			}else if(key>=tail.key) {
				tail.next=newNode;
				tail=newNode;
			}else {
				Node temp;
				temp=head;
				while((temp.next.key)<=key) {
					temp=temp.next;
				}
				newNode.next=temp.next;
				temp.next=newNode;
				
			}
		}
		size++;
	}

	@Override
	public Object removeMin() {
		// TODO Auto-generated method stub
		Object temp;
		if(size==0)throw new RuntimeException("Empty PriorityQueue");
		if(size==1) {
			temp=head.value;
			head=tail=null;
		}else {
			temp=head.value;
			head=head.next;
		}
		size--;
		return temp;
	}

	@Override
	public Object min() {
		// TODO Auto-generated method stub
		Object temp;
		if(size==0)throw new RuntimeException("Empty ");
		else {
			temp=head.value;
		}
		
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size==0)return true;
		else
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	

}
