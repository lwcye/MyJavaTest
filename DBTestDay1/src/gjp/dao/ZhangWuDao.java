package gjp.dao;

import gjp.tools.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

public class ZhangWuDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
}
