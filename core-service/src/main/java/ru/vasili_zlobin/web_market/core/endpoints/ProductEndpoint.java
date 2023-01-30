package ru.vasili_zlobin.web_market.core.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.vasili_zlobin.web_market.core.model.Product;
import ru.vasili_zlobin.web_market.core.services.ProductService;
import ru.vasili_zlobin.web_market.ws.products.GetAllProductsRequest;
import ru.vasili_zlobin.web_market.ws.products.GetAllProductsResponse;

import java.math.BigDecimal;
import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://vasili_zlobin.ru/web_market/ws/products";
    private final ProductService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        List<Product> products = service.getProductsList();
        for (Product product : products) {
            ru.vasili_zlobin.web_market.ws.products.Product p = new ru.vasili_zlobin.web_market.ws.products.Product();
            p.setId(product.getId());
            p.setTitle(product.getTitle());
            p.setPrice(BigDecimal.valueOf(product.getPrice()));
            response.getProducts().add(p);
        }
        return response;
    }
}
