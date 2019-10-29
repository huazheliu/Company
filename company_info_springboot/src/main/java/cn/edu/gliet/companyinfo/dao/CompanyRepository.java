package cn.edu.gliet.companyinfo.dao;

import cn.edu.gliet.companyinfo.pojo.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: CompanyDao
 * @Description:cn.edu.guet.demo
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/19 9:37
 */


public interface CompanyRepository extends JpaRepository<Company, Integer>{
    Page<Company> findByName(String name, Pageable pageable);
    //原生SQL实现更新方法接口
    @Query(value = "update info set sign_state=?1 where name=?2 ", nativeQuery = true)

    @Modifying
    public void updateOne(String sign_state, String name);

    Iterable<Company> findByNameLike(String name);
}
