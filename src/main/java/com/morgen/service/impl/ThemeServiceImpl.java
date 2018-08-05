package com.morgen.service.impl;

import com.morgen.model.Question;
import com.morgen.model.Theme;
import com.morgen.repository.ThemeRepository;
import com.morgen.service.ThemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service("themeService")
public class ThemeServiceImpl implements ThemeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeServiceImpl.class);

    private final ThemeRepository repository;

    @Inject
    public ThemeServiceImpl(ThemeRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Theme> findAll() {
        LOGGER.info("START repo findall");
        List<Theme> theme = (List<Theme>) repository.findAll();
        LOGGER.info("END repo");
        return theme;
    }

    @Override
    public Theme addTheme(Theme theme) {
        LOGGER.info("Question name from ServiceImpl= {}",theme.getName());
        repository.save(theme);
        return theme;
    }
}
