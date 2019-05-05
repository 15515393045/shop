package com.fh.api.jpa.brand.controller;


import com.fh.api.jpa.brand.biz.IBrandService;
import com.fh.api.jpa.brand.po.Brand;
import com.fh.api.jpa.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class BrandController {

    @Resource(name = "brandService")
    private IBrandService brandService;

    @GetMapping("brands")
    public ServerResponse findBrandList(){
        return brandService.findBrandList();
    }

    @PostMapping("brands")
    public ServerResponse addBrand(Brand brand){
        return brandService.addBrand(brand);
    }

    @DeleteMapping("brands/{id}")
    public ServerResponse deleteBrand(@PathVariable("id") Integer id){
        return brandService.deleteBrand(id);
    }

    @DeleteMapping("brands")
    public ServerResponse deleteBatch(String  ids){
        return brandService.deleteBatch(ids);
    }

    @GetMapping("brands/{id}")
    public ServerResponse toBrand(@PathVariable("id") Integer id){
        return brandService.toBrand(id);
    }

    @PutMapping("brands")
    public ServerResponse updateBrand(@RequestBody Brand brand){
        return brandService.updateBrand(brand);
    }


}
