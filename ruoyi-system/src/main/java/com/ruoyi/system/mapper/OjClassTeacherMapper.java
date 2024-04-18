package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjClassTeacher;

/**
 * 班级教师关联Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjClassTeacherMapper extends BaseMapper<OjClassTeacher> {
    /**
     * 查询班级教师关联
     *
     * @param ojClassId 班级教师关联主键
     * @return 班级教师关联
     */
    public OjClassTeacher selectOjClassTeacherByOjClassId(Long ojClassId);

    /**
     * 查询班级教师关联列表
     *
     * @param ojClassTeacher 班级教师关联
     * @return 班级教师关联集合
     */
    public List<OjClassTeacher> selectOjClassTeacherList(OjClassTeacher ojClassTeacher);

    /**
     * 新增班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    public int insertOjClassTeacher(OjClassTeacher ojClassTeacher);

    /**
     * 修改班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    public int updateOjClassTeacher(OjClassTeacher ojClassTeacher);

    /**
     * 删除班级教师关联
     *
     * @param ojClassId 班级教师关联主键
     * @return 结果
     */
    public int deleteOjClassTeacherByOjClassId(Long ojClassId);

    /**
     * 批量删除班级教师关联
     *
     * @param ojClassIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjClassTeacherByOjClassIds(Long[] ojClassIds);
}
