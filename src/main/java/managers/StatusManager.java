package managers;

import java.util.*;

public class StatusManager<E> {
    private Map<String, Queue> queueMap = new HashMap<>();

    public StatusManager(String[] status) {
        Arrays.stream(status).forEach(key -> queueMap.put(key, new LinkedList<E>()));
    }

    public boolean enqueue(String status, E e){
        return queueMap.get(status).add(e);
    }

    public E dequeue(String status){
        return (E) queueMap.get(status).poll();
    }
}
