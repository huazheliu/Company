package cn.edu.gliet.companyinfo.controller;

import cn.edu.gliet.companyinfo.dao.CompanyRepository;
import cn.edu.gliet.companyinfo.pojo.Company;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Title: CompanyController
 * @Description:cn.edu.gliet.companyinfo.controller
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/21 9:17
 */

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    /*@RequestMapping(path = "/add")
    public String addNewCompany(@RequestParam(value="region",required=false) String region,@RequestParam(value="position",required=false) String position,@RequestParam(value="name",required=false) String name,@RequestParam(value="message",required=false) String message,@RequestParam(value="companyLink",required=false) String companyLink){
        Company company =new Company();
        company.setRegion(region);
        company.setPosition(position);
        company.setName(name);
        company.setMessage(message);
        company.setCompanyLink(companyLink);
        Company result = companyRepository.save(company);
        return JSON.toJSONString(result);
    }*/
    @RequestMapping("/add")
    public Company isSave(@ModelAttribute Company company){
        companyRepository.save(company);
        return company;
    }


    @PostMapping("/sign")
    @Transactional
    public String updateOne(@RequestParam("sign_state") String sign_state, @RequestParam("name") String name) {
        companyRepository.updateOne(sign_state,name);
        return "更新成功";
    }


    /**
     * 获取所有公司信息
     * @return
     */
    @GetMapping(path = "/all")
    public Iterable<Company> getAllUsers(){
        return companyRepository.findAll();
    }

    /**
     * 分页查询
     */
    @GetMapping(path = "/only/page")
    public Page<Company> getAllUserByOnlyPage(Integer currentPage, Integer pageSize){

        return companyRepository.findAll(PageRequest.of(currentPage-1,pageSize));

    }

    /**
     *排序查询
     * @param sortColumn
     * @return
     */
    @GetMapping(path = "/only/sort")
    public Iterable<Company> getAllUserBySort(String sortColumn){

        return companyRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC,sortColumn)));

    }

    /**
     * 分页和排序查询
     * @param currentPage
     * @param pageSize
     * @param sortColumn
     * @return
     */
    @GetMapping("/page")
    public Iterable<Company> getAllUserByPageandSort(Integer currentPage,Integer pageSize,String sortColumn){
        return companyRepository.findAll(PageRequest.of(currentPage-1, pageSize,Sort.by(new Sort.Order(Sort.Direction.ASC, sortColumn))));
    }

    /**
     * 固定字段查询
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/name/page")
    public Iterable<Company> getAllUserByNameandPage(String name, Integer currentPage, Integer pageSize){
        return companyRepository.findByName(name,PageRequest.of(currentPage-1,pageSize));
    }

    @GetMapping("/search")
    public Iterable<Company> findByNameLike(String name) {
        // 一定要加 "%"+参数名+"%"
        return companyRepository.findByNameLike("%"+name+"%");
    }
}
