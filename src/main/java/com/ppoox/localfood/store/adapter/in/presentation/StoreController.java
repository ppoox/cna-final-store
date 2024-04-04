package com.ppoox.localfood.store.adapter.in.presentation;

import com.ppoox.localfood.store.application.port.in.presentation.StorePresentationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {

    private final StorePresentationPort storePresentationPort;

}
