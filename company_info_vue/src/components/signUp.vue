<template>
  <el-card class="box-card">
    <el-form :inline="true"  class="demo-form-inline">
      <el-form-item label="公司名称">
        <el-input v-model="query" placeholder="请输入公司全称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="showCompanyInfo()">查询</el-button>
      </el-form-item>
    </el-form>

    <!--对话框-->
    <el-dialog title="公司信息" :visible.sync="dialogFormVisible" width="90%" modal> 
      <el-form :model="form">
        <el-form-item label="公司名称" :label-width="formLabelWidth" >
          <el-input v-model="form.name" autocomplete="off" readonly></el-input>
        </el-form-item>
        <el-form-item label="公司区域" :label-width="formLabelWidth">
          <el-input v-model="form.region" autocomplete="off" readonly></el-input>
        </el-form-item>
        <el-form-item label="公司展位号" :label-width="formLabelWidth">
          <el-input v-model="form.position" autocomplete="off" readonly></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input v-model="form.message" autocomplete="off" readonly></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="sighUp()">确定并签到</el-button>
      </div>
    </el-dialog>
  </el-card>

  
</template>

<script>
export default {
  data() {
    return {
      //查询条件
      query:"",
      dialogFormVisible:false,
      //对话框内容
      form:{
        name:"",
        email:"",
        reprensent:"",
        id:"",
      },
      formLabelWidth: '120px',
      currentPage:1,
      pageSize:3,
      //禁用输入框
      readonly:true,
      sign_state:"true",
    };
  },
  methods: {
    showCompanyInfo() {
      this.dialogFormVisible=true;
      this.$http
      .get(`http://localhost:8080/company/search?name=${this.query}`)
      .then((res)=>{
        //console.log(res)
        this.form = JSON.parse(JSON.stringify(res.data[0]));
        //this.form = res.data;
        //console.log(this.form);
      })
    },
    sighUp(){
      
      this.$http
      .post(`http://localhost:8080/company/sign?sign_state=${this.sign_state}&name=${this.form.name}`)
      .then((res)=>{
        this.dialogFormVisible=false;
        this.$message({
            type: 'success',
            message: '恭喜您签到成功!'
          });
          this.$router.push({
            path:'/company'
          })
      })
    }
  }
};
</script>
<style
  .box-card{
  height: 100%;
  text-align: center
  }
</style>