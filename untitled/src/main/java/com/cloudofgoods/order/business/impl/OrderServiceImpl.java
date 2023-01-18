package com.cloudofgoods.order.business.impl;

import com.cloudofgoods.order.business.OrderService;
import com.cloudofgoods.order.dto.OrderDTO;
import com.cloudofgoods.order.dto.OrderDeliveryLocationsDTO;
import com.cloudofgoods.order.dto.OrderStatusHistoryDTO;
import com.cloudofgoods.order.dto.ReservationUnitDTO;
import com.cloudofgoods.order.entity.*;
import com.cloudofgoods.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        log.info ("LOG :: OrderServiceImpl saveOrder() ");
        try {
            Order order;
            order = saveOrderToDb (orderDTO);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    private Order saveOrderToDb(OrderDTO orderDTO) {
        Order order = new Order ();
        if (orderDTO.getId () != null) order.setId (orderDTO.getId ());
        order.setUserId (orderDTO.getUserId ());
        order.setShoppingCartId (orderDTO.getShoppingCartId ());
        order.setFullOrderAccepted (orderDTO.isFullOrderAccepted ());
        order.setOrderPlacedDate (orderDTO.getOrderPlacedDate ());
        order.setAutoCancelled (orderDTO.isAutoCancelled ());
        order.setTotalHours (orderDTO.getTotalHours ());
        order.setChargingStatus (orderDTO.getChargingStatus ());
        order.setTotalAmount (orderDTO.getTotalAmount ());
        order.setOtherFee (orderDTO.getOtherFee ());
        order.setOtherFeeMemo (orderDTO.getOtherFeeMemo ());
        order.setNextDayMorningPickupFee (orderDTO.getNextDayMorningPickupFee ());
        order.setDiscount (orderDTO.getDiscount ());
        order.setDeliveryTypeStatus (orderDTO.getDeliveryTypeStatus ());
        order.setPaymentType (orderDTO.getPaymentType ());
        order.setPaymentDate (orderDTO.getPaymentDate ());
        order.setCreatedAt (orderDTO.getCreatedAt ());
        order.setUpdatedAt (orderDTO.getUpdatedAt ());
        order.setRequestedVia (orderDTO.getRequestedVia ());
        order.setDriverNotes (orderDTO.getDriverNotes ());
        order.setSwapReason (orderDTO.getSwapReason ());

        if (orderDTO.getReservationUnitSetDTO () != null) {
            Set <ReservationUnitDTO> reservationUnitSetDTO = orderDTO.getReservationUnitSetDTO ();
            Set <ReservationUnit> itemCategoryList = new HashSet <> ();
            for (ReservationUnitDTO reservationUnitDTO : reservationUnitSetDTO) {
                ReservationUnit reservationUnit = reservationUnitSetDTOToEntity (reservationUnitDTO);
                itemCategoryList.add (reservationUnit);
            }
            order.setReservationUnitSet (itemCategoryList);
        }
        orderRepository.save (order);
        return order;
    }

    private ReservationUnit reservationUnitSetDTOToEntity(ReservationUnitDTO reservationUnitDTO) {

        ReservationUnit reservationUnit = new ReservationUnit ();
        if (reservationUnitDTO.getId () != null) reservationUnit.setId (reservationUnitDTO.getId ());
        reservationUnit.setUnitId (reservationUnitDTO.getUnitId ());
        reservationUnit.setDiscount (reservationUnitDTO.getDiscount ());
        reservationUnit.setShoppingCartActualCatalogItemClusterId (reservationUnitDTO.getShoppingCartActualCatalogItemClusterId ());
        reservationUnit.setShoppingCartStockId (reservationUnitDTO.getShoppingCartStockId ());
        reservationUnit.setOrderStatus (new OrderStatus (reservationUnitDTO.getOrderStatusId ()));
        reservationUnit.setDeliveryWindowId (reservationUnitDTO.getDeliveryWindowId ());
        reservationUnit.setDateFrom (reservationUnitDTO.getDateFrom ());
        reservationUnit.setDateTo (reservationUnitDTO.getDateTo ());
        reservationUnit.setPurchasedAt (reservationUnitDTO.getPurchasedAt ());
        reservationUnit.setQuantity (reservationUnitDTO.getQuantity ());
        reservationUnit.setTotalUnitAmount (reservationUnitDTO.getTotalUnitAmount ());
        reservationUnit.setRentPerDayFee (reservationUnitDTO.getRentPerDayFee ());
        reservationUnit.setDeliveryCharge (reservationUnitDTO.getDeliveryCharge ());
        reservationUnit.setPriceCache (reservationUnitDTO.getPriceCache ());
        reservationUnit.setInvoiceNumber (reservationUnitDTO.getInvoiceNumber ());
        reservationUnit.setDeliveryTime (reservationUnitDTO.getDeliveryTime ());
        reservationUnit.setPickupTime (reservationUnitDTO.getPickupTime ());
        reservationUnit.setSpecialInstructions (reservationUnitDTO.getSpecialInstructions ());
        reservationUnit.setAdminNotes (reservationUnitDTO.getAdminNotes ());
        reservationUnit.setDeliveryArea (new DeliveryArea (reservationUnitDTO.getDeliveryAreaId ()));
        Set <OrderStatusHistory> set = new HashSet <> ();
        for (OrderStatusHistoryDTO orderStatusHistoryDTO : reservationUnitDTO.getOrderStatusHistoriesDTO ()) {
            OrderStatusHistory orderStatusHistory = orderStatusHistory (orderStatusHistoryDTO, reservationUnit);
            set.add (orderStatusHistory);
        }
        Set <OrderStatusHistory> orderStatusHistories;
        orderStatusHistories = set;
        reservationUnit.setOrderStatusHistories (orderStatusHistories);
        reservationUnit.setCreatedAt (reservationUnitDTO.getCreatedAt ());
        reservationUnit.setUpdatedAt (reservationUnitDTO.getUpdatedAt ());
        reservationUnit.setOrderDeliveryLocations (createOrderDeliveryLocations (reservationUnitDTO.getOrderDeliveryLocationsDTO ()));
        return reservationUnit;
    }

    public OrderDeliveryLocations createOrderDeliveryLocations(OrderDeliveryLocationsDTO orderDeliveryLocationsDTO) {
        OrderDeliveryLocations orderDeliveryLocations = new OrderDeliveryLocations ();
        if (orderDeliveryLocationsDTO.getId () != null) orderDeliveryLocations.setId (orderDeliveryLocationsDTO.getId ());
        orderDeliveryLocations.setZipCode (orderDeliveryLocationsDTO.getZipCode ());
        orderDeliveryLocations.setContactNumber (orderDeliveryLocationsDTO.getContactNumber ());
        orderDeliveryLocations.setDeliveryAddress (orderDeliveryLocationsDTO.getDeliveryAddress ());
        orderDeliveryLocations.setDeliveryPlaceId (orderDeliveryLocationsDTO.getDeliveryPlaceId ());
        orderDeliveryLocations.setPickupPlaceId (orderDeliveryLocationsDTO.getPickupPlaceId ());
        orderDeliveryLocations.setIsAirportPickup (orderDeliveryLocationsDTO.getIsAirportPickup ());
        orderDeliveryLocations.setIsAirportDropOff (orderDeliveryLocationsDTO.getIsAirportDropOff ());
        orderDeliveryLocations.setDeliveryLocationType (orderDeliveryLocationsDTO.getDeliveryLocationType ());
        orderDeliveryLocations.setPickupLocationType (orderDeliveryLocationsDTO.getPickupLocationType ());
        orderDeliveryLocations.setBlacklistDropOffType (orderDeliveryLocationsDTO.getBlacklistDropOffType ());
        orderDeliveryLocations.setBlacklistPickupType (orderDeliveryLocationsDTO.getBlacklistPickupType ());
        orderDeliveryLocations.setCreatedAt (orderDeliveryLocationsDTO.getCreatedAt ());
        orderDeliveryLocations.setUpdatedAt (orderDeliveryLocationsDTO.getUpdatedAt ());
        return orderDeliveryLocations;
    }

    private OrderStatusHistory orderStatusHistory(OrderStatusHistoryDTO orderStatusHistoryDTO, ReservationUnit reservationUnit) {
        OrderStatusHistory orderStatusHistory = new OrderStatusHistory ();
        if (orderStatusHistoryDTO.getId () != null) orderStatusHistory.setId (orderStatusHistoryDTO.getId ());
        orderStatusHistory.setUserId (orderStatusHistoryDTO.getUserId ());
        orderStatusHistory.setReservationUnit (reservationUnit);
        orderStatusHistory.setOrderStatus (new OrderStatus (orderStatusHistoryDTO.getOrderStatus ()));
        orderStatusHistory.setOrderStatusFromId (new OrderStatus (orderStatusHistoryDTO.getOrderStatusFromId ()));
        orderStatusHistory.setOtherData (orderStatusHistoryDTO.getOtherData ());
        orderStatusHistory.setCreatedAt (orderStatusHistoryDTO.getCreatedAt ());
        orderStatusHistory.setUpdatedAt (orderStatusHistoryDTO.getUpdatedAt ());
        return orderStatusHistory;
    }
}
