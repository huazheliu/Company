package cn.edu.gliet.companyinfo.service;

import cn.edu.gliet.companyinfo.dao.CompanyRepository;
import cn.edu.gliet.companyinfo.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: ComSer
 * @Description:cn.edu.gliet.companyinfo.service
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/20 12:26
 */
@Service
public class ComSer implements ComSerImpl {

    @Autowired
    private CompanyRepository companyRepository;
    private Object PageUtils;

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }


    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

}
