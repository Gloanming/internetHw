package com.together.date.ControllerTest.mapper;

import com.together.date.Dao.activityDao;
import com.together.date.Dao.userDao;
import com.together.date.DateApplication;
import com.together.date.Vo.addActivityVo;
import com.together.date.service.entity.Activity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(classes = DateApplication.class)
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class ActivityDaoTest {
    @Autowired
    activityDao ActivityDao;
    @Test
    public void AddActivityTest1() {
<<<<<<< HEAD
        addActivityVo activityVo = new addActivityVo("1", "1", "休闲", "睡觉", "一起睡大觉","8:00", "18:00", 0, 10, 0, 0, "http");
=======
        addActivityVo activityVo = new addActivityVo("1", 6, "休闲", "睡觉", "一起睡大觉","8:00", "18:00", 0, 10, 0, 0, "#");
>>>>>>> 86da5eabbe58ad4728b87ce80a1b17fd06271f45
        ActivityDao.addActivity(activityVo);
    }

    @Test
    public void AddActivityTest2() {
<<<<<<< HEAD
        addActivityVo activityVo = new addActivityVo("1", "2", "休闲", "睡觉", "一起睡大觉","8:00", "18:00", 10, 10, 0, 5, "http");
=======
        addActivityVo activityVo = new addActivityVo("1", 2, "休闲", "睡觉", "一起睡大觉","8:00", "18:00", 10, 10, 0, 5, "#");
>>>>>>> 86da5eabbe58ad4728b87ce80a1b17fd06271f45
        ActivityDao.addActivity(activityVo);
    }

    @Test
    public void AddActivityTest3() {
<<<<<<< HEAD
        addActivityVo activityVo = new addActivityVo("1", "5", "学习", "通宵学习", "一起通宵学习","8:00", "18:00", 8, 10, 0, 8, "http");
=======
        addActivityVo activityVo = new addActivityVo("1", 5, "学习", "通宵学习", "一起通宵学习","8:00", "18:00", 8, 10, 0, 8, "#");
>>>>>>> 86da5eabbe58ad4728b87ce80a1b17fd06271f45
        ActivityDao.addActivity(activityVo);
    }

    @Test
    public void deleteActivityTest1(){
<<<<<<< HEAD
        ActivityDao.deleteActivity("1");
=======
        ActivityDao.deleteActivity(2);
>>>>>>> 86da5eabbe58ad4728b87ce80a1b17fd06271f45
    }

    @Test
    public void searchActivityByCreatorIdTest1() {
        List<Activity> list =  ActivityDao.searchByCreatorId("1");
        for (Activity activity : list) {
            System.out.println(activity.getContent());
        }
    }

    @Test
    public void searchActivityByTypeTest1() {
        List<Activity> list =  ActivityDao.searchByType("闲");
        for (Activity activity : list) {
            System.out.println(activity.getContent());
        }
    }

    @Test
    public void searchActivityByLikeTest1() {
        List<Activity> list =  ActivityDao.searchByLike();
        for (Activity activity : list) {
            System.out.println(activity.getContent());
        }
    }

    @Test
    public void searchActivityByActivityIdTest1() {
        List<Activity> list =  ActivityDao.searchByActivityId(5);
        for (Activity activity : list) {
            System.out.println(activity.getContent());
        }
    }

    @Test
    public void addLikeTest1() {
        ActivityDao.addLike(3);
    }

    @Test
    public void cancelTest1() {
        ActivityDao.cancelLike(3);
    }
}
