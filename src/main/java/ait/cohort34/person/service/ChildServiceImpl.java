package ait.cohort34.person.service;

import ait.cohort34.person.dao.PersonRepository;
import ait.cohort34.person.dto.ChildDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildServiceImpl implements ChildService {
    final PersonRepository personRepository;
    final ModelMapper modelMapper;

    @Override
    public Boolean addChild(ChildDto childDto) {
        return null;
    }

    @Override
    public Iterable<ChildDto> findAllChildren() {
        return null;
    }
}
