package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping()
    List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    Burger findById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping
    Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger update(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    List<Burger> findByPrice(@PathVariable Double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }


}
