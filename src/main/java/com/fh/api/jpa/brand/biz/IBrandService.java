package com.fh.api.jpa.brand.biz;


import com.fh.api.jpa.brand.po.Brand;
import com.fh.api.jpa.common.ServerResponse;

public interface IBrandService {

    ServerResponse findBrandList();

    ServerResponse addBrand(Brand brand);

    ServerResponse deleteBrand(Integer id);

    ServerResponse toBrand(Integer id);

    ServerResponse updateBrand(Brand brand);

    ServerResponse deleteBatch(String ids);
}
