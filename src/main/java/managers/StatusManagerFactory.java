package managers;

import entities.Order;
import entities.OrderStatus;
import models.StatusOrder;
import utils.Utils;

public class StatusManagerFactory {

    public static StatusManager build(Class entity){

        if(entity.getName().equals(Order.class.getName())){
            return new StatusManager<StatusOrder>(Utils.getEnumNames(OrderStatus.class));
        }

        return null;
    }
}
