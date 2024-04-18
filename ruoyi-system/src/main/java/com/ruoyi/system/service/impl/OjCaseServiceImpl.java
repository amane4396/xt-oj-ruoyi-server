package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjCaseMapper;
import com.ruoyi.system.domain.OjCase;
import com.ruoyi.system.service.IOjCaseService;

import javax.annotation.Resource;

/**
 * 题目样例Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjCaseServiceImpl extends ServiceImpl<OjCaseMapper, OjCase> implements IOjCaseService {
    @Autowired
    private OjCaseMapper ojCaseMapper;


    /**
     * 查询题目样例
     *
     * @param caseId 题目样例主键
     * @return 题目样例
     */
    @Override
    public OjCase selectOjCaseByCaseId(Long caseId) {
        return ojCaseMapper.selectOjCaseByCaseId(caseId);
    }

    /**
     * 查询题目样例列表
     *
     * @param ojCase 题目样例
     * @return 题目样例
     */
    @Override
    public List<OjCase> selectOjCaseList(OjCase ojCase) {
        return ojCaseMapper.selectOjCaseList(ojCase);
    }

    /**
     * 新增题目样例
     *
     * @param ojCase 题目样例
     * @return 结果
     */
    @Override
    public int insertOjCase(OjCase ojCase) {
        ojCase.setCreateTime(DateUtils.getNowDate());
        return ojCaseMapper.insertOjCase(ojCase);
    }

    /**
     * 修改题目样例
     *
     * @param ojCase 题目样例
     * @return 结果
     */
    @Override
    public int updateOjCase(OjCase ojCase) {
        ojCase.setUpdateTime(DateUtils.getNowDate());
        return ojCaseMapper.updateOjCase(ojCase);
    }

    /**
     * 批量删除题目样例
     *
     * @param caseIds 需要删除的题目样例主键
     * @return 结果
     */
    @Override
    public int deleteOjCaseByCaseIds(Long[] caseIds) {
        return ojCaseMapper.deleteOjCaseByCaseIds(caseIds);
    }

    /**
     * 删除题目样例信息
     *
     * @param caseId 题目样例主键
     * @return 结果
     */
    @Override
    public int deleteOjCaseByCaseId(Long caseId) {
        return ojCaseMapper.deleteOjCaseByCaseId(caseId);
    }
}
