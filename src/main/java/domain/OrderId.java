package domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderId implements Serializable {

    Integer waiterID, tableID, menuID;
    LocalDateTime dateTime;

    public OrderId(Integer waiterID, Integer tableID, Integer menuID, LocalDateTime dateTime) {
        this.waiterID = waiterID;
        this.tableID = tableID;
        this.menuID = menuID;
        this.dateTime = dateTime;
    }

}

