package com.ppoox.localfood.store.adapter.in.presentation;

import com.ppoox.localfood.store.application.port.in.presentation.ProductPresentationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductPresentationPort productPresentationPort;

}
