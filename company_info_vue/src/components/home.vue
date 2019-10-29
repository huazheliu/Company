<template>
  <el-container>
    <el-header >
      <el-row>
        <el-col :span="3">
          <div>
              <img class="pic_logo" src="../assets/guet.png" alt="桂电校徽">
          </div>
        </el-col>
        <el-col :span="20">
          <div>
              <h1 class="title">2020届桂电双选会</h1>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
        <router-view></router-view>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="24">
          <p class="foot">Copyright © 桂林电子科技大学</p>
          <p class="foot">
            <a href="http://www.yiban.cn" class="link">桂电易班管理中心</a>
            ||
            <a href="http://beian.miit.gov.cn/state/outPortal/loginPortal.action" class="link">桂ICP备18009075号-1</a></p>
        </el-col>
      </el-row>
        
    </el-footer>
  </el-container>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: white;;
    text-align: center;
    line-height: 80%;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    height: 100%;
    line-height: 100%;
    width: 100%
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }

  .pic_logo{
    width: 50px;
    height: 50px;
  }

  .link{
    color:white;
    text-decoration: none 
  }
</style>