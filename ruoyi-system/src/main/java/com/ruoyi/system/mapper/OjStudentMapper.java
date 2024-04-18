package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjStudent;

/**
 * 学生管理Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjStudentMapper extends BaseMapper<OjStudent> {
    /**
     * 查询学生管理
     *
     * @param studentId 学生管理主键
     * @return 学生管理
     */
    public OjStudent selectOjStudentByStudentId(Long studentId);

    /**
     * 查询学生管理列表
     *
     * @param ojStudent 学生管理
     * @return 学生管理集合
     */
    public List<OjStudent> selectOjStudentList(OjStudent ojStudent);

    /**
     * 新增学生管理
     *
     * @param ojStudent 学生管理
     * @return 结果
     */
    public int insertOjStudent(OjStudent ojStudent);

    /**
     * 修改学生管理
     *
     * @param ojStudent 学生管理
     * @return 结果
     */
    public int updateOjStudent(OjStudent ojStudent);

    /**
     * 删除学生管理
     *
     * @param studentId 学生管理主键
     * @return 结果
     */
    public int deleteOjStudentByStudentId(Long studentId);

    /**
     * 批量删除学生管理
     *
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjStudentByStudentIds(Long[] studentIds);
}
