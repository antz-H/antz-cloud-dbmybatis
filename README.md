### Mybatis-Generator使用

其中GeneratoConfigure.xml配置可参考[Mybatis3](http://www.mybatis.org/generator/)

#### Mybatis结合tk-Mapper使用

1. 修改数据库的指定配置

   ![1536382333310](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536382333310.png)

2. 指定dao工程的pom文件

   ![1536816514562](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536816514562.png)

   ```java
   <dependency>
   	<groupId>tk.mybatis</groupId>
   	<artifactId>mapper</artifactId>
   	<version>3.5.3</version>
   </dependency>
   <dependency>
   	<groupId>com.oracle</groupId>
   	<artifactId>ojdbc6</artifactId>
   	<version>11.2.0.3.0</version>
   </dependency>
   ```

3. 指定myMapper文件，这里作用是为了用于后面的扩展

   ![1536383227066](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536383227066.png)

4. 指定model、mapper等路径

   ![1536382953771](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536382953771.png)

5. 指定生成的mapper内容（这5点可根据需求自行配置是否生成）

   ![1536382679978](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536382679978.png)

6. 以上全部配置完成后，运行maven插件

   ![1536383001705](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1536383001705.png)

   或者

   > mvn  mybatis-generator:generate 

7. 找到Mapper接口文件，全部删除里面的默认生成的接口，以及对应的Mapper.xml中的方法

   ==原因：因为我们在这里使用了tk-Mapper，其实tkmapper已经为我们做了很多工作，它默认的所有方法已经涵盖了通过mybatis generator生成的方法；如果不删除那么在项目启动时会兼容到有重复的mybatis方法id。==

   ==那么为什么我们要生成了又要删除里面的方法呢？

   是因为在使用tkMapper时，它的上层接口已经封装了默认的Example类，我们在写对单表复杂操作时可能需要自己实现不同的example类，就会比较麻烦，所以我们通过mybatis generator生成会比较方便（这种方式在单表情况下是不用写任何sql的），如果你是采用写sql方式，可以忽略创建Example类，但是前面说的接口还是需要删除的；==

#### Mybatis单独使用

依然按照第一种方式步骤，但要删除第`2`步和第`6`步，即可。

该方式属于传统使用方式，对于代码冗余还是比较大的，对于代码维护不方便。

### Mybatis常见写法

#### 单表操作采用tkMapper动态sql

- 不带条件的CRUD

  ```java
  #常用的示例
  productMapper.select(T var)
  productMapper.selectAll()
  productMapper.delete(T var)
  productMapper.updateByPrimaryKey(T var)
  productMapper.insert(T var)
  ...
  ```

- 带条件的CRUD

  ```java
   #select
   #定义一个example
   ProductExample productExample = new ProductExample();
   #创建对应的Criteria(标准)，我们可以理解为查询条件
    productExample.createCriteria()
   .andProductNameEqualTo(productName);
   int num = productMapper.selectCountByExample(productExample);
  
  #delete
  ProductExample productExample = new ProductExample();
  productExample.createCriteria()
    .andProductNameEqualTo(productName);
  int num = productMapper.selectCountByExample(productExample);
  
  #udpate
  同理
  #insert
  同理
  
  ```

#### 单表操作采用手写SQL

- 增加 C

  ```java
  1、单条插入成功，结果返回执行条数
  
  package com.andz.cloud.db.oracle.mapper;
  
  import com.andz.cloud.db.oracle.model.Product;
  import com.andz.cloud.db.oracle.utils.MyMapper;
  import org.apache.ibatis.annotations.Param;
  
  public interface ProductMapper extends MyMapper<Product> {
  
      int addProduct(@Param("product") Product product);
  
  }
  
  mapper.xml 中配置
  
    <sql id="Base_Column_Product">
      PRODUCT_NO, PRODUCT_NAME, PRODUCT_TYPE, REGION,CREATETIME, MODIFYTIME
    </sql>
  
    <insert id="addProduct" parameterType="com.andz.cloud.db.oracle.model.Product">
  
      INSERT INTO T_PRODUCT  (
        <include refid="Base_Column_Product" />
      ) VALUES(
        #{product.productNo,jdbcType=DECIMAL},
        #{product.productName,jdbcType=VARCHAR},
        #{product.productType,jdbcType=DECIMAL},
        #{product.region,jdbcType=DECIMAL},
        #{product.createtime,jdbcType=TIMESTAMP} ,
        #{product.modifytime,jdbcType=TIMESTAMP}
      )
    </insert>
  
  
  2、批量插入成功，
  package com.andz.cloud.db.oracle.mapper;
  import com.andz.cloud.db.oracle.model.Product;
  import com.andz.cloud.db.oracle.utils.MyMapper;
  import org.apache.ibatis.annotations.Param;
  import org.springframework.transaction.annotation.Transactional;
  
  import java.util.List;
  @Transactional
  public interface ProductMapper extends MyMapper<Product> {
  		/**
  		*
  		*批量
  		**/
      int batchAddProduct(@Param("lists") List<Product> lists);
  }
  
  mapper.xml配置，这里禁止一条条insert
   <insert id="batchAddProduct" 		parameterType="com.andz.cloud.db.oracle.model.Product">
      INSERT INTO T_PRODUCT  (
      <include refid="Base_Column_Product" />
      )
      <foreach collection="lists" index="index" item="product" open="(" close=")" 			separator="union all">
        SELECT
        #{product.productNo,jdbcType=DECIMAL},
        #{product.productName,jdbcType=VARCHAR},
        #{product.productType,jdbcType=DECIMAL},
        #{product.region,jdbcType=DECIMAL},
        #{product.createtime,jdbcType=TIMESTAMP} ,
        #{product.modifytime,jdbcType=TIMESTAMP}
        FROM DUAL
      </foreach>
    </insert>
  
  ```

- 查询 R

  - 模糊查询

    ```
    package com.andz.cloud.db.oracle.mapper;
    
    import com.andz.cloud.db.oracle.model.Product;
    import com.andz.cloud.db.oracle.utils.MyMapper;
    import org.apache.ibatis.annotations.Param;
    import org.springframework.transaction.annotation.Transactional;
    
    import java.util.List;
    @Transactional
    public interface ProductMapper extends MyMapper<Product> {
        /**
         *
         * @param productName
         * @return
         */
        List<Product> selectProductByLike(@Param("productName") String productName);
    }
     #方式一 推荐方式
     <select id="selectProductByLike" resultMap="BaseResultMap">
        SELECT   <include refid="Base_Column_Product" />
        FROM T_PRODUCT T
        WHERE
        T.PRODUCT_NAME LIKE '%'|| #{productName} ||'%'
      </select>
      
      #方式二   
      <select id="selectProductByLike" resultMap="BaseResultMap">
        SELECT   <include refid="Base_Column_Product" />
        FROM T_PRODUCT T
        WHERE
        T.PRODUCT_NAME LIKE '%${productName}%'
      </select>
      ps : ${}可以接收简单类型值或pojo属性值，如果parameterType传输单个简单类型值，${}括号中只能是value，使用${}不能防止sql注入，但是有时用${}会非常方便
      
      #方式三 字符串拼接方式
      <select id="selectProductByLike" resultMap="BaseResultMap">
        SELECT   <include refid="Base_Column_Product" />
        FROM T_PRODUCT T
        WHERE
        <![CDATA[ T.PRODUCT_NAME like concat(concat('%',#{productName}),'%')]]>
      </select>
      ps: <![CDATA[]]标识 xml会自动不解析内部的内容,一般用来处理“>”、“<”、“&”等特殊字符
    ```

  - 时间查询

    ```
    package com.andz.cloud.db.oracle.mapper;
    
    import com.andz.cloud.db.oracle.model.Product;
    import com.andz.cloud.db.oracle.utils.MyMapper;
    import org.apache.ibatis.annotations.Param;
    import org.springframework.transaction.annotation.Transactional;
    
    import java.util.Date;
    import java.util.List;
    @Transactional
    public interface ProductMapper extends MyMapper<Product> {
       /**
         * 根据字符串类型的createTime和Date类型的modifyTime查询时间操作
         * @param createTime
         * @return
         */
        List<Product> selectProductByTime(@Param("createTime") String createTime,@Param("modifyTime") Date modifyTime);
    }
    
     <select id="selectProductByTime" resultMap="BaseResultMap">
        SELECT   <include refid="Base_Column_Product" />
        FROM T_PRODUCT T
        WHERE
        <![CDATA[
        T.CREATETIME > TO_DATE(#{createTime},'YYYY-MM-dd HH24:mi:ss')
        AND
        T.MODIFYTIME <  #{modifyTime}
        ]]>
      </select>
    ```

  - 分页查询

    ```java
    #使用mybatis分页插件   推荐
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
    
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    
    @Slf4j
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(classes = AntzCloudDbmybatisApplication.class)
    public class ProductMapperTest {
    
     @Test
        public void  selectProductByLikeTest(){
            String productName = "葡萄" ;
            int pageNum = 2;
            int pageSize =  1;
            PageHelper.startPage(pageNum,pageSize,true) ;
            List<Product> products = 		productMapper.selectProductByLike(productName);
            PageInfo<Product> pageInfo = new PageInfo(products) ;
            for(Product p : pageInfo.getList() ){
                log.info("根据产品名称模糊查询，{}",p.toString());
    
            }
        }
    }
    
    #自行定义sql 不推荐
    
    package com.andz.cloud.db.oracle.mapper;
    
    import com.andz.cloud.db.oracle.model.Product;
    import com.andz.cloud.db.oracle.utils.MyMapper;
    import org.apache.ibatis.annotations.Param;
    import org.springframework.transaction.annotation.Transactional;
    
    import java.util.Date;
    import java.util.List;
    @Transactional
    public interface ProductMapper extends MyMapper<Product> {
         /**
         * 分页查询所有产品信息
         * @return
         */
        List<Product> selectProduclLists(@Param("limit") int limit ,@Param("page") int page,@Param("productName") String productName);
    }
    
    <select id="selectProduclLists"  resultMap="BaseResultMap">
        SELECT *
        FROM
        (
          SELECT  A.* ,ROWNUM RN
          FROM(
            SELECT   <include refid="Base_Column_Product" />  FROM T_PRODUCT T
            WHERE
            <![CDATA[ T.PRODUCT_NAME like concat(concat('%',#{productName}),'%')]]>
          ) A
          WHERE ROWNUM
          <![CDATA[ <= #{limit} ]]>
        )
        WHERE RN > #{page}
      </select>
      ps ： 分页还有一种between and 的方式，该方式效率非常低，不推荐使用 
    
    ```

- 修改 U

- 删除 D

- 存储过程

  ```
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
       * 通过储存过程调用
       * @param product
       * @return
       */
      Object addProductByProcedure( Map<String,Object> product);
  }
  
    <select id="addProductByProcedure" parameterType="map" statementType="CALLABLE" resultType="Object">
      call saveproduct(
      #{productNo,jdbcType=DECIMAL,mode=IN},
      #{productName,jdbcType=VARCHAR,mode=IN},
      #{productType,jdbcType=DECIMAL,mode=IN},
      #{region,jdbcType=DECIMAL,mode=IN},
      #{createtime,jdbcType=VARCHAR,mode=IN} ,
      #{modifytime,jdbcType=TIMESTAMP,mode=IN},
      #{counts ,jdbcType=DECIMAL,mode=OUT}
      )
    </select>
    ps: counts是定义过的out参数
    
    调用方法
     @Test
     public void addProductByProcedureTest(){
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
    
  
  ```

  注意的事项：

  > 1、  存储过程的参数和名称无关，只和顺序有关系
  >
  > 2、  存储过程的output参数，只能通过传入的map获取
  >
  > 3、  存储过程返回的结果集可直接用返回的map接收
  >
  > 4、  存储过程对应的数据类型为枚举类型，需要使用大写，如*VARCHAR*
  >
  > 参考：https://www.cnblogs.com/wuxiang/p/5144940.html

#### 多表才做采用手写SQL

- 一对一

  ```java
  方式一：采用关联查询
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
       *
       * @param regionID
       * @return
       */
      List<Product> getProductAndRegion(@Param("regionID") Long regionID);
  }
  <resultMap id="BaseResultMap" type="com.andz.cloud.db.oracle.model.Product" >
      <!--
        WARNING - @mbg.generated
      -->
        <id column="PRODUCT_NO" jdbcType="DECIMAL" property="productNo" />
        <result column="PRODUCT_NAME" jdbcType="VARCHAR" property="productName" />
        <result column="PRODUCT_TYPE" jdbcType="DECIMAL" property="productType" />
        <result column="CREATETIME" jdbcType="TIMESTAMP" property="createtime" />
        <result column="MODIFYTIME" jdbcType="TIMESTAMP" property="modifytime" />
        <result column="REGION" jdbcType="DECIMAL" property="region" />
        <association property="productRegion"  column="REGION" javaType="com.andz.cloud.db.oracle.model.ProductRegion">
          <result column="REGION_ID" property="regionId" jdbcType="DECIMAL" />
          <result column="REGION_NAME" property="regionName" jdbcType="VARCHAR" />
          <result column="CREATETIME" property="createtime" jdbcType="TIMESTAMP" />
          <result column="MODIFYTIME" property="modifytime" jdbcType="TIMESTAMP" />
        </association>
    </resultMap>
    
   <select id="getProductAndRegion" resultMap="BaseResultMap"  parameterType="long">
      SELECT  T.PRODUCT_NO, T.PRODUCT_NAME, T.PRODUCT_TYPE, T.REGION,T.CREATETIME, T.MODIFYTIME,
      P.REGION_ID, P.REGION_NAME, P.CREATETIME, P.MODIFYTIME
      FROM  T_PRODUCT T LEFT JOIN T_PRODUCT_REGION P ON T.REGION = P.REGION_ID
      WHERE
       T.REGION = #{regionID}
    </select>
  
  ```

  > 请定义好一对一的关系

- 一对多

  ```java
  方式一：采用关联查询
  package com.andz.cloud.db.oracle.mapper;
  
  import com.andz.cloud.db.oracle.model.ProductRegion;
  import com.andz.cloud.db.oracle.model.ProductRegionExample;
  import com.andz.cloud.db.oracle.utils.MyMapper;
  import java.util.List;
  import org.apache.ibatis.annotations.Param;
  
  public interface ProductRegionMapper extends MyMapper<ProductRegion> {
  
      ProductRegion queryProductRegion(@Param("regionId") long regionId);
  
  }
   <resultMap id="BaseResultMap" type="com.andz.cloud.db.oracle.model.ProductRegion" >
      <!--
        WARNING - @mbg.generated
      -->
      <result column="REGION_ID" property="regionId" jdbcType="DECIMAL" />
      <result column="REGION_NAME" property="regionName" jdbcType="VARCHAR" />
      <result column="CREATETIME" property="createtime" jdbcType="TIMESTAMP" />
      <result column="MODIFYTIME" property="modifytime" jdbcType="TIMESTAMP" />
      <collection property="products" ofType="com.andz.cloud.db.oracle.model.Product" column="REGION_ID">
        <id column="PRODUCT_NO" jdbcType="DECIMAL" property="productNo" />
        <result column="PRODUCT_NAME" jdbcType="VARCHAR" property="productName" />
        <result column="PRODUCT_TYPE" jdbcType="DECIMAL" property="productType" />
        <result column="CREATETIME" jdbcType="TIMESTAMP" property="createtime" />
        <result column="MODIFYTIME" jdbcType="TIMESTAMP" property="modifytime" />
        <result column="REGION" jdbcType="DECIMAL" property="region" />
      </collection>
  
    </resultMap>
  <select id="queryProductRegion" parameterType="long" resultMap="BaseResultMap">
          SELECT  T.PRODUCT_NO, T.PRODUCT_NAME, T.PRODUCT_TYPE, T.REGION,T.CREATETIME, T.MODIFYTIME,
      P.REGION_ID, P.REGION_NAME, P.CREATETIME, P.MODIFYTIME
      FROM  T_PRODUCT T  JOIN T_PRODUCT_REGION P ON T.REGION = P.REGION_ID
      WHERE
       P.REGION_ID = #{regionId}
    </select>
  
  
  ```

  > 请自行定义好实体类中的多对一的关系

- 多对多

### Mybatis细节

1. 安全使用

   - \#{token}   会被预编译，能防止SQL注入
   - ${token}    动态执行，不能防止SQL注入

2. 自动生成的model，其中它的数字类型的属性，建议直接设为long类型，因为它很多默认是short类型，那么可能会出现`数字溢出问题`

3. 所有服务时间均为数据库时间

4. 针对于时间类型的字段，当数据类型是date时，我们创建的实体类的时间类型可以为String类型

   - 小测试

     ```
     测试一：数据库为date,实体类时间为String ，则查询输出的格式：  createtime=2018-09-08 20:31:26
     测试二：数据库为date，实体类时间date，则查询输出的格式：		createtime=Sat Sep 08 20:31:26 CST 2018
     结论：请结合情况而定，选择时间字段的类型
     ```

   - 到底是使用java.sql.Date ， 还是使用java.util.Date ,有什么区别

     ```
     测试一：实体类中时间为java.sql.Date，则查询输出结果 modifytime=2018-09-08
     测试二：实体类中时间为java.util.Date，则查询输出结果 modifytime=Sat Sep 08 20:31:26 CST 2018
     结论，若时间字段为date,则使用java.util.Date;
     java.sql包下的 Date只处理年月日；Time只处理时分秒；Timestamp处理年月日时分秒
     ```

5. Mapper接口返回值，建议要设为值对象，比如不能是int，应该为Integer

6. 使用存储过程可以参考这个[网站](https://www.cnblogs.com/wuxiang/p/5144940.html)

7. 在创建实体类的时候，最好默认创建一个无参数的构造器，因为mybatis默认会扫描无参数的构造器

### 常见问题

#### 对象保存某些字段为null问题解决

报错如下

![1537593381950](https://github.com/antz-H/doc/blob/master/antz-cloud-dbmybatis/1537593381950.png)

解决方案

> 主要原因是tkmapper通过直接保存对象的方式（非SQL方式）时，字段未设置对应的jdbcType，所以默认的就是`JdbcType OTHER`，之后默认会自动生成一个默认的数据类型1111，所以报错；所以说理论上讲如果在保存对象的时候正确地设置了字段对应的JdbcType类型，那么应该不会有问题

```java
增加如下配置
package com.andz.cloud.db.oracle.configuration;

import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

/**
 * @program: antz-cloud-dbmybatis
 * @description: 为了解决tkMapper的保存实体类的字段为null的问题
 * @author: antz
 **/
@Configuration
public class MybatiAutoConfiguration {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new MybatisPlusCustomizers();
    }

    class MybatisPlusCustomizers implements ConfigurationCustomizer {

        @Override
        public void customize(org.apache.ibatis.session.Configuration configuration) 				{
            configuration.setJdbcTypeForNull(JdbcType.NULL);
        }
    }
}

```



### 关文档

https://gitee.com/zenith/mybatis-generator-plugin



https://www.cnblogs.com/wuxiang/p/5144940.html



