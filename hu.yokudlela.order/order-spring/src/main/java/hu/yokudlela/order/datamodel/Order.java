/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlela.order.datamodel;
import hu.yokudlela.table.datamodel.Reservation;

import java.util.List;
import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Order {
     private Item item;
     private String comment;
     private Reservation reservation;
     private List<ExtraItem> extras;
     private Status status;
     
     @Builder
     public Order(Item item, String comment, Reservation reservation, List<ExtraItem> extras, Status status) {
         this.item = item;
         this.comment = comment;
         this.reservation = reservation;
         this.extras = extras;
         this.status = status;
     }
}

enum Status {
    Noted,
    Cooking,
    Finished,
    Delivered,
    Canceled    
}
