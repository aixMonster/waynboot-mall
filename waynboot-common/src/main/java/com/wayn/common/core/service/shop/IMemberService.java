package com.wayn.common.core.service.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wayn.common.core.entity.shop.Member;

/**
 * 用户表 服务类
 *
 * @author wayn
 * @since 2020-07-21
 */
public interface IMemberService extends IService<Member> {

    /**
     * 查询会员分页列表
     *
     * @param page   分页对象
     * @param member 查询参数
     * @return 会员分页列表
     */
    IPage<Member> listPage(Page<Member> page, Member member);

}
