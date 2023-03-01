package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.structure.Connection;
import telran.structure.ConnectionsPool;
import telran.structure.ConnectionsPoolImpl;

class ConnecionsPoolTest {
	
	ConnectionsPool connectionsPool;
	
	@BeforeEach
	void setUp() throws Exception {
		Connection connection1 = new Connection(1, "192.168.0.1", 1111);
		Connection connection2 = new Connection(2, "192.168.0.2", 1112);
		Connection connection3 = new Connection(3, "192.168.0.3", 1113);
		Connection connection4 = new Connection(4, "192.168.0.4", 1114);
		connectionsPool = new ConnectionsPoolImpl();
		connectionsPool.addConnection(connection1);
		connectionsPool.addConnection(connection2);
		connectionsPool.addConnection(connection3);
		connectionsPool.addConnection(connection4);
	}
		
	@Test
	void addConnectionTest() {
		Connection connection5 = new Connection(5, "192.168.0.5", 1115);
		connectionsPool.addConnection(connection5);
		assertNull(connectionsPool.getConnection(1));
		assertEquals("192.168.0.5",connectionsPool.getConnection(5).getIpAddress());
	}
	
	@Test
	void getConnectionTest() {
		assertNull(connectionsPool.getConnection(5));
		connectionsPool.getConnection(1);
		assertEquals("192.168.0.1",connectionsPool.getLastConnection().getIpAddress());
		}


}
