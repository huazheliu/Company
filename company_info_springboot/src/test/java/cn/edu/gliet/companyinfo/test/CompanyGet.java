package cn.edu.gliet.companyinfo.test;

import cn.edu.gliet.companyinfo.pojo.Company;
import cn.edu.gliet.companyinfo.dao.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title: CompanyGet
 * @Description:cn.edu.guet.demo.test
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/19 10:19
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class CompanyGet {
    @Autowired
    public CompanyRepository companyRepository;

    @Test
    public void testBook() {
        Company company = new Company();
        System.out.println(company.getName());
    }
}
