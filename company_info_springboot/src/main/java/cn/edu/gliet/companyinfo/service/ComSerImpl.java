package cn.edu.gliet.companyinfo.service;

import cn.edu.gliet.companyinfo.pojo.Company;

import java.util.List;
import java.util.Map;

/**
 * @Title: ComSerImpl
 * @Description:cn.edu.gliet.companyinfo.service
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/20 12:26
 */
public interface ComSerImpl{


    public List<Company> getCompanyList();

    public void save(Company company);

}
