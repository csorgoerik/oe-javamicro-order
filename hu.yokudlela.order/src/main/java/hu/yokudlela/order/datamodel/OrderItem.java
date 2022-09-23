
package hu.yokudlela.order.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class OrderItem {
    private String foodid;
    private String orderid;
    private int quantity;
    private String note;
    private boolean note4all;
    private String groupName;
    
    @Builder
    public OrderItem(String foodid, String orderid, int quantity, String note, boolean note4all, String groupName) {
        this.foodid = foodid;
        this.orderid = orderid;
        this.quantity = quantity;
        this.note = note;
        this.note4all = note4all;
        this.groupName = groupName;
    }
}
