package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.AntzCloudDbmybatisApplication;
import com.andz.cloud.db.oracle.model.Product;
import com.andz.cloud.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AntzCloudDbmybatisApplication.class)
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper ;

    @Test
    public void addProductTest(){
        Product product = new Product();
       // product.setCreatetime(new Date());
        //product.setModifytime(new Date());
        product.setProductType(1004L);
        product.setRegion(101L);
        product.setProductNo(100006L);
        product.setProductName("葡萄");
        log.info("返回执行条数，{}",productMapper.addProduct(product) );
    }

    @Test
    public void batchAddProductTest(){
        List<Product> list = new ArrayList<>();
        for(int i = 0 ; i < 5 ;i++){
            Product product = new Product();
            //product.setCreatetime(new Date());
            //product.setModifytime(new Date());
            product.setProductType(1004L);
            product.setRegion(101L);
            product.setProductNo(100006L+i+1);
            product.setProductName("葡萄"+i);
            list.add(product) ;
        }
        log.info("返回批量执行条数，{}",productMapper.batchAddProduct(list));

    }

    @Test
    public void  selectProductByLikeTest(){
        String productName = "葡萄" ;
        int pageNum = 2;
        int pageSize =  1;
        PageHelper.startPage(pageNum,pageSize,true) ;
        List<Product> products = productMapper.selectProductByLike(productName);
        PageInfo<Product> pageInfo = new PageInfo(products) ;
        for(Product p : pageInfo.getList() ){
            log.info("根据产品名称模糊查询，{}",p.toString());

        }
    }


    @Test
    public  void selectProductByCreateTimeTest(){
        String creatTime = "2018-9-8 20:29:27";
        Date modifyTime = new Date() ;
        log.info("根据时间模糊查询，{}", productMapper.selectProductByTime(creatTime,modifyTime));
    }

    @Test
    public void selectProduclListsTest(){
        String productName = "葡萄" ;
        int pageNum = 2;
        int pageSize =  1;
        List<Product> products = productMapper.selectProduclLists(pageNum,pageSize,productName);
        for(Product p : products ){
            log.info("根据产品名称模糊查询，{}",p.toString());

        }
    }
    @Test
    public void addProductByProcedureTest(){
        String creatTime = "2018-9-8 20:29:27";
        Product product = new Product();
         product.setCreatetime(creatTime);
        product.setModifytime(new Date());
        product.setProductType(1004L);
        product.setRegion(101L);
        product.setProductNo(100014L);
        product.setProductName("葡萄11");

        Map<String,Object> map = new HashMap<>();
        map.put("productNo",100017L);
        map.put("productName","葡萄11");
        map.put("productType",1004L);
        map.put("region",101L);
        map.put("createtime",creatTime);
        map.put("modifytime",new Date());
        map.put("counts",0);
        productMapper.addProductByProcedure(map) ;
        log.info("返回执行条数，{}",map.get("counts") );
    }

    @Test
    public void getProductAndRegionTest(){
        long regionId = 103L ;
       log.info("返回产品地区信息,{}",productMapper.getProductAndRegion(regionId));
    }

}