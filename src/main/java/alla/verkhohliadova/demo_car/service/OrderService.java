package alla.verkhohliadova.demo_car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alla.verkhohliadova.demo_car.dto.request.OrderRequest;
import alla.verkhohliadova.demo_car.dto.request.ProductCountRequest;
import alla.verkhohliadova.demo_car.entity.Order;
import alla.verkhohliadova.demo_car.entity.ProductCount;
import alla.verkhohliadova.demo_car.repository.OrderRepository;
import alla.verkhohliadova.demo_car.repository.ProductCountRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private ProductCountRepository productCountRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public void create(OrderRequest request) {
        Order order = orderRequestToOrder(null, request);
        order = orderRepository.saveAndFlush(order);
        List<ProductCount> productCounts = orderRequestToProductCounts(request, order);
        productCountRepository.saveAll(productCounts);
    }

    private List<ProductCount> orderRequestToProductCounts(OrderRequest request, Order order) {
        return request.getProductCountRequests().stream().map(p -> productCountRequestToProductCount(p, order)).collect(Collectors.toList());
    }

    private ProductCount productCountRequestToProductCount(ProductCountRequest request, Order order) {
        return ProductCount.builder()
                .count(request.getCount())
                .product(productService.findOne(request.getProductId()))
                .order(order)
                .build();
    }

    private Order orderRequestToOrder(Order order, OrderRequest request) {
        if (order == null) {
            order = new Order();
            order.setDate(LocalDate.now());
            order.setTime(LocalTime.now());
            order.setFinished(false);
        }
        //other fields
        return order;
    }
}
