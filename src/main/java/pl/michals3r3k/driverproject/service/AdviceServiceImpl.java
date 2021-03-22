package pl.michals3r3k.driverproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.repository.AdviceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AdviceServiceImpl implements AdviceService {
    private final AdviceRepository adviceRepository;

    @Override
    public List<Advice> findAll() {
        return adviceRepository.findAll();
    }
}
