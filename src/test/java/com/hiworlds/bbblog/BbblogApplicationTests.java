//package com.hiworlds.bbblog;
//
//
//import com.hiworlds.bbblog.domain.Post;
//import com.hiworlds.bbblog.domain.User;
//import com.hiworlds.bbblog.domain.home.HomeLiuyan;
//import com.hiworlds.bbblog.mapper.Dbtest01;
//import com.hiworlds.bbblog.mapper.LiuyanDao;
//import com.hiworlds.bbblog.mapper.PostDao;
//import com.hiworlds.bbblog.mapper.UserDao;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.List;
//
//
//@RunWith(SpringRunner.class)
//
//@SpringBootTest
//public class BbblogApplicationTests {
//
//    @Autowired
//    private Dbtest01 dbtest01;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private LiuyanDao liuyanDao;
//    @Autowired
//    private PostDao postDao;
//
//    @Test
//    public void test01() {
//        System.out.println(dbtest01);
//        List<User> all = dbtest01.findAllUsers();
//        for (User dbtest : all){
//            System.out.println(dbtest);
//        }
//    }
//
//    @Test
//    public void test02() throws InterruptedException {
//        User oneUserByEmail = userDao.findOneUserByEmail("coderlyz@qq.com");
//        System.out.println(oneUserByEmail);
//        List<HomeLiuyan> allLiuyansForhome = liuyanDao.findAllLiuyansForhome();
//        System.out.println(allLiuyansForhome);
//        System.out.println( (System.currentTimeMillis()+"").substring(9));
//        Thread.sleep(1000);
//        System.out.println( (new Date().getTime()+"0.0").substring(0));
//    }
//
////    @Test
////    public void test03(){
////        User user = new User();
////        user.setUser_create_time(new Date());
////        user.setUser_email("123dwdwad@QQ.com");;
////        userDao.saveUser(user);
////    }
//
//    @Test
//    public void test04(){
//        List<Post> allPostsByCategoryId = postDao.findAllPostsByCategoryId(20);
//        System.out.println(allPostsByCategoryId);
//    }
//
//}
