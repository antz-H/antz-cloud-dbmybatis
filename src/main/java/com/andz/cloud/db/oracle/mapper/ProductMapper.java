package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.db.oracle.model.Product;
import com.andz.cloud.db.oracle.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
public interface ProductMapper extends MyMapper<Product> {

    /**
     * 单条保存
     * @param product
     * @return
     */
    int addProduct(@Param("product") Product product);
    /**
     * 批量保存
     * @param lists
     * @return
     */
    int batchAddProduct(@Param("lists") List<Product> lists);
    /**
     * 根据条件准确查询
     * @param product
     * @return
     */
    List<Product> selectProductByCondition(@Param("product") Product product);

    /**
     *
     * @param productName
     * @return
     */
    List<Product> selectProductByLike(@Param("productName") String productName);

    /**
     * 根据字符串类型的createTime和Date类型的modifyTime查询时间操作
     * @param createTime
     * @return
     */
    List<Product> selectProductByTime(@Param("createTime") String createTime,@Param("modifyTime") Date modifyTime);

    /**
     * 分页查询所有产品信息
     * @return
     */
    List<Product> selectProduclLists(@Param("limit") int limit ,@Param("page") int page,@Param("productName") String productName);

    /**
     * 通过储存过程调用
     * @param product
     * @return
     */
    Integer addProductByProcedure( Map<String,Object> product);

    /**
     *
     * @param regionID
     * @return
     */
    List<Product> getProductAndRegion(@Param("regionID") Long regionID);
}