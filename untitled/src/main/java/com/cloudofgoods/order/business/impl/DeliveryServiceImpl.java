package com.cloudofgoods.order.business.impl;

import com.cloudofgoods.order.business.DeliveryService;
import com.cloudofgoods.order.dto.DeliveryAreaDTO;
import com.cloudofgoods.order.dto.DeliveryChargesDTO;
import com.cloudofgoods.order.entity.DeliveryArea;
import com.cloudofgoods.order.entity.DeliveryCharges;
import com.cloudofgoods.order.repository.DeliveryAreaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryAreaRepository deliveryAreaRepository;

    @Override
    public Mono <DeliveryAreaDTO> saveDelivery(DeliveryAreaDTO deliveryAreaDTO) {
        DeliveryArea deliveryArea = new DeliveryArea ();
        if (deliveryAreaDTO.getId () != null) deliveryArea.setId (deliveryAreaDTO.getId ());
        deliveryArea.setCityId (deliveryAreaDTO.getCityId ());
        deliveryArea.setLocationName (deliveryAreaDTO.getLocationName ());
        deliveryArea.setDescription (deliveryAreaDTO.getDescription ());
        deliveryArea.setAirport (deliveryAreaDTO.isAirport ());
        deliveryArea.setActive (deliveryAreaDTO.isActive ());
        deliveryArea.setDistance (deliveryAreaDTO.getDistance ());
        deliveryArea.setCreatedAt (deliveryAreaDTO.getCreatedAt ());
        deliveryArea.setUpdatedAt (deliveryAreaDTO.getUpdatedAt ());
        deliveryArea.setCurrentTrackType (deliveryAreaDTO.getCurrentTrackType ());
        deliveryArea.setCurrentDeliveryFee (deliveryAreaDTO.getCurrentDeliveryFee ());

        Set <DeliveryCharges> deliveryCharges = deliveryAreaDTO.getDeliveryCharges ().stream ()
                .map (deliveryChargesDTO -> {
                    DeliveryCharges deliveryCharge = new DeliveryCharges ();
                    if (deliveryChargesDTO.getId () != null) deliveryCharge.setId (deliveryChargesDTO.getId ());
                    deliveryCharge.setSameDay (deliveryChargesDTO.isSameDay ());
                    deliveryCharge.setStandardTime (deliveryChargesDTO.isStandardTime ());
                    deliveryCharge.setTrackType (deliveryChargesDTO.getTrackType ());
                    deliveryCharge.setDeliveryFee (deliveryChargesDTO.getDeliveryFee ());
                    deliveryCharge.setCreatedAt (deliveryChargesDTO.getCreatedAt ());
                    deliveryCharge.setUpdatedAt (deliveryChargesDTO.getUpdatedAt ());
                    return deliveryCharge;
                }).collect (Collectors.toSet ());
        deliveryArea.setDeliveryCharges (deliveryCharges);
        return deliveryAreaRepository.save (deliveryArea).flatMap (this::covertUserDAOToBUserBO);
    }

    private Mono <DeliveryAreaDTO> covertUserDAOToBUserBO(DeliveryArea save) {
        return Mono.justOrEmpty (save)
                .map (dao -> {
                    DeliveryAreaDTO deliveryAreaDTO = new DeliveryAreaDTO ();
                    deliveryAreaDTO.setId (save.getId ());
                    deliveryAreaDTO.setCityId (save.getCityId ());
                    deliveryAreaDTO.setLocationName (save.getLocationName ());
                    deliveryAreaDTO.setDescription (save.getDescription ());
                    deliveryAreaDTO.setAirport (save.isAirport ());
                    deliveryAreaDTO.setActive (save.isActive ());
                    deliveryAreaDTO.setDistance (save.getDistance ());
                    deliveryAreaDTO.setCreatedAt (save.getCreatedAt ());
                    deliveryAreaDTO.setUpdatedAt (save.getUpdatedAt ());
                    deliveryAreaDTO.setCurrentTrackType (save.getCurrentTrackType ());
                    deliveryAreaDTO.setCurrentDeliveryFee (save.getCurrentDeliveryFee ());
                    Set <DeliveryChargesDTO> deliveryChargesDTO = save.getDeliveryCharges ().stream ()
                            .map (deliveryCharge -> {
                                DeliveryChargesDTO deliveryChargeDTO = new DeliveryChargesDTO ();
                                deliveryChargeDTO.setId (deliveryCharge.getId ());
                                deliveryChargeDTO.setSameDay (deliveryCharge.isSameDay ());
                                deliveryChargeDTO.setStandardTime (deliveryCharge.isStandardTime ());
                                deliveryChargeDTO.setTrackType (deliveryCharge.getTrackType ());
                                deliveryChargeDTO.setDeliveryFee (deliveryCharge.getDeliveryFee ());
                                deliveryChargeDTO.setCreatedAt (deliveryCharge.getCreatedAt ());
                                deliveryChargeDTO.setUpdatedAt (deliveryCharge.getUpdatedAt ());
                                return deliveryChargeDTO;
                            }).collect (Collectors.toSet ());
                    deliveryAreaDTO.setDeliveryCharges (deliveryChargesDTO);
                    return deliveryAreaDTO;
                });
    }
}
