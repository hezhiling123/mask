package cn.hezhiling.mask.label.mapper;

import cn.hezhiling.mask.vo.label.LabelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelMapper {
    List<LabelVO> listAllMyLabel(@Param("ownerId")String ownerId);
}
