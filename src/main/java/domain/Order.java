package domain;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@IdClass(OrderId.class)
@Table(name = "ORDER")
public class Order implements Serializable {

    @Id
    @Column(name = "WAITER_ID")
    private Integer waiterId;

    @Id
    @Column(name = "TABLE_ID")
    private Integer tableID;

    @Id
    @Column(name = "MENU_ID")
    private Integer menuID;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Id
    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "COOK_ID")
    private Integer cookId;

    public Integer getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public Integer getTableID() {
        return tableID;
    }

    public void setTableID(Integer tableID) {
        this.tableID = tableID;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }

    private enum Status {ACCEPTED, IS_COOKING, COOCKED, ISSUED, PAID}
}
