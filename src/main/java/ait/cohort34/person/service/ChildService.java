package ait.cohort34.person.service;

import ait.cohort34.person.dto.ChildDto;

public interface ChildService {
    Boolean addChild(ChildDto childDto);

    Iterable<ChildDto> findAllChildren();
}
