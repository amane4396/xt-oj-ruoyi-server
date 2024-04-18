package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjCase;

/**
 * 题目样例Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjCaseMapper extends BaseMapper<OjCase> {
    /**
     * 查询题目样例
     *
     * @param caseId 题目样例主键
     * @return 题目样例
     */
    public OjCase selectOjCaseByCaseId(Long caseId);

    /**
     * 查询题目样例列表
     *
     * @param ojCase 题目样例
     * @return 题目样例集合
     */
    public List<OjCase> selectOjCaseList(OjCase ojCase);

    /**
     * 新增题目样例
     *
     * @param ojCase 题目样例
     * @return 结果
     */
    public int insertOjCase(OjCase ojCase);

    /**
     * 修改题目样例
     *
     * @param ojCase 题目样例
     * @return 结果
     */
    public int updateOjCase(OjCase ojCase);

    /**
     * 删除题目样例
     *
     * @param caseId 题目样例主键
     * @return 结果
     */
    public int deleteOjCaseByCaseId(Long caseId);

    /**
     * 批量删除题目样例
     *
     * @param caseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjCaseByCaseIds(Long[] caseIds);
}
