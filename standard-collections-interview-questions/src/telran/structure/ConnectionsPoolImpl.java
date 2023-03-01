package telran.structure;

import java.util.*;

public class ConnectionsPoolImpl implements ConnectionsPool {

LinkedHashSet <Connection> connectionsPool = new LinkedHashSet<Connection>();
HashMap<Integer, Connection> map = new HashMap<>();
static int size = 4;
	public ConnectionsPoolImpl (int size) {
		ConnectionsPoolImpl.size = size;
	}
	
	public ConnectionsPoolImpl () {
		this(size);
	}
	@Override
	public boolean addConnection(Connection connection) {
		connectionsPool.add(connection);
		map.put(connection.id, connection);
		if (connectionsPool.size() > size) {
			Iterator<Connection> it = connectionsPool.iterator();
			Connection tmp = it.next();
			connectionsPool.remove(tmp);
			map.remove(tmp.id, tmp);
		}
		
		return true;
	}

	@Override
	public Connection getConnection(int id) {
		Connection res = map.get(id);
		if (res != null) {
		map.remove(res.id);		
		connectionsPool.remove(res);
		addConnection(res);
		}
		return res;
	}
	
	@Override
	public Connection getLastConnection() {
		Iterator<Connection> it = connectionsPool.iterator();	
		Connection res = null;
		while (it.hasNext()) {
			res = it.next();
		}
		return res;
	}

}
