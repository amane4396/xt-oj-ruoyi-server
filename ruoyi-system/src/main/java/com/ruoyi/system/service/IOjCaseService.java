package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjCase;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 题目样例Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjCaseService extends IService<OjCase> {
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
     * 批量删除题目样例
     *
     * @param caseIds 需要删除的题目样例主键集合
     * @return 结果
     */
    public int deleteOjCaseByCaseIds(Long[] caseIds);

    /**
     * 删除题目样例信息
     *
     * @param caseId 题目样例主键
     * @return 结果
     */
    public int deleteOjCaseByCaseId(Long caseId);
}
