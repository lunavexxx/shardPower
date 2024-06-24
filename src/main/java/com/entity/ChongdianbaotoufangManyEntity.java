package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 充电宝投放
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-20 21:03:47
 */
public class ChongdianbaotoufangManyEntity<T> implements Serializable {
	private static final long serialVersionUID = 2L;


	public ChongdianbaotoufangManyEntity() {

	}

	public ChongdianbaotoufangManyEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 数量
	 */
	private Long shuliang;
	
	/**
	 * 商户编号
	 */
					
	private String shanghubianhao;

	private String yajin;

	public String getYajin() {
		return yajin;
	}

	public void setYajin(String yajin) {
		this.yajin = yajin;
	}

	/**
	 * 商户名称
	 */
					
	private String shanghumingcheng;
	
	/**
	 * 详细地址
	 */
					
	private String xiangxidizhi;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 每小时费用
	 */
					
	private Integer meixiaoshifeiyong;
	
	/**
	 * 剩余电量
	 */
					
	private Integer shengyudianliang;
	
	/**
	 * 投放时间
	 */

	private String toufangshijian;

	public Long getShuliang() {
		return shuliang;
	}

	public void setShuliang(Long shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 设置：商户编号
	 */
	public void setShanghubianhao(String shanghubianhao) {
		this.shanghubianhao = shanghubianhao;
	}
	/**
	 * 获取：商户编号
	 */
	public String getShanghubianhao() {
		return shanghubianhao;
	}
	/**
	 * 设置：商户名称
	 */
	public void setShanghumingcheng(String shanghumingcheng) {
		this.shanghumingcheng = shanghumingcheng;
	}
	/**
	 * 获取：商户名称
	 */
	public String getShanghumingcheng() {
		return shanghumingcheng;
	}
	/**
	 * 设置：详细地址
	 */
	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return xiangxidizhi;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：区域
	 */
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
	/**
	 * 设置：每小时费用
	 */
	public void setMeixiaoshifeiyong(Integer meixiaoshifeiyong) {
		this.meixiaoshifeiyong = meixiaoshifeiyong;
	}
	/**
	 * 获取：每小时费用
	 */
	public Integer getMeixiaoshifeiyong() {
		return meixiaoshifeiyong;
	}
	/**
	 * 设置：剩余电量
	 */
	public void setShengyudianliang(Integer shengyudianliang) {
		this.shengyudianliang = shengyudianliang;
	}
	/**
	 * 获取：剩余电量
	 */
	public Integer getShengyudianliang() {
		return shengyudianliang;
	}


	public String getToufangshijian() {
		return toufangshijian;
	}

	public void setToufangshijian(String toufangshijian) {
		this.toufangshijian = toufangshijian;
	}
}
