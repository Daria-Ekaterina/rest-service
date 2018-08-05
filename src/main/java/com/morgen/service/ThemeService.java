package com.morgen.service;

import com.morgen.model.Theme;

import java.util.List;

public interface ThemeService {

    List<Theme> findAll();

    Theme addTheme(Theme theme);

}
