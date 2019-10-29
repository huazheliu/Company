import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Company from '@/components/Company'
import SignUp from '@/components/SignUp'
import Map from '@/components/Map'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name:'home',
      component:Home,
      redirect:'/company',
      children:[
        {
          path:'/company',
          naem:'company',
          component:Company
        },
        {
          path:'/signUp',
          naem:'signUp',
          component:SignUp
        },
        {
          path:'/map',
          naem:'map',
          component:Map
        },
      ]
    }
  ]
})
