package gjp.view;

import com.mysql.jdbc.log.LogUtils;
import gjp.dao.ZhangWuDao;
import gjp.domain.ZhangWu;
import gjp.service.ZhangWuService;
import one.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainView {
    ZhangWuService mZhangWuService = new ZhangWuService();

    /**
     * 显示界面
     */
    public void show() {
        /*
         * 1. 打印菜单 2. 获取用户输入 3. 调用对应方法
         */
        System.out.println("---------------管家婆家庭记账软件---------------");
        System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
        System.out.print("请输入要操作的功能序号[1-5]:");
        int index = new Scanner(System.in).nextInt();
        switch (index) {
            case 1:
                addZhangWu();
                break;
            case 2:
                editZhangWu();
                break;
            case 3:
                removeZhangwu();
                break;
            case 4:
                queryZhangwu();
                break;
            default:
                System.out.println("再见");
                System.exit(0);
                break;
        }
        show();
    }

    /**
     * 查询账务
     */
    private void queryZhangwu() {
        List<ZhangWu> zhangWus = mZhangWuService.queryAll();
        for (ZhangWu wus : zhangWus) {
            System.out.println(wus.toString());
        }
    }

    /**
     * 删除账务
     */
    private void removeZhangwu() {

    }

    /**
     * 编辑账务
     */
    private void editZhangWu() {

    }

    /**
     * 增加账务
     */
    private void addZhangWu() {
        mZhangWuService.insert(new ZhangWu(1, "吃饭支出", 247, "交通银行", "2016-03-02", "家庭聚餐"));
    }
}
