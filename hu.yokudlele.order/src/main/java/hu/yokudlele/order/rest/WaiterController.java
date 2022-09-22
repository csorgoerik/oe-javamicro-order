/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.yokudlele.order.rest;

import hu.yokudlele.order.datamodel.OrderItem;
import hu.yokudlele.order.datamodel.OrderItemsState;
import hu.yokudlele.order.datamodel.OrderStateEnum;
import hu.yokudlele.order.store.OrderItemStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */
@RestController()
@RequestMapping(path = "/Waiter")
public class WaiterController {
    
    @Autowired
    private OrderItemStore store;
    
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés", 
	    content = { @Content(mediaType = "application/json",  
	    array = @ArraySchema(schema = @Schema(implementation = OrderItemsState.class))) }),
    })
    @Operation(summary = "Rendelések állapotának lekérése")    
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)    
    public List<OrderItemsState> OrderStatuses(
                @Parameter(description = "asztal azonosító", required = true) @RequestParam(name = "id", required = true) String pTableid){
        return store.GetAll(pTableid);
    }
    
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Sikeres Rendelés"),
        @ApiResponse(responseCode = "500", description = "Sikertelen rendelés")
    })
    @Operation(summary = "Rendelés leadás")    
    @PostMapping(path = "/save")
    public void Order(
            @Parameter(description = "Rendelések", required = true) @RequestParam(name = "orders", required = true) OrderItem[] orders,
            @Parameter(description = "Asztal azonosító", required = true) @RequestParam(name = "tableid", required = true) String tableid) {
        
        
    }
    
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Sikeres fizetés"),
        @ApiResponse(responseCode = "500", description = "Sikertelen fizetés")
    })
    @Operation(summary = "Rendelés fizetés")    
    @PostMapping(path = "/pay")
    public void Payment(@Parameter(description = "Asztal azonosító", required = true) @RequestParam(name = "tableid", required = true) String tableid) {
        
        
    }
    
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Sikeres kiszolgálás"),
        @ApiResponse(responseCode = "500", description = "Sikertelen kiszolgálás")
    })
    @Operation(summary = "Rendelés kiszállítása")    
    @PostMapping(path = "/deliver")
    public void Deliver(@Parameter(description = "rendelés azonosítók", required = true) @RequestParam(name = "orderids", required = true) String[] orderIds) {
        
        store.ModifyState(orderIds, OrderStateEnum.Delivered);
    }
}
