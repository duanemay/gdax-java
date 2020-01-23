package com.coinbase.exchange.api.products;

import com.coinbase.exchange.api.BaseTest;
import com.coinbase.exchange.api.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by robevansuk on 08/02/2017.
 */
public class ProductsTest extends BaseTest {

    @Autowired
    ProductService productService;

    @Test
    public void canGetProducts() {
        Product[] products = productService.getProducts();
        assertThat(products.length >= 0).isTrue();
    }
}
