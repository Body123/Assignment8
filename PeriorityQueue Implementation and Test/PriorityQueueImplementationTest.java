package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueImplementationTest {

	@Test
	void test() {
		PriorityQueueImplementation obj =new PriorityQueueImplementation();
		assertThrows(RuntimeException.class,() ->obj.insert(8, 0),"Worng Key");
		assertThrows(RuntimeException.class,() ->obj.insert(8, -1),"Worng Key");
		assertThrows(RuntimeException.class,() ->obj.removeMin(),"Empty PriorityQueue");
		assertThrows(RuntimeException.class,() ->obj.min(),"Empty PriorityQueue");
		assertTrue(obj.isEmpty());
		obj.insert(8, 6); //8
		obj.insert(12, 4);   	//12 8
		obj.insert(5, 1);	//5 12 8
		obj.insert(9, 1);  //5 9 12 8
		obj.insert(10, 6);	//5 9 12 8 10
		obj.insert(7, 5);   //5 9 12 7 8 10
		assertEquals(5,obj.min());
		assertEquals(6,obj.size());
		assertTrue(!obj.isEmpty());
		assertEquals(5,obj.removeMin());
		assertEquals(9,obj.removeMin());
		assertEquals(4,obj.size());
		assertEquals(12,obj.min());
		assertEquals(12,obj.removeMin());
		assertEquals(7,obj.removeMin());
		assertEquals(8,obj.removeMin());
		assertEquals(10,obj.removeMin());
		assertTrue(obj.isEmpty());
		
	}

}
