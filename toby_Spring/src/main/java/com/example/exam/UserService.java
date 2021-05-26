package com.example.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserService {

    //DI
    //1. 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다. 그러기 위해서는 인터페이스에만 의존하고 있어야 한다.
    //2. 런타임 시점의 의존관계는 컨테이너나 팩토리 같은 제 3의 존재가 결정한다.
    //3. 의존관계는 사용할 오브젝트에 대한 레퍼런스를 외부에서 제공해줌으로써 만들어진다.
    @Autowired
    private UserDao userDao;

    public UserService() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.userDao = context.getBean("userDao", UserDao.class);

        DaoFactory DaoFactory = new DaoFactory();
        this.userDao = DaoFactory.userDao();
    }
}
