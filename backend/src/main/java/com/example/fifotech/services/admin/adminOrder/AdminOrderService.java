package com.example.fifotech.services.admin.adminOrder;

import com.example.fifotech.dto.AnalyticsResponse;
import com.example.fifotech.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {

    List<OrderDto> getAllPlaceOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}
