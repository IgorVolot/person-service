package ait.cohort34.person.controller;

import ait.cohort34.person.dto.ChildDto;
import ait.cohort34.person.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class ChildController {
    final ChildService childService;

    @PostMapping
    public Boolean addChild(@RequestBody ChildDto childDto) {
        return childService.addChild(childDto);
    }

    @GetMapping("/children")
    public Iterable<ChildDto> findAllChildren() {
        return childService.findAllChildren();
    }
}
