package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GuihaidingdanDao;
import com.entity.GuihaidingdanEntity;
import com.service.GuihaidingdanService;
import com.entity.vo.GuihaidingdanVO;
import com.entity.view.GuihaidingdanView;

@Service("guihaidingdanService")
public class GuihaidingdanServiceImpl extends ServiceImpl<GuihaidingdanDao, GuihaidingdanEntity> implements GuihaidingdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuihaidingdanEntity> page = this.selectPage(
                new Query<GuihaidingdanEntity>(params).getPage(),
                new EntityWrapper<GuihaidingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuihaidingdanEntity> wrapper) {
		  Page<GuihaidingdanView> page =new Query<GuihaidingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public List<String> selectAllChongdianbaoId() {
		List<GuihaidingdanEntity> guihaidingdanEntities = this.selectList(null);
		List<String> res = new ArrayList<String>();
		for (GuihaidingdanEntity g : guihaidingdanEntities) {
			res.add(g.getChongdianbaobianhao());
		}
		return res;
	}

	@Override
	public void deleteByZulinbianhao(Map<String, Object> zulinbianhao) {
		baseMapper.deleteByMap(zulinbianhao);
	}

	@Override
	public List<GuihaidingdanVO> selectListVO(Wrapper<GuihaidingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuihaidingdanVO selectVO(Wrapper<GuihaidingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuihaidingdanView> selectListView(Wrapper<GuihaidingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuihaidingdanView selectView(Wrapper<GuihaidingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
