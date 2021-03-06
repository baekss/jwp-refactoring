package kitchenpos.service.order;

import kitchenpos.domain.menu.Menu;
import kitchenpos.domain.order.OrderRepository;
import kitchenpos.domain.order.OrderStatus;
import kitchenpos.domain.order.Orders;
import kitchenpos.domain.table.OrderTable;
import kitchenpos.dto.order.OrderRequest;
import kitchenpos.dto.order.OrderResponse;
import kitchenpos.service.menu.MenuService;
import kitchenpos.service.table.TableService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final TableService tableService;
    private final MenuService menuService;

    public OrderService(final OrderRepository orderRepository, final TableService tableService, final MenuService menuService) {
        this.orderRepository = orderRepository;
        this.tableService = tableService;
        this.menuService = menuService;
    }

    public OrderResponse save(OrderRequest orderRequest) {
        List<Long> ids = orderRequest.getOrderIds();
        OrderTable orderTable = tableService.findOrderTable(orderRequest.getOrderTableId());
        Map<Long, Menu> menus = menuService.findMenus(ids);
        Orders order = new Orders(orderTable, OrderStatus.COOKING);
        orderRequest.putOrderMenu(order, menus);
        return OrderResponse.of(orderRepository.save(order));
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return OrderResponse.ofList(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public OrderResponse findOrder(Long id) {
        Orders order = orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return OrderResponse.of(order);
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrderByTable(OrderTable orderTable) {
        return orderRepository.findByOrderTable(orderTable);
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrderByTableIn(List<OrderTable> orderTables) {
        return orderRepository.findByOrderTableIn(orderTables);
    }

    public OrderResponse changeOrderStatus(Long orderId, OrderRequest orderRequest) {
        Orders order = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);
        order.changeOrderStatus(orderRequest.getOrderStatus());
        return OrderResponse.of(order);
    }
}
