
import axios from 'axios'

const MyHttpServer = {}

MyHttpServer.install =  (Vue)=> {
   
    //axios.defaults.baseRUL = 'http://localhost:8080/company/'
    //添加实例方法
    Vue.prototype.$http = axios
  }

  export default MyHttpServer