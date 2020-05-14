package com.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;
    Logger logger = Logger.getLogger(MenuDao.class.getName());
    public void setMenuDAO(MenuDao menuDao) {
        this.menuDao = menuDao;
    }


}
