<template>
  <el-card class="box-card">
    <div style="margin-top: 15px;width:70%">
      <el-input placeholder="请输入公司名称，支持模糊查询" v-model="query" class="input-with-select">
        <el-button slot="append" icon="el-icon-search" @click="searchCompany()"></el-button>
      </el-input>
    </div>

    <el-table height="390px" :data="companyList" stripe style="width: 100%">
      <el-table-column prop="id" label="#"></el-table-column>
      <el-table-column prop="region" label="区域"></el-table-column>
      <el-table-column prop="position" label="展位号"></el-table-column>
      <el-table-column label="公司名称">
        <template slot-scope="scope">
          <a :href="scope.row.companyLink" @click="tipMessage(scope)">{{scope.row.name}}</a>
        </template>
      </el-table-column>
      <el-table-column prop="message" label="备注"></el-table-column>

      <el-table-column label="签到状态">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.sign_state"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-value="true"
            inactive-value="false"
            :disabled="prohibit"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="地点">
        <img class="map" src="../assets/map.png" alt="地图" @click="toMap()" />
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[20, 30, 50, 100]"
      :page-size="pageSize"
      layout="total, jumper"
      :total="total"
    ></el-pagination>
  </el-card>
</template>

<script>
export default {
  name: "Company",
  data() {
    return {
      //公司信息
      companyList: [],

      //分页相关的数据
      total: 1,
      currentPage: 1,
      pageSize: 20,

      //查询信息
      query: "",

      //switch禁止点击
      prohibit: true
    };
  },
  created() {
    this.getCompanyList();
  },
  methods: {
    getCompanyList() {
      this.$http
        .get(
          `http://localhost:8080/company/only/page?currentPage=${this.currentPage}&pageSize=${this.pageSize}`
        )
        .then(res => {
          //console.log(res);
          this.companyList = res.data.content;
          this.total = res.data.totalElements;
        });
    },

    //模糊查询公司信息
    searchCompany() {
      this.$http
        .get(`http://localhost:8080/company/search?name=${this.query}`)
        .then(res => {
         // console.log(res);
          this.companyList = res.data;
        });
    },

    //分页查询
    handleSizeChange(val) {
      //console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.currentPage = 1;
      this.getCompanyList();
    },
    handleCurrentChange(val) {
      //console.log(`当前页: ${val}`);
      this.currentPage = val;
      this.getCompanyList();
    },
    //查看地图
    toMap() {
      this.$router.push({
        path: "/map"
      });
    },
    //没有该公司信息
    tipMessage(scope){
        if(scope.row.companyLink=="#"){
          this.$message({
          message: '抱歉，暂无该公司信息',
          type: 'warning'
        });
        }
    }
  }
};
</script>

<style scope>
.box-card {
  height: 100%;
  text-align: center;
}
.el-select .el-input {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
.map {
  width: 25px;
  height: 25px;
}
.link {
  text-decoration-line: none;
}
</style>