package com.fh.api.jpa.brand.biz;

import com.fh.api.jpa.brand.repository.IBrandRepository;
import com.fh.api.jpa.brand.po.Brand;
import com.fh.api.jpa.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("brandService")
//根据继承原则对写操作的异常进行回滚
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;

    @Override
    //根据就近原则在方法上配置只读事务。
    @Transactional(readOnly = true)
    public ServerResponse findBrandList() {
        return ServerResponse.success(brandRepository.findAll());
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        brandRepository.save(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        brandRepository.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse toBrand(Integer id) {
        Brand brand=brandRepository.findOne(id);
        return ServerResponse.success(brand);
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandRepository.updateBrand(brand);
        return ServerResponse.success();
    }

    public Integer conversion(String s) {
        return Integer.valueOf(s);
    }

    @Override
    public ServerResponse deleteBatch(String ids) {
        if(!ids.isEmpty()){
            List<Integer> collect = Arrays.stream(ids.split(",")).map(this::conversion).collect(Collectors.toList());
            brandRepository.deleteBatch(collect);
        }
        return ServerResponse.success();
    }
}
