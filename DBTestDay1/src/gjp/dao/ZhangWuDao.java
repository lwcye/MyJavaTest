package gjp.dao;

import gjp.domain.ZhangWu;
import gjp.tools.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import two.day01Bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZhangWuDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

    public List<ZhangWu> queryAll() {
        List<ZhangWu> mQuery = new ArrayList<>();
        try {
            //执行SQL语句
            String sql = "select * FROM gjp_zhangwu";
//            mQuery = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class));
            Object[] query = queryRunner.query(sql, new ArrayHandler());

        } catch (SQLException mE) {
            mE.printStackTrace();
        }
        return mQuery;
    }

    /**
     * 插入实体
     *
     * @param mZhangWu
     * @return
     */
    public boolean insert(ZhangWu mZhangWu) {
        String sql = "INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?,?);";
        Object[] params = {mZhangWu.getZwid(), mZhangWu.getFlname(), mZhangWu.getMoney(), mZhangWu.getZhangHu(),
                mZhangWu.getCreatetime(), mZhangWu.getDescription()};
        int line = 0;// 用来完成表数据的增加、删除、更新操作
        try {
            line = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line == 1;
    }
}
