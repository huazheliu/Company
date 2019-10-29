package cn.edu.gliet.companyinfo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Title: Company
 * @Description:cn.edu.guet.demo
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/19 9:30
 */

@Entity
@Table(name="info")
@Data
public class Company{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String region;
    private String position;
    private String name;
    private String message;
    private String sign_state;
    private String companyLink;
    private String messageLink;
}
