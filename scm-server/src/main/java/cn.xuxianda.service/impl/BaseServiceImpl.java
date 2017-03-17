package cn.xuxianda.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xuxianda.dao.AccountMapper;
import cn.xuxianda.dao.AccountRecordsMapper;
import cn.xuxianda.dao.BaseMapper;
import cn.xuxianda.dao.BuyOrderDetailMapper;
import cn.xuxianda.dao.BuyOrderMapper;
import cn.xuxianda.dao.DataElementMapper;
import cn.xuxianda.dao.DataElementNlvMapper;
import cn.xuxianda.dao.GoodsMapper;
import cn.xuxianda.dao.PermissionMapper;
import cn.xuxianda.dao.StoreHouseMapper;
import cn.xuxianda.dao.SupplierMapper;
import cn.xuxianda.entity.Page;
import cn.xuxianda.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{

	protected  BaseMapper<T> baseMapper;
	
	@Autowired
	protected  SupplierMapper supplierMapper;
	
	@Autowired
	protected  AccountMapper accountMapper;
	
	@Autowired
	protected SqlSessionFactoryBean sqlSessionFactoryBean;
	
	@Autowired
	protected DataElementNlvMapper dataElementNlvMapper;
	
	@Autowired
	protected DataElementMapper dataElementMapper;
	
	@Autowired
	protected GoodsMapper goodsMapper;
	
	@Autowired
	protected StoreHouseMapper storeHouseMapper;
	
	@Autowired
	protected BuyOrderMapper buyOrderMapper;
	
	@Autowired
	protected BuyOrderDetailMapper buyOrderDetailMapper;
	
	@Autowired
	protected AccountRecordsMapper accountRecordsMapper;
	
	@Autowired
	protected PermissionMapper permissionMapper;
	
	@PostConstruct//在构造方法后，初化前执行
	private void initBaseMapper() throws Exception{
		//完成以下逻辑，需要对研发本身进行命名与使用规范
		//this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		//在此以Account为例
		System.out.println("=======this :"+this);//cn.xuxianda.service.impl.AccountServiceImpl
		System.out.println("=======父类基本信息："+this.getClass().getSuperclass());//cn.xuxianda.service.impl.BaseServiceImpl
		System.out.println("=======父类和泛型的信息："+this.getClass().getGenericSuperclass());//cn.xuxianda.service.impl.BaseServiceImpl<cn.xuxianda.entity.Account>
		
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		//获取第一个参数的class 
		Class clazz = (Class)type.getActualTypeArguments()[0];//cn.xuxianda.entity.Account
		System.out.println("=======class:"+clazz);
		//转化为属性名（相关的Mapper子类的引用名）Supplier  supplierMapper
		String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";//accountMapper
		System.out.println("=======localField:"+localField);
		//getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
		Field field=this.getClass().getSuperclass().getDeclaredField(localField);
		System.out.println("=======field:"+field);//protected cn.xuxianda.dao.AccountMapper cn.xuxianda.service.impl.BaseServiceImpl.accountMapper
		System.out.println("=======field对应的对象:"+field.get(this));
		Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
		
		System.out.println("=======baseField:"+baseField);//protected cn.xuxianda.dao.BaseMapper cn.xuxianda.service.impl.BaseServiceImpl.baseMapper
		System.out.println("=======baseField对应的对象:"+baseField.get(this));	
		//field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中		
		baseField.set(this, field.get(this));		
		System.out.println("========baseField对应的对象:"+baseMapper);
	}	
	

	public int insert(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.insert(entity);
	}

	public int update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.update(entity);
	}

	public int delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.delete(entity);
	}

	public int deleteByIds(Long[] pks) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.deleteByIds(pks);
	}

	public T select(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.select(entity);
	}

	public Page<T> selectPage(Page<T> page) {
		page.setList(baseMapper.selectPageList(page));
		page.setTotalCount(baseMapper.selectPageCount(page));
		return page;
	}

	//动态分页查询
	public Page<T> selectPageUseDyc(Page<T> page) {
		page.setList(baseMapper.selectPageListUseDyc(page));
		page.setTotalCount(baseMapper.selectPageCountUseDyc(page));
		return page;
	}
	
	public void test() throws Exception{
		SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
		SqlSession session = sessionFactory.openSession();
		session.commit();
	}

}
