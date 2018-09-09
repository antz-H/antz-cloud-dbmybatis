package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.db.oracle.model.ProductRegion;
import com.andz.cloud.db.oracle.model.ProductRegionExample;
import com.andz.cloud.db.oracle.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductRegionMapper extends MyMapper<ProductRegion> {

    ProductRegion queryProductRegion(@Param("regionId") long regionId);

}