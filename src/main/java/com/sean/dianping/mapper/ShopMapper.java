package com.sean.dianping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sean.dianping.bean.ShopModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
public interface ShopMapper extends BaseMapper<ShopModel> {

    List<ShopModel> recommend(@Param("longitude") BigDecimal longitude, @Param("latitude") BigDecimal latitude);


//    @Select("<script>select tags,count(1) as num from shop where name like CONCAT('%',#{keyword},'%')\n" +
//            "    <if test=\"categoryId != null\">\n" +
//            "      and category_id = #{categoryId}\n" +
//            "    </if>\n" +
//            "    <if test=\"tags != null\">\n" +
//            "      and tags = #{tags}\n" +
//            "    </if>\n" +
//            "    group by tags</script>")
    List<Map<String, Object>> searchGroupByTags(@Param("keyword") String keyword,
                                                @Param("categoryId") Integer categoryId,
                                                @Param("tags") String tags);
//
//    @Select("<script>select\n" +
//            "    * ,ceil(1 + 1000*(2 * 6378.137* ASIN(SQRT(POW(SIN(PI() * (#{latitude} - latitude) / 360), 2) + COS(PI() * #{latitude} / 180)\n" +
//            "    * COS(latitude* PI() / 180) * POW(SIN(PI() * (#{longitude} - longitude) / 360), 2))))) AS distance\n" +
//            "    from shop where name like CONCAT('%',#{keyword},'%')\n" +
//            "     <if test=\"categoryId != null\">\n" +
//            "      and category_id = #{categoryId}\n" +
//            "    </if>\n" +
//            "    <if test=\"tags != null\">\n" +
//            "      and tags = #{tags}\n" +
//            "    </if>\n" +
//            "    <if test=\"orderby == null\">\n" +
//            "      order by (0.95*1/log10(distance)+ 0.05*remark_score/5)  DESC\n" +
//            "    </if>\n" +
//            "    <if test=\"orderby == 1\">\n" +
//            "      order by price_per_man ASC,id ASC\n" +
//            "    </if></script>")
    List<ShopModel> search(@Param("longitude") BigDecimal longitude,
                           @Param("latitude") BigDecimal latitude,
                           @Param("keyword") String keyword,
                           @Param("orderby") Integer orderby,
                           @Param("categoryId") Integer categoryId,
                           @Param("tags") String tags);
}
